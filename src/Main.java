public class Main {
    public static void main(String[] args) {
        double amount = 100;
        String cardNumber = "1235469875632145";
        int month = 10;
        int year = 2025;
        String securityCode = "123";

        PaymentSystem paymentSystem = new PaymentSystem();
        try {
            paymentSystem.validatePayment(amount, cardNumber, month, year, securityCode);
            paymentSystem.pay();
        } catch (InvalidCardNumberException e) {
            System.out.println("Hata: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Hata: " + e.getMessage());
        } catch (SystemNotWorkingException e) {
            System.out.println("Hata: " + e.getMessage());
            System.out.println("Tekrar deneniyor.");
            paymentSystem.retryPayment(amount, cardNumber, month, year, securityCode);
        }

    }
}
