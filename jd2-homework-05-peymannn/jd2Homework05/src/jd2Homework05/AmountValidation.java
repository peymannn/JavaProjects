package jd2Homework05;

public class AmountValidation implements Validation {

	@Override
	public boolean IsValid(Payment payment) {

		if (!payment.Amount.contains(",") && Integer.parseInt(payment.Amount) > 0) {
			return true;
		}
		return false;
	}
}
