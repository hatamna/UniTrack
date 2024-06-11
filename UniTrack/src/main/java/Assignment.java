/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kshar1
 */
public class Assignment {
    
    private String code;
    private double grade;
    private int weight;
    private boolean fromClassroom;
    
    public Assignment(){
        code=null;
        grade=0;
        weight=0;
        fromClassroom=false;
    }
    
    public Assignment(String c, double g, int w, boolean i){
        code=c;
        grade=g;
        weight=w;
        fromClassroom=i;
    }
}
