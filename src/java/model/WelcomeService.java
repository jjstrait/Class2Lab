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
     * Method function is to take a date and determine the proper saying for the time of day.
     * -morning before 12pm
     * -evening between 12-19(7:00pm)
     * -eveing after 19(7:00pm)
     * @param date
     * @return String = morning,afternoon,evening
     * @throws IllegalArgumentException 
     */
    public String getPartOfTheDay(Calendar date) throws IllegalArgumentException{
        final int timeTillMorning = 12;
        final int timeTillAfternoon = 19;
        
        Calendar morning = Calendar.getInstance();
        morning.set(Calendar.HOUR_OF_DAY, timeTillMorning);
        
        Calendar afternoon = Calendar.getInstance();
        afternoon.set(Calendar.HOUR_OF_DAY, timeTillAfternoon);
      
        String partOfDay;
        
        if(date == null){
            throw new IllegalArgumentException("Date is null");
        }
        
        if(date.getTime().before(morning.getTime())){
        partOfDay = "Morning";
        }
        else if(date.getTime().after(morning.getTime())&&date.getTime().before(afternoon.getTime())){
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
    public String GreetingBasedOnTime(String name)throws IllegalArgumentException{
        if(name == null){
         throw new IllegalArgumentException("Date is null");
        }
    return "Good "+getPartOfTheDay(Calendar.getInstance())+" "+name+", Welcome!";
    }
    
    
    public static void main(String[] args) {
        WelcomeService service = new WelcomeService();
        
        Calendar cal = Calendar.getInstance();
        System.out.println(service.getPartOfTheDay(cal));
        System.out.println(service.GreetingBasedOnTime("Joshua"));
        
    }
}
