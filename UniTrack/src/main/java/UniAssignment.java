/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kshar1
 */
public class UniAssignment {
    
    private String code;
    private double grade;
    private int weight;
    
    public UniAssignment(String c, double g, int w){
        code=c;
        grade=g;
        weight=w;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public double getGrade(){
        return grade;
    }
    
    public String getName(){
        return code;
    }
}
