package com.jehlum.util;

public class StaticMethods {
	
	 public static String getImageUrl(String s3url,String bucketName,String folder,String name){
		 return s3url+"/"+bucketName+"/"+folder+"/"+name;
	 }
}
