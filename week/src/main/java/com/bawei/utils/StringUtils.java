package com.bawei.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class StringUtils {

	public static void isTrue(Boolean b,String message){
		if(!b){
			throw new PullException(message);
		}
	}
	
	public static void isFalse(Boolean b,String message){
		if(b){
			throw new PullException(message);
		}
	}
	
	public static void isObject(Object o,String message){
		if(o==null){
			throw new PullException(message);
		}
	}
	
	public static void NotisObject(Object o,String message){
		if(o!=null){
			throw new PullException(message);
		}
	}
	
	public static void isCollection(Collection<?> c,String message){
		if(c==null || c.size()==0){
			throw new PullException(message);
		}
	}
	
	public static void isMap(Map<?, ?> m,String message){
		if(m==null || m.size()==0){
			throw new PullException(message);
		}
	}
	
	public static void isString(String str,String message){
		if(str.trim()=="" || str.trim().length()==0){
			throw new PullException(message);
		}
	}
	
	public static void isInteger(Integer num,String message){
		if(num<=0){
			throw new PullException(message);
		}
	}
}
