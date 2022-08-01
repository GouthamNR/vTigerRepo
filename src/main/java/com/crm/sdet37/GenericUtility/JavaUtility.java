package com.crm.sdet37.GenericUtility;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
public int getRandumNum() {
	Random random=new Random();
	int ranNum = random.nextInt(100);
	return ranNum;
}


public String getDateTime() {
	LocalDateTime dateTime = LocalDateTime.now();
	String dateAndTime = dateTime.getDayOfMonth()+"-"+dateTime.getMonthValue()+"-"+dateTime.getYear()+" "+dateTime.getHour()+":"+dateTime.getMinute();
	return dateAndTime;
}
public static void main(String[] args) {
	JavaUtility obj = new JavaUtility();
	System.out.println(obj.getDateTime());;
}
}
