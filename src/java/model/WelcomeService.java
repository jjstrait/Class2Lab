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
    
    public String GreetingBasedOnTime(String name){
    return "Good "+getPartOfTheDay(Calendar.getInstance())+" "+name+", Welcome!";
    }
    
    
    public static void main(String[] args) {
        WelcomeService service = new WelcomeService();
        
        Calendar cal = Calendar.getInstance();
        System.out.println(service.getPartOfTheDay(cal));
        System.out.println(service.GreetingBasedOnTime("Joshua"));
        
    }
}
