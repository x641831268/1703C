package com.bawei.common.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	//方法1：判断源字符串是否有值，空引号(空白字符串)也算没值 
	public static boolean hasLength(String src){
		return src != null && src.length() > 0;
	}
	
	
	//方法2：判断源字符串是否有值，空引号(空白字符串)和空格也算没值
	public static boolean hasText(String src){
		//trim()方法把字符串中的空格去除
		return src != null && src.trim().length() > 0;
	}
	
	
	//方法3：判断是否为手机号码 
	public static boolean isMobile(String src){
		
		 String telRegex = "[1][3578]\\d{9}";
	        // "[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
	        if (src.isEmpty()) {
	            return false;
	        } else
	            return src.matches(telRegex);
	}
	
	
	//方法4：判断是否为邮箱 
	public static boolean isEmail(String src){
		  boolean flag = false;
		  try{
		   String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		   Pattern regex = Pattern.compile(check);
		   Matcher matcher = regex.matcher(src);
		   flag = matcher.matches();
		  }catch(Exception e){
		   e.printStackTrace();
		   flag = false;
		  }		  
		  return flag;
	}
	
	// 判断邮箱    
	public static boolean isEmail2(String s) {
		//1019921426@qq.com
	    return Pattern.compile("\\w+@{1}\\w+\\.{1}\\w+").matcher(s).matches();    
	}   
	
	//方法5：判断是否全部为字母
	public static boolean allLetter(String src){
		char[] charArray = src.toCharArray();
		boolean flog = true; 
		for (char c : charArray) {
			if(('a'<=c)&&(c<='z')||('A'<=c)&&(c<='Z')){
				
			}else{
				flog = false;
			}
		}
		return flog;
	}
	
	
	//方法6：获取n位随机英文字符串
	public static String getRandomStr(int n){
		
		String string = "qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ";
		char[] charArray = string.toCharArray();
		Random random = new Random();
		int abs = -1;
		String resultStr = "";
		for (int i = 0; i < n; i++) {
			abs = Math.abs(random.nextInt(charArray.length));
			resultStr = resultStr+charArray[abs];
		}
		
		return resultStr;
	}
	
	
	//方法7：获取n位随机英文字符串和数字字符串
	public static String getRandomNum(int n){
		
		String string = "qwertyuioplkjhgfdsazxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ0123456789";
		char[] charArray = string.toCharArray();
		Random random = new Random();
		int abs = -1;
		String resultStr = "";
		for (int i = 0; i < n; i++) {
			abs = Math.abs(random.nextInt(charArray.length));
			resultStr = resultStr+charArray[abs];
		}
		
		return resultStr;
	}
	
	
	//方法8：获取n位随机中文字符串
	public static String getRandomChe(int n){
		
		String[] string = {"赵","钱","孙","李","周","吴","郑","王","冯",
				"陈","褚","卫","蒋","沈","韩","杨","朱","秦","尤","许","何",
				"吕","施","张","孔","曹","严","华"};
		Random random = new Random();
		int abs = -1;
		String resultStr = "";
		for (int i = 0; i < n; i++) {
			abs = Math.abs(random.nextInt(string.length));
			resultStr = resultStr+string[abs];
		}
		
		return resultStr;
	}
	
	
	//------------------------------------------------------------------------------
	//方法9：反转字符串，例如参数值是“abcdefg”，则输出“gfedcba”
	public static String reverse(String src){
	    char[] charArray = src.toCharArray();
	    char[] newcharArray =new char[src.length()];
	    for(int i=0;i<src.length();i++){
	    	newcharArray[src.length()-i] = charArray[i];
	    }
	    String newstr = newcharArray.toString();
	    return newstr;
	}
	
	//大写字母转化成小写字母，并且空格换成“-” ，例如："SpRIng MvC"  转换成  "spring-mvc"
	public static String toUniqueTerm(String paramstr){
		String[] splitwords = paramstr.split(" ");
		String joinstr="";
		
		if(splitwords.length==1){
			return splitwords[0].toLowerCase();
		}else {
			for(int i=0; i < splitwords.length ; i++){
				splitwords[i]=splitwords[i].toLowerCase();
				if(i==0){
					joinstr=splitwords[0];
				}else{
					joinstr=joinstr+"-"+splitwords[i];
				}				
			}
			return joinstr;
		}		
	}
}
