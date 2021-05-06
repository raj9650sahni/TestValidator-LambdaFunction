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
public class LastNameTest {
	
	private String lastname;
	private boolean expectedResult;
	private static final String lastPattern = "^[A-Z][a-z]{3,19}$";

	public LastNameTest(String lastname, boolean expectedResult) {
		this.lastname = lastname;
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
		return Arrays.asList(new Object[][] { { "Sahni", true }, { "mishra", false },
				{ "Verma", true }, { "sharma ", false }, { "Allen", true } });

	}

	@Test
	public void whenNamesPassed_Return_True_or_False() {
		assertEquals(expectedResult, r.regex(lastname,lastPattern));
	}

}
