package com.passwordTest;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.userRegistrationLambdaFunction.UserRegistrationr;

@RunWith(Parameterized.class)
public class PasswordTest {
	private static final String passwordPattern = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
			+ "(?=\\S+$).{8,20}$";
	private String password;
	private boolean expectedResult;
	
	public PasswordTest(String password, boolean expectedResult) {
		this.password = password;
		this.expectedResult = expectedResult;

	}
	
	UserRegistrationr r = (a, b) -> {
		Pattern p = Pattern.compile(b);
		Matcher m = p.matcher(a);
		boolean q = m.matches();
		return q;
	};

	@Parameterized.Parameters
	public static Collection<Object[]> testValidator() {
		return Arrays.asList(new Object[][] { { "Raj.sahni@85120", true }, { "Shivammishra@97672", true },
				{ "78283@sgubah", false }, { "abc-100@abc.net", false }, { "asumit.ahuja@gmail.com", false } });
	}
	
	@Test
	public void WhenePasswordPassed_Return_True_or_False() {
		System.out.println(
				"test result is :" + r.regex(password, passwordPattern) + " and expected result is " + expectedResult);
		assertEquals(expectedResult, r.regex(password, passwordPattern));
	}
	
	
	
	
	
	
	
	
	
	

}
