package com.phoneTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.lambdaPatternMartch.MainT;

import com.userRegistrationLambdaFunction.UserRegistrationr;

@RunWith(Parameterized.class)
public class PhoneTest {
	private String phone;

	private boolean expectedResult;
	private static final String phonePattern = "^[1-9]{2}[ ][0-9]{10}$";

	public PhoneTest(String phone, boolean expectedResult) {
		this.phone = phone;
		this.expectedResult = expectedResult;

	}

	UserRegistrationr r = (a, b) -> {
		Pattern p = Pattern.compile(b);
		Matcher m = p.matcher(a);
		boolean q = m.matches();
		return q;
	};

	@Parameterized.Parameters
	public static Collection<Object[]> tests() {

		return Arrays.asList(new Object[][] { { "91 8920047808", true }, { "9650138436", false },
				{ "+ 8527478469", false }, { " 9867886756231447", false }, { "8848988959", false } });

	}

	@Test
	public void WhenPassedPhone_Return_true_or_false() {
		System.out.println(
				" Phone test Expected is :" + expectedResult + " and originally is " + r.regex(phone, phonePattern));
		assertEquals(expectedResult, r.regex(phone, phonePattern));

	}

}
