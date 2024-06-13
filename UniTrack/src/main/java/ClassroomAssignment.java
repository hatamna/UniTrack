/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kshar1
 */
public class ClassroomAssignment extends Assignment {
    
    private boolean classroomCourse;
    private String name;
    private String category;
    private double grade;
    
    public ClassroomAssignment(){
        super();
        classroomCourse=true;
    }
    
    public ClassroomAssignment(String n,double g, String c){
        name=n;
        grade=g;
        category=c;
        classroomCourse=true;
    }
    
    public ClassroomAssignment(String n,double g){
        name=n;
        grade=g;
        classroomCourse=true;
    }
    
    
}
