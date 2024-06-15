
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krish
 */
public class UniCourse {
    
    private LinkedList<Assignment> assignments = new LinkedList<>();
    private String name;
    private double average;
    
    public UniCourse(){
        name = "Course";
        average = 0.0;
    }
    
    public UniCourse(String n, double a){
        name = n;
        average = a;
    }
    
    public void addAssignment(Assignment a){
        assignments.add(a);
    }
}
