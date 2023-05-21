import java.util.Random;

public class PaymentSystem {
    private double amount;
    private String cardNumber;
    private int expirationMonth;
    private int expirationYear;
    private String securityCode;

    public void pay() throws SystemNotWorkingException {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        if (randomNumber > 75) {
            throw new SystemNotWorkingException("Ödeme sistemi çalışmıyor.");
        }
        System.out.println("Ödeme başarılı :) Random sayı= " + randomNumber);

    }

    public void validatePayment(double amount, String cardNumber, int expirationMonth, int expirationYear, String securityCode) throws InvalidCardNumberException, InvalidAmountException {
        if (amount <= 0 || amount % 1 != 0) {
            throw new InvalidAmountException("Geçersiz ödeme miktarı girdiniz.");
        }

        if (!isValidCardNumber(cardNumber)) {
            throw new InvalidCardNumberException("Geçersiz kart numarası girdiniz.");
        }
        if (!isValidSecurityCode(securityCode)) {
            throw new IllegalArgumentException("Geçersiz güvenlik kodu girdiniz.");
        }
        if (!isExpirationDate(expirationYear, expirationMonth)) {
            throw new IllegalArgumentException("Geçersiz son kullanma tarihi girdiniz.");
        }
    }

    public static boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    public static boolean isValidSecurityCode(String securityCode) {
        return securityCode.matches("\\d{3}");
    }

    public static boolean isExpirationDate(int expirationYear, int expirationMont) {
        if (expirationMont < 1 || expirationMont > 12) {
            return false;
        }
        if (expirationYear < 2023) {
            return false;
        }
        return true;
    }

    public void retryPayment(double amount, String cardNumber, int expirationMonth, int expirationYear, String securityCode) {
        try {
            validatePayment(amount, cardNumber, expirationMonth, expirationYear, securityCode);
        } catch (InvalidCardNumberException | InvalidAmountException e) {
            System.out.println("Deneme başarısız.");
        }
    }
}
