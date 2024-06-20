/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krish
 */
public class University {
    private String name;
    private Program[] programs;
    
    public University(String n, Program[] p){
        name=n;
        programs=p;
    }

    public double getGoal(String pn){
        for(Program p: programs){
            if(!p.getName().equals(pn)) continue;
            return p.getRequiredAverage();
        }
        return 0;
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
     * @return the programs
     */
    public Program[] getPrograms() {
        return programs;
    }

    /**
     * @param programs the programs to set
     */
    public void setPrograms(Program[] programs) {
        this.programs = programs;
    }
}
