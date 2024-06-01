
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
        FirstView screen = new FirstView();
        screen.setVisible(true);
        screen.toFront();
    }
   
    
    public static HashMap<String, String> getUserAndPass(){
        return userAndPass;
    }
}
