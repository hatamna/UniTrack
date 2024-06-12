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
    
    public ClassroomAssignment(){
        super();
        classroomCourse=true;
    }
    
    public ClassroomAssignment(String code,double grade,int weight){
        super(code, grade, weight);
        classroomCourse=true;
    }
    
    
}
