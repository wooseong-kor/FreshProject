package com.min.fresh.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUpload {

	public void fileCopy(String filein,String fileout) throws IOException{
	      
	      try {
	         FileInputStream fis = new FileInputStream(filein);
	         FileOutputStream fos = new FileOutputStream(fileout);
	         
	         int data = 0;
	            while ((data=fis.read())!=-1) {
	               fos.write(data);
	         }
	         fis.close();
	         fos.close();
	      
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      }
	      
	   }
	
}
