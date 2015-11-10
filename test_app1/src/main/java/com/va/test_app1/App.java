package com.va.test_app1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.*;
import java.io.IOException;

public class App {
	
	private static Logger log = Logger.getLogger(App.class.getName());
	public ResourceBundle currentBundle = ResourceBundle.getBundle("HelloMessageBundle");
	
	public App() {
		
		// считывание конфигурации логера из файла
    	try {
            LogManager.getLogManager().readConfiguration(
                    App.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
        	System.err.println("Could not setup logger configuration: " + e.toString());
        }
		
	}
	
    public static void main( String[] args ) {
    	
    	App myApp = new App();
    	
    	int currentHour = myApp.prepareHour();    	
    	log.info("current hour is: " + currentHour);    	
    	System.out.println(myApp.prepareMessage(currentHour));
    	
    }
    
    public int prepareHour() {
    	
    	// определяем и переводим в int значение текущего часа в формате 0-24
    	SimpleDateFormat sdf = new SimpleDateFormat("HH"); 
    	Date currentDate = new Date(); 
    	return Integer.parseInt(sdf.format(currentDate));
    	
    }
    
    public String prepareMessage(int currentHour) {
    	
    	// используя значения переменной текущего часа определяем какой временной
    	// диапазон: утро, день, вечер или ночь
    	String message = null;
    	if (currentHour >= 6 && currentHour < 9) {
    		message = currentBundle.getString("tm.morning");
    	}    	
    	
    	if (currentHour >= 9 && currentHour < 19) {
    		message = currentBundle.getString("tm.day");
    	}    	
    	
    	if (currentHour >= 19 && currentHour < 23) {
    		message = currentBundle.getString("tm.evening");
    	}    	
    	
    	if (currentHour >= 23 || currentHour < 6) {
    		message = currentBundle.getString("tm.night");
    	}
    	
    	return message;
    	
    }
    
}
