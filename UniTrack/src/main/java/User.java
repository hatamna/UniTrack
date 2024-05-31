/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.api.services.classroom.Classroom;
import com.google.api.services.classroom.model.Course;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author krish
 */
public class User {
    
    private static Classroom classroomData = null;
    private static SortedMap<UniCourse, Double> userCourses = new TreeMap<>();
    private static Course[] courseList;
    private static Thread OAuth = null;
    private static String username;
    
    private JFrame setUpMenu;
    private JPanel accountCreation;
    private JPanel importing;
    private JLabel askImport;
    private JButton yes;
    private JButton no;
    private JLabel welcomeText;
    private JLabel usernameText;
    private JLabel passwordText;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton createAccount;
    private JLabel errorMessage;
    private JPanel classSelection;
    
    public User() throws IOException, GeneralSecurityException, InterruptedException{
        SwingUtilities.invokeLater(this::createAccountSetup); //creates seperate thread for the gui
        waitForOAuth(); //pauses main code until OAuth complete
        courseList= new Course[Import.getCourses(classroomData).size()];
        
    }
    
    private void createAccountSetup(){
        //Creating Frame and layout constraits
        setUpMenu = new JFrame("UniTrack | Creating user");
        GridBagConstraints layout = new GridBagConstraints();
        
        //panel and elements for account creation
        accountCreation = new JPanel(new GridBagLayout());
        welcomeText = new JLabel("Welcome to UniTrack account creation! ");
        usernameText = new JLabel("Username:");
        passwordText = new JLabel("Password:");
        usernameInput = new JTextField();
        passwordInput = new JPasswordField();
        createAccount = new JButton("Create account");
        errorMessage = new JLabel();
        
        //adding elements to pannel
        layout.gridx=0;
        layout.gridy=0;
        layout.gridwidth=3;
        layout.gridheight=1;
        accountCreation.add(welcomeText, layout);
        layout.gridx=2;
        layout.gridy=1;
        layout.gridwidth=3;
        layout. gridheight=1;
        layout.fill = GridBagConstraints.HORIZONTAL;
        accountCreation.add(usernameInput, layout);
        layout.gridx=2;
        layout.gridy=2;
        layout.gridwidth=3;
        layout.gridheight=1;
        layout.fill = GridBagConstraints.HORIZONTAL;
        accountCreation.add(passwordInput, layout);
        layout.gridx=1;
        layout.gridy=1;
        layout.gridwidth=1;
        layout.gridheight=1;
        accountCreation.add(usernameText, layout);
        layout.gridx=1;
        layout.gridy=2;
        layout.gridwidth=1;
        layout.gridheight=1;
        accountCreation.add(passwordText, layout);
        layout.gridx=3;
        layout.gridy=3;
        layout.gridwidth=2;
        layout.gridheight=1;
        accountCreation.add(createAccount,layout);
        layout.gridx=1;
        layout.gridy=3;
        layout.gridwidth=1;
        layout.gridheight=1;
        accountCreation.add(errorMessage, layout);
        
        //panel and elements for importing
        importing = new JPanel();
        askImport = new JLabel("Would you like to your import grades from google classroom?"); 
        no = new JButton("no"); 
        yes = new JButton("yes"); 
        
        //adding elements to panel
        importing.add(askImport);
        importing.add(yes);
        importing.add(no);
        
        //elements after import
        JLabel imported = new JLabel("Imported data from Google Classroom"); //import completed
        
        //button actions
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                startOAuth();
            }
        });
        no.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0); //change this later
            }
        });
        createAccount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                username=usernameInput.getText();
                if(UniTrack.getUserAndPass().get(username)!=null || username.length()<5){ //if username alr exists say invalid
                    errorMessage.setText("Invalid username");
                    
                    //updating jframe visuals
                    setUpMenu.revalidate();
                    setUpMenu.repaint();
                }
                else{
                    setUpMenu.remove(errorMessage); //remove invalid msg cuz its valid
                    
                    //updating jframe visuals
                    setUpMenu.revalidate();
                    setUpMenu.repaint();
                    
                    UniTrack.getUserAndPass().put(usernameInput.getText(), passwordInput.getText()); //saving user and pass
                
                    //remove account creation
                    setUpMenu.remove(accountCreation);

                    //setup import prompt
                    setUpMenu.add(importing);

                    //updating jframe visuals
                    setUpMenu.revalidate();
                    setUpMenu.repaint();
                }
            }
        });
        
        //set window size and layout
        setUpMenu.setSize(400,400);
        setUpMenu.getContentPane().setLayout(new java.awt.FlowLayout()); //random temp layout
        
        //setting window locations
        setUpMenu.setLocationRelativeTo(null);
        
        //settingup account creation
        setUpMenu.add(accountCreation);
        setUpMenu.setVisible(true);
    }
    
    private void startOAuth(){
        if(OAuth==null) {
            OAuth= new Thread(new Runnable(){
                @Override
                public void run(){
                    try {
                        classroomData = Import.getClassroomData();
                    }
                    catch (IOException | GeneralSecurityException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            OAuth.start();
        }
        else{
            yes.setEnabled(false);
            askImport.setText("OAuth in progress");
        }
    }
    
    private void waitForOAuth() throws InterruptedException{
        if(OAuth!=null){
            OAuth.join();
        }
    }
}
