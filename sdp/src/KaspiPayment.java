public class KaspiPayment implements IPaymentStrategy {
    private String cardNumber;
    private String cardHolder;// каспи оплатаның данныйларын сақтайды

    public KaspiPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println(cardHolder +" " + amount + "$ Kaspi арқылы төледі");
    }
}
