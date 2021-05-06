package com.emailTest;

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
public class EmailTest {
	
	private String emailid;
	private Boolean expectedResult;
	private static final String emailPattern = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*"
			+ "@([0-9a-zA-Z][-]?)+[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})$";

	public EmailTest(String emailid, Boolean expectedResult) {
		this.emailid = emailid;
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
		return Arrays.asList(new Object[][] { { "raj.sahni@bl.co.in", true }, { "abc-ggsh@gmail.com", false },
				{ "abc@yahoo.com", false }, { "abc@gmail.com.com", true }, { "abc-100@abc.net", false } });
	}

	 
	@Test
	public void WheneEmailPassed_Return_True_or_False() {
		System.out.println(
				"test result is :" + r.regex(emailid, emailPattern) + " and expected result is " + expectedResult);
		assertEquals(expectedResult, r.regex(emailid, emailPattern));
	}

}
