
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
    
    
    public static final String PROG_NAME_01 = "Computer Science";
    public static final String PROG_NAME_02 = "Biology";
    public static final String PROG_NAME_03 = "Life Sciences";
    
    
    static HashMap<String, HashMap> uOttawa = new HashMap<>();
    static HashMap<String, HashMap> uToronto = new HashMap<>();
    
    static HashMap<String, Double> UOPrograms = new HashMap<>();
    static HashMap<String, Double> UTPrograms = new HashMap<>();
    
    public static Set<String> ottawa;
    public static Set<String> toronto;
    public static double[] ottGrades = {0, 0, 0};
    public static double[] torGrades = {0, 0, 0};
    
    static String[] universities = {"uOttawa", "uToronto"};
    
    public static void putty(){
        UOPrograms.put(PROG_NAME_01, 90.00); 
        UOPrograms.put(PROG_NAME_02, 89.00); 
        UOPrograms.put(PROG_NAME_03, 87.00); 
        uOttawa.put("uOttawa", UOPrograms);
        
        UTPrograms.put(PROG_NAME_01, 99.00);
        UTPrograms.put(PROG_NAME_02, 95.00);
        UTPrograms.put(PROG_NAME_03, 97.00);
        uToronto.put("uToronto", UTPrograms);
        
        ottawa = UOPrograms.keySet();
        toronto = UTPrograms.keySet();
        
        for (int i = 0; i < 3; i++){
            ottGrades[i] = parseDouble(String.valueOf(UOPrograms.values().toArray()[i])); //FIX
        }
        
        for (int i = 0; i < 3; i++){
            torGrades[i] = parseDouble(String.valueOf(UTPrograms.values().toArray()[i])); //FIX
        }
    }

    
    
}
