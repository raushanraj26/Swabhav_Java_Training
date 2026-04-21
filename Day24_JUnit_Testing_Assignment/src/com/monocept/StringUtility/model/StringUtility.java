package com.monocept.StringUtility.model;

public  class StringUtility {
	public static boolean isEmpty(String s) {
		if(s==null) return true;
//		return s.trim().isEmpty();
		return s.trim().length()==0;
	}
	
	public static String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
	
	public static int getLength(String str) {
        if (str == null) return 0;
        if(str.trim().length()==0) return 0;
        return str.length();
    }

}
