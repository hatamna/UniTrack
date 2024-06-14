/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.api.services.classroom.Classroom;
import com.google.api.services.classroom.model.Course;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.GridBagConstraints.RELATIVE;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
    
    private ArrayList<UniCourse> userCourses = new ArrayList<>();
    private ArrayList<Course> classroomCourses = new ArrayList<>();
    private HashMap<Course, UniCourse> linkedCourses = new HashMap<>();
    
    private Classroom classroomData = null;
    GridBagConstraints layout = new GridBagConstraints();
    private List<Course> studentCourseList;
    private ArrayList<Course> courseList;
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
    private Object[][] courseSelector;
    private boolean allowArchived;
    private int size;
    private JPanel courseButtons;
    private JPanel courseInfo;
    private JScrollPane scrollablePane;
    private JLayeredPane courseSelect;
    private JButton submit;
    private JPanel importPanel;
    
    public User() throws IOException, GeneralSecurityException, InterruptedException{
        SwingUtilities.invokeLater(() -> {
            try {
                this.createAccountSetup();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); //creates seperate thread for the gui
        waitForOAuth(); //pauses main code until OAuth complete
        
    }
    
    private void createAccountSetup() throws IOException{
        //Creating Frame and layout constraits
        setUpMenu = new JFrame("UniTrack | Creating user");
        
        //creating & setting up panes and panels for course selection
        courseSelect = new JLayeredPane();
        courseSelect.setPreferredSize(new Dimension(640,500));
        courseInfo = new JPanel(new GridBagLayout());
        courseInfo.setBounds(0,0,640,500);
        importPanel = new JPanel(new GridBagLayout());
        
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
        courseButtons = new JPanel(new GridLayout(((size+2)/3),3,5 ,5 ));
        courseButtons.setBounds(0,0,640,500);
        courseList = new ArrayList<>();
        courseSelector = new Object[size][5]; //one array per course 4 Jcomponents per
        SwingUtilities.invokeLater(() -> {
            for(int x=0; x<size; x++){
                Course studentCourse =studentCourseList.get(x);
                //if(!(studentCourse.getCourseState().equals("ARCHIVED")&&allowArchived) && !studentCourse.getCourseState().equals("ACTIVE")) continue;
                
                //adds course
                courseSelector[x][0]=studentCourse;
                
                //displays course name
                courseSelector[x][1]=new JLabel(studentCourse.getName());
                layout.gridx=(x % 4 == 0 || x % 4 == 3) ? 0 : (x % 4 == 1) ? 225 : 450;
                layout.gridy=0+(260*(x/3));
                layout.gridwidth=3;
                layout.gridheight=1;
                layout.insets = new Insets(0, 0, 0, 10);
                courseInfo.add((Component)courseSelector[x][1], layout);
                layout.insets = new Insets(0,0,0,0);
                
                //displays course section
                courseSelector[x][2]=new JLabel(studentCourse.getSection());
                layout.gridy=RELATIVE;
                layout.gridwidth=2;
                layout.gridheight=1;
                layout.insets = new Insets(0, 0, 180, 0);
                courseInfo.add((Component)courseSelector[x][2], layout);
                layout.insets = new Insets(0, 0, 0, 0);
               
                //button to open the course in google classroom
                courseSelector[x][3]=new JButton("Open in classroom");
                ((JButton)courseSelector[x][3]).setOpaque(false);
                ((JButton)courseSelector[x][3]).setContentAreaFilled(false);
                ((JButton)courseSelector[x][3]).setBorderPainted(false);
                ((JButton)courseSelector[x][3]).addActionListener(new ActionListener(){ 
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
                layout.gridx=layout.gridx+180;
                layout.gridy=50+(260*(x/3));
                layout.gridwidth=5;
                layout.gridheight=1;
                courseInfo.add((Component)courseSelector[x][3], layout);
                
                //adds button to select course
                courseSelector[x][4]=new JToggleButton();
                ((JToggleButton)courseSelector[x][4]).setPreferredSize(new Dimension(200,240));
                courseButtons.add((Component)courseSelector[x][4]);
            }
            
            //add labels to keep grid patern
            for(int x=0;x<(((size+2)/3)*3)-size; x++){
                courseButtons.add(new JLabel());
            }
            
            //finish button
            submit= new JButton("Import");
            submit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
//                    for(int x=0; x<size; x++){
//                        if(!((JToggleButton)courseSelector[x][4]).isSelected()) continue;
//                        classroomCourses.add(courseSelector[x][0]);                    
//                    }
                    
                    addUniCourses();
                    
                    //done importing
                    setUpMenu.remove(importPanel);
                    
                    //update gui
                    setUpMenu.revalidate();
                    setUpMenu.repaint();
                }
            });
            submit.setPreferredSize(new Dimension(100,100));
            
            //adding panels to layered pane
            courseButtons.setBackground(Color.LIGHT_GRAY);
            courseSelect.add(courseInfo, JLayeredPane.PALETTE_LAYER);
            courseInfo.setOpaque(false);
            courseSelect.add(courseButtons, JLayeredPane.DEFAULT_LAYER);
            
            //setup scrollable pane
            scrollablePane = new JScrollPane(courseSelect);
            scrollablePane.setMinimumSize(new Dimension(660,500));
            importPanel.add(scrollablePane);
            importPanel.add(submit, layout);
            setUpMenu.add(importPanel, CENTER);
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
    
    public void addUniCourses(){
        //loop through classes to add courses
//        for(Course x :classroomCourses){
//            linkedCourses.add(x, new UniCourse());
//            userCourses.add(linkedCourses.get(x));
////            loop through assignments and add them
//            for(CourseWork y: x.courseWork().list(x).execute().getCourseWork()){
//                if (y.getAssignedGrade()==null) continue; //if its not marked dont add it
//                
//                if(y.getGradeCategory==null){
//                    linkedCourses.get(x).addAssignment(new Assignment(y.getTitle(),y.getAssignedGrade())); //only name and grade
//                }
//                
//                else{ //adds name grade and category (weight is assigned to categories not assignments)
//                    linkedCourses.get(x).addAssignment(new Assignment(y.getTitle(),y.getAssignedGrade(),y.getGradeCategory())); 
//                }
//            }
//        }
    }
        
}
