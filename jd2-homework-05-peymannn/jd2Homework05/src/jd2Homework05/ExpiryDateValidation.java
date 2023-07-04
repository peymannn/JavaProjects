package jd2Homework05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpiryDateValidation implements Validation {

	@Override
	public boolean IsValid(Payment payment) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date expiry;
		try {
			expiry = simpleDateFormat.parse(payment.ExpiryDate);
		} catch (ParseException e) {
			return false;
		}
		boolean notExpired = !expiry.before(new Date());
		return notExpired;
	}

}