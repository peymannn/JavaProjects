package jd2Homework05;

import java.util.Scanner;
import java.util.Random;

public class Main {

	static int count = 0;

	public static void main(String[] args) {
		try {
			paymentProcess();
		} catch (SystemNotWorkingException e) {
			e.printStackTrace();
		}
	}

	private static void paymentProcess() throws SystemNotWorkingException {
		Scanner scanner = new Scanner(System.in);
		Payment payment = new Payment();
		AmountValidation amountValidation = new AmountValidation();
		CardNumberValidation cardNumberValidation = new CardNumberValidation();
		ExpiryDateValidation expiryDateValidation = new ExpiryDateValidation();
		CVVDigitValidation digitCVVValidation = new CVVDigitValidation();

		try {
			System.out.print("Odeme tutarı: ");
			String amount = scanner.next();
			payment.Amount = amount;

			System.out.print("Kart numarası: ");
			String cardNumber = scanner.next();
			payment.CardNumber = cardNumber;

			System.out.print("Son kullanma tarihi: ");
			String expiryDate = scanner.next();
			payment.ExpiryDate = expiryDate;

			System.out.print("CVV: ");
			String digitCVV = scanner.next();
			payment.CVV = digitCVV;

			if (!amountValidation.IsValid(payment)) {
				throw new InvalidAmountException("Tutar  negatif bir değer veya virgüllü bir değer girilemez.");
			}
			if (!cardNumberValidation.IsValid(payment)) {
				throw new InvalidCardNumberException("Kart numarası 16 haneli, rakamlardan oluşmalıdır.");
			}
			if (!expiryDateValidation.IsValid(payment)) {
				throw new InvalidExpiryDateException(
						"Son kullanma tarihi(12/2013) gibi geçmiş bir yıl yada 13 gibi bir ay girilemez.");
			}
			if (!digitCVVValidation.IsValid(payment)) {
				throw new InvalidCVVException("Güvenlik kodu 3 karakter, rakamlardan oluşmalıdır.");
			}

			pay();

		} catch (Exception e) {
			throw new SystemNotWorkingException(e.getMessage());
		}
	}

	private static void pay() throws SystemNotWorkingException {
		Random rnd = new Random();
		int sayi = rnd.nextInt(100);
		if (sayi > 75) {
			try {
				throw new SystemNotWorkingException("sistemde arıza var tekrar deneyin.");
			} catch (SystemNotWorkingException e) {
				e.printStackTrace();
			} finally {
				count++;
				if (count == 1) {
					paymentProcess();
				}
			}
		} else {
			System.out.print("işlem başarılı");
		}

	}

}
