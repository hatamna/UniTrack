/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.api.services.classroom.Classroom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author krish
 */
public class User {
    
    private static Scanner input = new Scanner(System.in);
    private static Classroom classroomData = null;
    private static SortedMap<UniCourse, Double> userCourses = new TreeMap<>();
    private static Thread OAuth = null;
    private static String username;
    private static String password;
    
    public User() throws IOException, GeneralSecurityException{
        //Creating Frame and elements
        JFrame setUpMenu = new JFrame("UniTrack | Creating user"); //frame
        
        //account creation
        JLabel welcomeText = new JLabel("Welcome to UniTrack account creation! ");
        JLabel usernameText = new JLabel("Username:");
        JLabel passwordText = new JLabel("Password:");
        JTextField usernameInput = new JTextField();
        JTextField passwordInput = new JTextField();
        JButton createAccount = new JButton("Create account");
        JLabel invalidUsername = new JLabel("Invalid username");
        
        //elements for importing
        JLabel askImport = new JLabel("Would you like to your import grades from google classroom?"); //import??
        JButton no = new JButton("no"); //dont import
        JButton yes = new JButton("yes"); //yes import
        
        //elements after import
        JLabel imported = new JLabel("Imported data from Google Classroom"); //import completed
        
        //button actions
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(OAuth==null){
                    OAuth= new Thread(new Runnable(){
                        @Override
                        public void run(){
                            try {
                                classroomData = Import.getClassroomData();
                            }
                            catch (IOException ex) {
                                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            catch (GeneralSecurityException ex) {
                             Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            //removing elements relating to importing
                            setUpMenu.remove(no);
                            setUpMenu.remove(yes);
                            setUpMenu.remove(askImport);
                            
                            //adding relevant elements
                            setUpMenu.getContentPane().add(imported);
                            
                            //updating jframe visuals
                            setUpMenu.revalidate();
                            setUpMenu.repaint();
                        }
                    });
                }
                else{
                    askImport.setText("Already importing bruh calm down");
                };
                OAuth.start();
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
                if(UniTrack.getUserAndPass().get(username)!=null){ //if username alr exists say invalid
                    setUpMenu.getContentPane().add(invalidUsername);
                }
                else{
                    setUpMenu.remove(invalidUsername); //remove invalid msg cuz its valid
                    
                    //updating jframe visuals
                    setUpMenu.revalidate();
                    setUpMenu.repaint();
                }
                UniTrack.getUserAndPass().put(usernameInput.getText(), passwordInput.getText()); //saving user and pass
                
                //remove account creation
                setUpMenu.remove(welcomeText);
                setUpMenu.remove(usernameText);
                setUpMenu.remove(passwordText);
                setUpMenu.remove(usernameInput);
                setUpMenu.remove(passwordInput);
                setUpMenu.remove(createAccount);
                
                //setup import prompt
                setUpMenu.getContentPane().add(askImport);
                setUpMenu.getContentPane().add(yes);
                setUpMenu.getContentPane().add(no);
                
                //updating jframe visuals
                setUpMenu.revalidate();
                setUpMenu.repaint();
                
            }
        });
        
        //set window size and layout
        setUpMenu.setSize(400,400);
        setUpMenu.getContentPane().setLayout(new java.awt.FlowLayout()); //random temp layout
        
        //setting element locations
        setUpMenu.setLocationRelativeTo(null);
        
        //settingup account creation
        setUpMenu.getContentPane().add(welcomeText);
        setUpMenu.getContentPane().add(usernameText);
        setUpMenu.getContentPane().add(passwordText);
        setUpMenu.getContentPane().add(usernameInput);
        setUpMenu.getContentPane().add(passwordInput);
        setUpMenu.getContentPane().add(createAccount);
        setUpMenu.setVisible(true);
        
        
        
    }
}
