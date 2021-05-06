package com.userRegistrationLambdaFunction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
public interface UserRegistrationr {
	public boolean regex(String a, String b);

}


class Test {
	public static void main(String[] args) {
  
		UserRegistrationr r = (a,b)-> {
				Pattern p = Pattern.compile(a);
				Matcher m = p.matcher(b);
				boolean q = m.matches();
				return q;
			};
			
		
		}
	
  

}

