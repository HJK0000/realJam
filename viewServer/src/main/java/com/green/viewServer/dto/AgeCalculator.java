package com.green.viewServer.dto;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AgeCalculator {
	
	public static int calculateAge(Date birthdate) {
		
		Calendar birth  = Calendar.getInstance();
		birth.setTime(birthdate);
		Calendar today = Calendar.getInstance();
		
		int yearDifference = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		
		if(today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
			yearDifference--;
		} else {
			
			if(today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) 
					&& today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
				yearDifference--;
			}
		}
		
		return yearDifference;
	}

}
