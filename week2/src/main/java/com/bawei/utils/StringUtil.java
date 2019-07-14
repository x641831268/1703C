package com.bawei.utils;

public class StringUtil {

	public static void isTrue(Boolean b,String message){
		if(!b){
			throw new PushException(message);
		}
	}

	public static void isFalse(Boolean b,String message){
		if(b){
			throw new PushException(message);
		}
	}
	
}
