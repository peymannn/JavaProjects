package jd2Homework05;

public class CardNumberValidation implements Validation {

	@Override
	public boolean IsValid(Payment payment) {

		if (payment.CardNumber.length() != 16) {
			return false;
		}
		for (char c : payment.CardNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}
