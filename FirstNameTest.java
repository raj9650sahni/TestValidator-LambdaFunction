package com.nameTest;

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
public class FirstNameTest {
	
	private String firstname;
	private boolean expectedResult;
	private static final String firstPattern = "^[A-Z]{1}[a-z]{2,}$";

	public FirstNameTest(String firstname, boolean expectedResult) {
		this.firstname = firstname;
		this.expectedResult = expectedResult;
	}
	
	UserRegistrationr r = (a, b) -> {
		Pattern p = Pattern.compile(b);
		Matcher m = p.matcher(a);
		boolean q = m.matches();
		return q;
	};
	

	@Parameterized.Parameters
	public static Collection<Object[]> testcases() {
		return Arrays.asList(new Object[][] { { "Raj", true }, { "shivam", false },
				{ " Amit", false }, { "Anil ", false }, { "Barry", true } });

	}

	@Test
	public void whenNamesPassed_Return_True_or_False() {
		assertEquals(expectedResult, r.regex(firstname,firstPattern));
	}

}
