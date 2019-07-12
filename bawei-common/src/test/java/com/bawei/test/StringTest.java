package com.bawei.test;

import org.junit.Test;
import com.bawei.common.utils.StringUtil;

public class StringTest {
	
	@Test
	public void funTest1(){
		
		String string = null;
		boolean result = StringUtil.hasLength(string);
		System.out.println(result);
	}
	
	@Test
	public void fun2Test(){
		String string = " ";
		boolean result = StringUtil.hasText(string);
		System.out.println(result);
	}
	
	@Test
	public void fun6Test(){
		String randomStr = StringUtil.getRandomStr(5);
		System.out.println(randomStr);
	
	}
	
	
}
