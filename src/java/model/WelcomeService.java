/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.Calendar;

/**
 *
 * @author Joshua
 */
public class WelcomeService {
    private Calendar date;
    /**
     * Method function is to takes current date and determine the proper saying for the time of day.
     * -morning before 12pm
     * -evening between 12-19(7:00pm)
     * -evening after 19(7:00pm)
     * @return String = morning,afternoon,evening
     * @throws IllegalArgumentException 
     */
    public String getPartOfTheDay() throws IllegalArgumentException{
        final int timeTillMorning = 12;
        final int timeTillAfternoon = 19;
        
        Calendar currentDate = Calendar.getInstance();
        
        Calendar morning = Calendar.getInstance();
        morning.set(Calendar.HOUR_OF_DAY, timeTillMorning);
        
        Calendar afternoon = Calendar.getInstance();
        afternoon.set(Calendar.HOUR_OF_DAY, timeTillAfternoon);
      
        String partOfDay;
        
        if(currentDate == null){
            throw new IllegalArgumentException("No Date was entered");
        }
        
        if(currentDate.getTime().before(morning.getTime())){
        partOfDay = "Morning";
        }
        else if(currentDate.getTime().after(morning.getTime())&&currentDate.getTime().before(afternoon.getTime())){
        partOfDay = "Afternoon";
        }
        else {
        partOfDay = "Evening";
        }
        
        return partOfDay;
    }
    /**
     * method function is to return a greeting based on the time from the computer
     * @param name
     * @return String = Good [time greeting] [name], Welcome!
     * @throws IllegalArgumentException 
     */
    public String greetingBasedOnTime(String name)throws IllegalArgumentException{
        if(name == null|| name.trim().length() == 0){
         throw new IllegalArgumentException("No name was entered");
        }
    return "Good "+getPartOfTheDay()+" "+name+", Welcome!";
    }
    
    
    public static void main(String[] args) {
        WelcomeService service = new WelcomeService();
        
       
        System.out.println(service.getPartOfTheDay());
        System.out.println(service.greetingBasedOnTime("Joshua"));
        
    }
}
