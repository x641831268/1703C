package com.bawei.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.junit.Test;

import com.bawei.common.utils.StreamUtil;

public class StreamTest {
	
	@Test
	public void fun2Test(){
		String srcPathStr = "F:\\test\\test.txt";
		String desPathStr = "F:\\test\\test";
		File srcFile = new File(srcPathStr);
		String name = srcFile.getName();
		desPathStr = desPathStr +"\\"+name;		
		//2.创建输入输出流对象
        try {
			FileInputStream fis = new FileInputStream(srcPathStr);
			FileOutputStream fos = new FileOutputStream(desPathStr);
			
			StreamUtil.copyFile(fis, fos, false, true);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}
	
	
	@Test
	public void fun3Test(){
		File file = new File("F:\\test\\test.txt");
		String readTextFile = StreamUtil.readStrFile(file);
		System.out.println(readTextFile);
	}
	
	
	@Test
	public void fun4Test(){
		File file = new File("F:\\test\\test.txt");
		List<String> lineList = StreamUtil.readLineFile(file);
		for (String line : lineList) {
			System.out.println(line);
		}
	}
	
	
	@Test
	public void fun5Test(){
		File file = new File("F:\\test.txt");
		String string = "eeeeeeeeeeeeee";
		StreamUtil.writeFile(string, file);	
	}
	
	@Test
	public void fun61Test(){
		String urlStr = "https://www.cnblogs.com/webyyq/p/8616326.html";
		String fileName = "test.html";
		String savePath = "F:\\test";
		try {
			StreamUtil.downLoadFromUrl(urlStr, fileName, savePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void fun62Test(){
		String savePath = "F:\\test\\test.txt";        
	}
}
