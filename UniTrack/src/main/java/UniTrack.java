import java.io.FileWriter;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author krish
 */
public class UniTrack {
    
    public static String[] top6Courses = new String[6];
    
    public static int universalNum = 0;
    
    
    public static File credentials = new File("" + User.username + ".txt");
    private static HashMap<String, String> userAndPass = new HashMap<>(); //MAKE SURE THAT THIS IS INFO SAFE
    
    public static int numProfiles = 0;
    
    public static void main(String[] args) throws IOException, GeneralSecurityException, InterruptedException {
        /*
        FirstView screen = new FirstView();
        screen.setVisible(true);
        screen.toFront();
        */
        uniInfo uni = new uniInfo();
        if (numProfiles == 0){
        ChoiceScreen screen = new ChoiceScreen();
        screen.setVisible(true);
        screen.toFront();
        } else {
            profileSelectScreen screen = new profileSelectScreen();
            screen.setVisible(true);
            screen.toFront();
        }
    }
   
    
    public static HashMap<String, String> getUserAndPass(){
        return userAndPass;
    }
    
    public static void saveCreds(){
        // new file with account info
        try{
            if (credentials.createNewFile()){
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists. ");
            }
        } catch (IOException a){
            System.out.println("An error has occured. ");
        }
        try{
            FileWriter writer = new FileWriter("" + User.username + ".txt", true);
            userAndPass.put(User.username, User.password);
            writer.write(userAndPass + " | ");
            writer.close();
            numProfiles += 1;
        } catch (IOException a){
            System.out.println("An error has occured. ");
        }
    }
    public static String[] getTop6() {
        return top6Courses;
    }
}
