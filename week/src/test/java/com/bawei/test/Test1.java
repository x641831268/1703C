package com.bawei.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.bawei.utils.Add;
import com.bawei.utils.PullException;
import com.bawei.utils.StringUtils;

public class Test1 {

	@Test
	public void Test2(){
		try {
			StringUtils.isTrue(false, "不是true");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test3(){
		try {
			StringUtils.isFalse(true, "不是false");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test4(){
		try {
			Add add = new Add();
			add.setName("我");
			StringUtils.isObject(add.getName(), "不能为空");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test5(){
		try {
			Add add = new Add();
			StringUtils.NotisObject(add.getName(), "不能为非空");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test6(){
		try {
			List<String> list=new ArrayList<String>();
			StringUtils.isCollection(list, "集合不能为空");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test7(){
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			StringUtils.isMap(map, "集合不能为空");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test8(){
		try {
			StringUtils.isString("123", "字符串不能为空");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test9(){
		try {
			StringUtils.isInteger(2, "数组只能是正数");
		} catch (PullException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
