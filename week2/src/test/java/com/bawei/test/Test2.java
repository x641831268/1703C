package com.bawei.test;

import org.junit.Test;

import com.bawei.utils.PushException;
import com.bawei.utils.StringUtil;

public class Test2 {

	@Test
	public void Test3(){
		try {
			StringUtil.isTrue(false, "只能为true");
		} catch (PushException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test4(){
		try {
			StringUtil.isFalse(true, "只能为false");
		} catch (PushException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
