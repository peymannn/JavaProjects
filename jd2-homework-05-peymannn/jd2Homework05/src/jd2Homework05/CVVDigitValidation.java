package jd2Homework05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CVVDigitValidation implements Validation {
	String regex = "^[0-9]{3,4}$";

	@Override
	public boolean IsValid(Payment payment) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(payment.CVV);
		if (payment.CVV == null) {
			return false;
		}
		return m.matches();
	}
}