/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.api.services.classroom.Classroom;
import com.google.api.services.classroom.model.Course;
import static java.awt.BorderLayout.SOUTH;
//import javax.swing.JToggleButton.isSelected;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.GridBagConstraints.RELATIVE;
import java.awt.Insets;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author krish
 */
public class User {
    
    private Classroom classroomData = null;
    private SortedMap<UniCourse, Double> userCourses = new TreeMap<>();
    GridBagConstraints layout = new GridBagConstraints();
    private List<Course> studentCourseList;
    private Course[] courseList;
    private Thread OAuth = null;
    public static String username;
    public static String password;
    private JFrame setUpMenu;
    private JPanel accountCreation;
    private JPanel importing;
    private JLabel askImport;
    private JButton yes;
    private JButton no;
    private JButton back;
    private JLabel welcomeText;
    private JLabel usernameText;
    private JLabel passwordText;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton createAccount;
    private JLabel errorMessage;
    private JPanel courseSelection;
    private JComponent[][] courseSelector;
    private Object[][] courseAndID;
    private boolean allowArchived;
    private int size;
    private JPanel courseButtons;
    private JPanel courseInfo;
    private JScrollPane scrollablePane;
    private JLayeredPane courseSelect;
    
    public User() throws IOException, GeneralSecurityException, InterruptedException{
        SwingUtilities.invokeLater(this::createAccountSetup); //creates seperate thread for the gui
        waitForOAuth(); //pauses main code until OAuth complete
        
    }
    
    private void createAccountSetup(){
        //Creating Frame and layout constraits
        setUpMenu = new JFrame("UniTrack | Creating user");
        
        //creating & setting up panes and panels for course selection
        courseSelect = new JLayeredPane();
        courseSelect.setPreferredSize(new Dimension(500,500));
        courseButtons = new JPanel(new GridBagLayout());
        courseButtons.setBounds(0,0,500,500);
        courseInfo = new JPanel(new GridBagLayout());
        courseInfo.setBounds(0,0,500,500);
        
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
        no = new JButton("Add Classes Manually"); 
        yes = new JButton("yes"); 
        back = new JButton("BACK");
        
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
                try {
                    startOAuth();
                } catch (IOException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        no.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AddClassScreen screen = new AddClassScreen();
                screen.setVisible(true);
                screen.toFront();
                setUpMenu.dispose();
            }
        });
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ChoiceScreen screen = new ChoiceScreen();
                screen.setVisible(true);
                screen.toFront();
                setUpMenu.dispose();
            }
        });
        createAccount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                username = usernameInput.getText();
                password = passwordInput.getText();
                if(UniTrack.getUserAndPass().get(username)!=null || username.length()<5){ //if username alr exists say invalid
                    errorMessage.setText("Invalid username");
                    
                    //updating jframe visuals
                    setUpMenu.revalidate();
                    setUpMenu.repaint();
                }
                else{
                    setUpMenu.remove(errorMessage); //remove invalid msg cuz its valid
                    UniTrack.saveCreds();
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
        setUpMenu.setSize(800,600);
        setUpMenu.getContentPane().setLayout(new java.awt.BorderLayout()); //random temp layout
        setUpMenu.getContentPane().add(back, SOUTH);
        
        //setting window locations
        setUpMenu.setLocationRelativeTo(null);
        
        //settingup account creation
        setUpMenu.add(accountCreation);
        //setUpMenu.setUndecorated(true);
        setUpMenu.setResizable(false);
        setUpMenu.setVisible(true);
    }
    
    private void startOAuth() throws IOException, InterruptedException, URISyntaxException{
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
            OAuth.join();
        }
        else{
            yes.setEnabled(false);
            askImport.setText("OAuth in progress");
        }
        
        studentCourseList=Import.getCourses(classroomData); //used in for loop DO NOT TOUCH
        size=Import.getCourses(classroomData).size();
        courseList= new Course[size]; //list of courses that are selected
        courseSelector = new JComponent[size][4]; //one array per course 4 Jcomponents per
        courseAndID = new Object[size][size];
        SwingUtilities.invokeLater(() -> {
            for(int x=0; x<size; x++){
                Course studentCourse =studentCourseList.get(x);
                //if(!(studentCourse.getCourseState().equals("ARCHIVED")&&allowArchived) && !studentCourse.getCourseState().equals("ACTIVE")) continue;
                
                //displays course name
                courseSelector[x][0]=new JLabel(studentCourse.getName());
                layout.gridx=1*(x+1)+(220*(x));
                layout.gridy=0;
                layout.gridwidth=3;
                layout.gridheight=1;
                layout.insets = new Insets(0, 0, 0, 10);
                courseInfo.add(courseSelector[x][0], layout);
                layout.insets = new Insets(0,0,0,0);
                
                //displays course section
                courseSelector[x][1]=new JLabel(studentCourse.getSection());
                layout.gridx=1*(x+1)+(220*(x));
                layout.gridy=RELATIVE;
                layout.gridwidth=2;
                layout.gridheight=1;
                layout.insets = new Insets(0, 0, 180, 0);
                courseInfo.add(courseSelector[x][1], layout);
                layout.insets = new Insets(0, 0, 0, 0);
               
                //button to open the course in google classroom
                courseSelector[x][2]=new JButton("Open in classroom");
                courseSelector[x][2].setOpaque(false);
                ((JButton)courseSelector[x][2]).setContentAreaFilled(false);
                ((JButton)courseSelector[x][2]).setBorderPainted(false);
                ((JButton)courseSelector[x][2]).addActionListener(new ActionListener(){ 
                    @Override
                    public void actionPerformed(ActionEvent e){
                        try {
                            Desktop.getDesktop().browse(new URI(studentCourse.getAlternateLink()));
                        } 
                        catch (IOException | URISyntaxException ex) {
                            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                layout.gridx=5*(x+1)+(220*(x));
                layout.gridy=50;
                layout.gridwidth=5;
                layout.gridheight=1;
                courseInfo.add(courseSelector[x][2], layout);
                
                //adds button to select course
                courseSelector[x][3]=new JToggleButton();
                courseSelector[x][3].setPreferredSize(new Dimension(200,240));
                /*((JToggleButton)courseSelector[x][3]).addActionListener(new ActionListener() {
                   @Override
                   
                   public void actionPerformed(ActionEvent e){
                        if(courseSelector[x][3].isSelected()){
                           courseList[x]=studentCourse;
                       }
                   }
                });*/
                layout.gridx=5*(x+1)+(200*x);
                layout.gridy=240;
                layout.gridwidth=200;
                layout.gridheight=240;
                layout.insets = new Insets(0, 0, 10, 10);
                courseButtons.add(courseSelector[x][3], layout);
                layout.insets = new Insets(0, 0, 0, 0);
            }
            //adding panels to layered pane
            courseButtons.setBackground(Color.LIGHT_GRAY);
            courseSelect.add(courseInfo, JLayeredPane.PALETTE_LAYER);
            courseInfo.setOpaque(false);
            courseSelect.add(courseButtons, JLayeredPane.DEFAULT_LAYER);
            
            //setup scrollable pane
            scrollablePane = new JScrollPane(courseSelect);
            setUpMenu.add(scrollablePane);
            setUpMenu.remove(importing);
            
            //update gui
            setUpMenu.revalidate();
            setUpMenu.repaint();
        });
        
    }
    
    private void waitForOAuth() throws InterruptedException{
        if(OAuth!=null){
            OAuth.join();
        }
        
    }
        
}
