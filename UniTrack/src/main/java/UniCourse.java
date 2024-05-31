/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krish
 */
public class UniCourse {
    
    private static boolean isFromGoogleClassroom;
    
    public UniCourse(boolean i){
        isFromGoogleClassroom=i;
        
    }
    
    public static boolean getIsFromGoogleClassroom(){
        return isFromGoogleClassroom;
    }
}
