package cn.mgazul.pfcorelib.util;

import java.util.Random;

public class Java {

	//两个数之间的随机值
	  public static int randInt(int min, int max){
	    Random rand = new Random();
	    int randomNum = rand.nextInt(max - min + 1) + min;
	    return randomNum;
	  } 
	  
	  // 判断字符串是否是整数
	  public static boolean isInteger(String value) {  
	      try {  
	          Integer.parseInt(value);  
	          return true;  
	      } catch (NumberFormatException e) {  
	          return false;  
	      }  
	  }  
	   
	  //判断字符串是否是浮点数 
	  public static boolean isDouble(String value) {  
	      try {  
	          Double.parseDouble(value);  
	          if (value.contains("."))  
	              return true;  
	          return false;  
	      } catch (NumberFormatException e) {  
	          return false;  
	      }  
	  }  
	   
	  // 判断字符串是否是数字
	  public static boolean isNumeric(String value) {  
	      return isInteger(value) || isDouble(value);  
	  }  
}
