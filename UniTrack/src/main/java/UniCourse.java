
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
    
    private LinkedList<UniAssignment> assignments = new LinkedList<>();
    private String name;
    private double average;
    private ButtonColor color;
    private User user;
    private double weights;
    private double weightedGrades;
    
    public UniCourse(User u, String n){
        user=u;
        name=n;
        average=0.0;
    }
    
    public UniCourse(String n, double a, User u){
        name = n;
        average = a;
        user=u;
    }
    
    public LinkedList<UniAssignment> getAssignments(){
        return assignments;
    }
    
    public void addAssignment(UniAssignment a){
        assignments.add(a);
    }
    
    public int getWeight(){
        weights=0;
        for(UniAssignment a: assignments){
            weights+=a.getWeight();
        }
        return (int)weights;
    }
    
    public double updateAverage(){
        weights=0;
        weightedGrades=0;
        for(UniAssignment a: assignments){
            weights+=a.getWeight();
            weightedGrades+=a.getWeight()*a.getGrade();
        }
        return weightedGrades/weights;
    }
    
    public void updateColor(){
        if(average < (user.getGoalAverage() - 2)){
            color=ButtonColor.RED;
        }
        else if(average > (user.getGoalAverage() +2)){
            color=ButtonColor.GREEN;
        }
        else{
            color=ButtonColor.YELLOW;
        }
    }
    
    public ButtonColor getColor(){
        return color;
    }
    
    public String getName(){
        return name;
    }
}
