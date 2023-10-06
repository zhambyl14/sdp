public class PaymentStrategyFactory {
    public IPaymentStrategy createPaymentStrategy(String strategyName, String cardNumber, String cardHolder, String email) {
        if ("Kaspi".equalsIgnoreCase(strategyName)) {
            return new KaspiPayment(cardNumber, cardHolder);
        } else if ("Halyk".equalsIgnoreCase(strategyName)) {
            return new HalykPayment(cardNumber, cardHolder);
        }
        return null;
    }

}
