
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author krish
 */
public class UniTrack {
    
    private static HashMap<String, String> userAndPass = new HashMap<>(); //MAKE SURE THAT THIS IS INFO SAFE
    
    
    
    public static void main(String[] args) throws IOException, GeneralSecurityException, InterruptedException {
        System.out.println("Creating user");
        createUser();
    }
    
    public static void createUser() throws IOException, GeneralSecurityException, InterruptedException{
        User test = new User();
    }
    
    public static HashMap<String, String> getUserAndPass(){
        return userAndPass;
    }
}
