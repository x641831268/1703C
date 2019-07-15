package com.zhangsan.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.zhangsan.utils.AssertUtil;
import com.zhangsan.utils.MyException;



public class Test1 {
    //为真
	@Test
	public void isTrue(){
		try {
			AssertUtil.isTrue(false, "只能是true");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//为假
	@Test
	public void isFalse(){
		try {
			AssertUtil.isFalse(true, "只能是false");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//对象不为空
	@Test
	public void notNull(){
		try {
			String string="www";
			AssertUtil.notNull(string, "对象不能为空");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//对象为空
	@Test
	public void isNull(){
		try {
			String string=null;
			AssertUtil.isNull(string, "对象只能为空");
		} catch (MyException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//集合不为空
	@Test
	public void notEmpty(){
		try {
			List<String> list=new ArrayList<String>();
			list.add("ww");
			AssertUtil.notEmpty(list, "集合不能为空");
		} catch (MyException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	//map不为空
	@Test
	public void notMapEmpty(){
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("w", "www");
			AssertUtil.notMapEmpty(map, "map不能为空");
		} catch (MyException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	//字符串不为空
	@Test
	public void hashNext(){
		try {
			String string="ww";
			AssertUtil.hasNext(string, "字符串不能为空");
		} catch (MyException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	//不能小于等于0
	@Test
	public void prepare(){
		try {
			BigDecimal bigDecimal = new BigDecimal(-2); 
			AssertUtil.prepare(bigDecimal, "不能小于等于0");
		} catch (MyException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
