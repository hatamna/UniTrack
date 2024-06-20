/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krish
 */
public class Program {
    private String name;
    private double requiredAverage;
    private String[] requiredCourses;
    
    public Program(String n, double r, String[] c){
        name=n;
        requiredAverage=r;
        requiredCourses=c;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the requiredAverage
     */
    public double getRequiredAverage() {
        return requiredAverage;
    }

    /**
     * @param requiredAverage the requiredAverage to set
     */
    public void setRequiredAverage(double requiredAverage) {
        this.requiredAverage = requiredAverage;
    }

    /**
     * @return the requiredCourses
     */
    public String[] getRequiredCourses() {
        return requiredCourses;
    }

    /**
     * @param requiredCourses the requiredCourses to set
     */
    public void setRequiredCourses(String[] requiredCourses) {
        this.requiredCourses = requiredCourses;
    }
}
