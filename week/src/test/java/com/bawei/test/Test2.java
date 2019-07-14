package com.bawei.test;

public class Test2 {

		  public static void main(String[] args) {

		        Integer aa=new Integer(5);
		        Integer bb=new Integer(6);
		        mb_num(aa,bb);
		        System.out.println("aa="+aa+",bb="+bb);
		    }

		  
		    static void mb_num(Integer c,Integer d){
		        Integer temp=c;  
		        c=d;    
		        d=temp;
		        
		    }
	
}
