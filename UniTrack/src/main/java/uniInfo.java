
import static java.lang.Double.parseDouble;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

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
    
    public static Set<String> ottawa;
    public static double[] ottGrades = {0, 0, 0, 0};
    
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
        
        ottawa = UOPrograms.keySet();
        
        System.out.println(UOPrograms.entrySet());
        
        System.out.println(ottawa);
        
        for (int i = 0; i < 3; i++){
            ottGrades[i] = parseDouble(String.valueOf(UOPrograms.values().toArray()[i])); //FIX
        }
        
        System.out.println(UOPrograms.keySet().toArray()[1]);
    }

    
    
}
