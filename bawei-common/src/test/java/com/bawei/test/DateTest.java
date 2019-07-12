package com.bawei.test;
import java.util.Date;

import org.junit.Test;

import com.bawei.common.utils.DateUtil;

public class DateTest {
	
	private Date day;
	private Date day1;
	private Date day2;
	
	@Test
	public void fun1Test(){        
		try {
			day = DateUtil.strToDate("20170823");
			 int age = DateUtil.getAgeByBirth(day);
		     System.out.println(age);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void fun234Test(){
		String daystr = "20190612";
		day1 = DateUtil.strToDate(daystr);
		int differentDays = DateUtil.differentDays(day1);
		if(differentDays < 0){
			System.out.println(daystr+"距离今天已经过去了"+(-differentDays)+"天");
		}else{
			if(differentDays == 0){
				System.out.println("当前日期就是今天");
			}else{
				System.out.println("今天再过"+differentDays+"天就要到"+daystr);
			}
		}
	}
	
	
	
	@Test
	public void fun5Test(){
		String daystr = "20190611";
		day1 = DateUtil.strToDate(daystr);
		boolean result = DateUtil.inWeek(day1);
		System.out.println(result);
	}
	
	@Test
	public void fun6Test(){
		String daystr = "20190528";
		day1 = DateUtil.strToDate(daystr);
		boolean result = DateUtil.inMonth(day1);
		System.out.println(result);
	}
	
	@Test
	public void fun7Test(){
		String daystr1 = "20190528";
		String daystr2 = "20190528";
		day1 = DateUtil.strToDate(daystr1);
		day2 = DateUtil.strToDate(daystr2);
		int result = DateUtil.compareDate(day1, day2);
		System.out.println(result);
	}
}
