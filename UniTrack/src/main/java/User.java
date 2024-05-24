/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;
/**
 *
 * @author krish
 */
public class User {
    
    private static Scanner input = new Scanner(System.in);
    
    public User() throws IOException, GeneralSecurityException{
        System.out.println("Would you like to import your data? y or n");
        if(input.nextLine().equals("y")){
            Import.importUserData();
        }
    }
}
