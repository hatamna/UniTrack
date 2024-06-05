
import java.util.Arrays;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yahya
 */
public class uniInfo {
    
    
    
    static HashMap<String, HashMap> uOttawa = new HashMap<>();
    static HashMap<String, HashMap> uToronto = new HashMap<>();
    
    static HashMap<String, Double> UOPrograms = new HashMap<>();
    static HashMap<String, Double> UTPrograms = new HashMap<>();
    
    static String[] universities = {"uOttawa", "uToronto"};
    
    public static void putty(){
        UOPrograms.put("Computer Science", 93.00); 
        UOPrograms.put("Biology", 85.00); 
        UOPrograms.put("Software Engineering", 89.00); 
        uOttawa.put("uOttawa", UOPrograms);
        
        UTPrograms.put("Computer Science", 95.00);
        UTPrograms.put("Civil Engineering", 85.00);
        UTPrograms.put("Life Sciences", 85.00);
        uToronto.put("uToronto", UTPrograms);
        
        System.out.println(UOPrograms.toString());
    }

    
    
}
