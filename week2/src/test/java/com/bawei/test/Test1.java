package com.bawei.test;

import java.math.BigDecimal;

import org.junit.Test;

public class Test1 {
//加
	@Test
	public void add(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal add = bigDecimal.add(new BigDecimal(3));
		System.out.println(add);
	}
	//减
	@Test
	public void jian(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal jian = bigDecimal.subtract(new BigDecimal(3));
		System.out.println(jian);
	}
	//乘
	@Test
	public void cheng(){
		BigDecimal bigDecimal = new BigDecimal(5);
		BigDecimal cheng = bigDecimal.multiply(new BigDecimal(3));
		System.out.println(cheng);
	}
	//除
		@Test
		public void chu(){
			BigDecimal bigDecimal = new BigDecimal(5);
			BigDecimal chu = bigDecimal.divide(new BigDecimal(3),5,BigDecimal.ROUND_UP);
			BigDecimal setScale = chu.setScale(2, BigDecimal.ROUND_FLOOR);
			System.out.println(setScale);
		}
		
		//除
				@Test
				public void compar(){
					BigDecimal bigDecimal = new BigDecimal(5);
					int chu = bigDecimal.compareTo(new BigDecimal(8));
					if(chu>0){
						System.out.println("大于");
					}else if(chu==0){
						System.out.println("等于");
					}else{
						System.out.println("小于");
					}
				}
}
