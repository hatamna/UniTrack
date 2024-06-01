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
    
    
    public static File credentials = new File("userCredentials.txt");
    private static HashMap<String, String> userAndPass = new HashMap<>(); //MAKE SURE THAT THIS IS INFO SAFE
    
    
    
    public static void main(String[] args) throws IOException, GeneralSecurityException, InterruptedException {
        FirstView screen = new FirstView();
        screen.setVisible(true);
        screen.toFront();
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
                        FileWriter writer = new FileWriter("userCredentials.txt", true);
                        userAndPass.put(User.username, User.password);
                        writer.write(userAndPass + " | ");
                        writer.close();
                    } catch (IOException a){
                        System.out.println("An error has occured. ");
                    }
    }
}
