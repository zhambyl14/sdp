import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> cartItems = new ArrayList<>(); //заттарды списогын жинайды(приватный және пустой)
    private IPaymentStrategy paymentStrategy;

    public void addProduct(Product product) {
        cartItems.add(product);
    } //cartitems ке сала береді

    public double calculateTotalPrice() { // бағасын санайды
        double totalPrice = 0.0;
        for (Product product : cartItems) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    // бұл жерде оплата калай болады соның жолын біліп алады соның стратегиясын сақтап алады

    public void checkout() { // бұл жерде бағасын қарайды сосын checkout пен тексереді карта стратеджиде тирркелген ба жокпа
        double totalAmount = calculateTotalPrice();
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(totalAmount);
        } else {
            System.out.println("Карта тіркелмеген төлем қабылданбады.");
        }
    }
}
