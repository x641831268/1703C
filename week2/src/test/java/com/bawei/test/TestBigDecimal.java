package com.bawei.test;

import java.math.BigDecimal;

import org.junit.Test;


public class TestBigDecimal {
	@Test //加
	public void TestAdd(){
		BigDecimal bigDecimal = new BigDecimal("1");
		//参数是BigDecimal类型的
		BigDecimal add = bigDecimal.add(new BigDecimal(2));
		System.out.println(add);
	}
	
	@Test //减
	public void TestJian(){
		BigDecimal bigDecimal = new BigDecimal(1);
		//参数是BigDecimal类型的
		BigDecimal subtract = bigDecimal.subtract(new BigDecimal(1));
		System.out.println(subtract);
	}
	
	@Test //乘
	public void TestMultiply(){
		BigDecimal bigDecimal = new BigDecimal(5);
		//参数是BigDecimal类型的
		BigDecimal multiply = bigDecimal.multiply(new BigDecimal(2));
		System.out.println(multiply);
	}
	
	@Test //除 
	public void TestDivide(){
		BigDecimal bigDecimal = new BigDecimal("5.0");
		//第一个参数是要除以的数，是BigDecimal类型的  第二，三个参数可写可不写    
		//第二个参数是保留的小数点后的个数  第三个参数是四舍五入的意思  写了第二个参数就必须写第三个参数
		BigDecimal divide = bigDecimal.divide(new BigDecimal("3"),10,BigDecimal.ROUND_HALF_DOWN);
		
		//setScale  保留小数点后面的个数  第一个参数是保留几位小数  第二个参数是以四舍五入的方式进制
		BigDecimal setScale = divide.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		System.out.println(setScale);
	}
	
	@Test //比较
	public void TestCompareTo(){
		BigDecimal bigDecimal = new BigDecimal("5.0");
		// compareTo 比较的意思  参数是要比较的数值，必须是BigDecimal对象
		//返回值是一个数值，1 表示大于  0是等于  -1是小于 
		int compareTo = bigDecimal.compareTo(new BigDecimal("5"));
		if(compareTo>0){
			System.out.println("大于");
		}else if(compareTo<0){
			System.out.println("小于");
		}else{
			System.out.println("等于");
		}
	}
	
}
