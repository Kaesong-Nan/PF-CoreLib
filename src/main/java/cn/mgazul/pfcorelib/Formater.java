package cn.mgazul.pfcorelib;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formater {
	
	public static String formatValue(double value){
	    boolean isWholeNumber = value == Math.round(value);
	    
	    DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
	    
	    formatSymbols.setDecimalSeparator('.');
	    
	    String pattern = isWholeNumber ? "######.###" : "##,###0.00";
	    
	    DecimalFormat df = new DecimalFormat(pattern, formatSymbols);
	    
	    return df.format(value);
	  }
	
	public static String formatValue1(double value){
	    boolean isWholeNumber = value == Math.round(value);
	    
	    DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
	    
	    formatSymbols.setDecimalSeparator('.');
	    
	    String pattern = isWholeNumber ? "######.###" : "#####0.00";
	    
	    DecimalFormat df = new DecimalFormat(pattern, formatSymbols);
	    
	    return df.format(value);
	  }
	public static String formatValue2(double value){
	    boolean isWholeNumber = value == Math.round(value);
	    
	    DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
	    
	    formatSymbols.setDecimalSeparator('.');
	    
	    String pattern = isWholeNumber ? "#########" : "#####0";
	    
	    DecimalFormat df = new DecimalFormat(pattern, formatSymbols);
	    
	    return df.format(value);
	  }
}
