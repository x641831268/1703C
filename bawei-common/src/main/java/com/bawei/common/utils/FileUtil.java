package com.bawei.common.utils;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	
	/**
	 *  1. 获取文件扩展名
	 * @param file
	 * @return
	 */
	public static String getFileExtName(File file){
		
		String filename = file.getName(); //获取文件名 test.txt
		String[] devname = filename.split("\\.");
		return "."+devname[1];
	}
	
	

	/**
	 *  2. 删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	 * @param f
	 * @throws IOException
	 */
	
	//F:/test/test/test.txt
	public static void deleteDir(File f) throws IOException{     
		 if(f.exists() && f.isDirectory()){//判断是文件还是目录  
		    if(f.listFiles().length==0){//若目录下没有文件则直接删除  
		        f.delete();  
		    }else{//若有则把文件放进数组，并判断是否有下级目录  
		        File delFile[]=f.listFiles();  
		        int i =f.listFiles().length;  
		        for(int j=0;j<i;j++){
		            if(delFile[j].isDirectory()){
		            	deleteDir(delFile[j]);//递归调用del方法并取得子目录路径  
		            }
		            delFile[j].delete();//删除文件  
		        }
		        f.delete();
		    }  
		}
		f.delete();
	}  
	
	
	
	/**
	 * 3. 获取操作系统用户目录
	 * @return
	 */
	public static File getUserHome(){
		String userHome = System.getProperties().getProperty("user.home");
		File file = new File(userHome);
		return file;
	}
	
	
	public static String getFileLength(File file,char unit){
		double fileLength = file.length() * 1.0;
		switch (unit) {
		case 'B':
			return String.valueOf(fileLength)+"B";
		case 'K':
			return String.valueOf(fileLength/1024)+"K";
		case 'M':
			return String.valueOf(fileLength/(1024*1024))+"M";
		case 'G':
			return String.valueOf(fileLength/(1024*1024*1024))+"G";
		default:
			return String.valueOf(fileLength/(1024*1024*1024*1024))+"T";
		}
	}
	
	
}
