package com.bawei.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	// 将日期字符串"yyyyMMdd"转化为wv成日期对象Date
	public static Date strToDate(String time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = format.parse(time);			
			return date;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//**********
	public static String formatDateTime(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
		return dateTime.format(formatter);
	}

	// 1.根据日期算年龄
	public static int getAgeByBirth(Date birthday) {
		int age = 0;
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(new Date());// 当前时间

			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);

			if (birth.after(now)) {// 如果传入的时间，在当前时间的后面，返回0岁
				age = 0;
			} else {
				age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
				
				//19950613    24     20190613    25    20190616
				
				if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
					age += 1;
				}
			}
			return age;
		} catch (Exception e) {// 兼容性更强,异常后返回数据
			return 0;
		}
	}
	
	
	
	// 2、3、4.两个日期的相差天数
	public static int differentDays(Date date2) {
		Date date1 = new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		
		// day1-day2    =  7    36
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);   //17    46
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);   //10
		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // 不同一年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {				
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
				{
					timeDistance += 366;
				} else // 不是闰年
				{
					timeDistance += 365;
				}
			}
			return timeDistance + (day2 - day1);
		} else // 同年
		{
			return day2 - day1;
		}
	}
	
	//获取本周的日期区间
	public static String intervalWeek(){
		String weekStr = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); 

	    Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault()); 
//	    System.out.println(firstDayOfWeek);
	    firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY); 
//	    System.out.println(firstDayOfWeek);
	    int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK); 
	    
//	    System.out.println(day);
	    
	    firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始   -5+1+1=-3
	    // 本周一的日期 
//	    System.out.println(format.format(firstDayOfWeek.getTime())); 
	    weekStr = format.format(firstDayOfWeek.getTime());
	    
	    
	    Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault()); 

	    lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY); 

	    day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK); 
	    
//	    System.out.println(day);
	    
	    lastDayOfWeek.add(Calendar.DATE, 7-day+1); 

	    // 本周星期天的日期 

//	    System.out.println(format.format(lastDayOfWeek.getTime()));
	    weekStr = weekStr +"-"+format.format(lastDayOfWeek.getTime());
	    System.out.println(weekStr);
	    
	    return weekStr;
	}
	
	//5.判断给定的日期是否在本周之内
	public static boolean inWeek(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Integer datestr = Integer.parseInt(format.format(date));
		
		String intervalWeek = DateUtil.intervalWeek();
		String[] week = intervalWeek.split("-");
		Integer weekStart = Integer.parseInt(week[0]);
		Integer weekEnd = Integer.parseInt(week[1]);
		if((weekStart <= datestr)&&(datestr <= weekEnd)){
			return true;
		}else{
			return false;
		}
	}
	
	//6.判断给定的日期是否在本月之内
	public static boolean inMonth(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Integer datestr = Integer.parseInt(format.format(date))/100;
		
		String intervalWeek = DateUtil.intervalWeek();
		String[] week = intervalWeek.split("-");
		Integer weekStart = Integer.parseInt(week[0])/100;
		System.out.println(weekStart);
		Integer weekEnd = Integer.parseInt(week[1])/100;
		System.out.println(weekEnd);
		if((weekStart <= datestr)&&(datestr <= weekEnd)){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 7. 获取某月第一天的00:00:00
	 * 
	 * @param dateTime
	 *            LocalDateTime对象
	 * @return
	 */
	public static String getFirstDayOfMonth(LocalDateTime dateTime) {
		return formatDateTime(dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
	}

	/**
	 * 8. 获取某月最后一天的23:59:59
	 * 
	 * @param dateTime
	 *            LocalDateTime对象
	 * @return
	 */
	public static String getLastDayOfMonth(LocalDateTime dateTime) {
		return formatDateTime(dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
	}

	/**
	 * 获取当前日期的字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDateStr() throws Exception {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}
	
	/**
	 * 9.时间比较
	 * @param date1
	 * @param date2
	 * @return 
	 */
	public static int compareDate(Date date1,Date date2){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Integer datestr1 = Integer.parseInt(format.format(date1));
		Integer datestr2 = Integer.parseInt(format.format(date2));
		if(datestr1.equals(datestr2)){
			return 0;
		}else{
			if(datestr1 < datestr2){
				return -1;
			}else{
				return 1;
			}
		}
	}
		
}
