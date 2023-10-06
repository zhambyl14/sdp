import java.util.Scanner;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product product1 = new Product("Май", 10.0, 1);
        Product product2 = new Product("Қант", 15.0, 1);
        Product product3 = new Product("Шәй", 20.0, 1);
        Product product4 = new Product("Бал", 25.0, 1);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Алатын заттарды 1-4 сандар арқыллы таңда таңдап болған соң 0-ді басып төлеуге өт");
            System.out.println("1. " + product1.getName() + " - $" + product1.getPrice());
            System.out.println("2. " + product2.getName() + " - $" + product2.getPrice());
            System.out.println("3. " + product3.getName() + " - $" + product3.getPrice());
            System.out.println("4. " + product4.getName() + " - $" + product4.getPrice());

            double totalAmount = 0.0;
            while (true) {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                } else if (choice >= 1 && choice <= 4) {
// алатын затты таңдау керек
                    Product selectedProduct = null;
                    switch (choice) {
                        case 1:
                            selectedProduct = product1;
                            break;
                        case 2:
                            selectedProduct = product2;
                            break;
                        case 3:
                            selectedProduct = product3;
                            break;
                        case 4:
                            selectedProduct = product4;
                            break;
                    }
                    cart.addProduct(selectedProduct);
                    totalAmount += selectedProduct.getPrice();
                } else {
                    System.out.println("Дұрыс емес.");
                }
            }

            System.out.println("Барлығы: $" + totalAmount);

// немен төлейтінін таңдау
            System.out.println("Төлем:");
            System.out.println("1. Kaspi ");
            System.out.println("2. Halyk ");
            int paymentChoice = scanner.nextInt();
            scanner.nextLine();

            PaymentStrategyFactory strategyFactory = new PaymentStrategyFactory();
            IPaymentStrategy paymentStrategy = null;

            if (paymentChoice == 1) {
                paymentStrategy = strategyFactory.createPaymentStrategy("Kaspi", "1234-5678-9012-3456", "Esen Qara", "aergvae@bk.ru");
            } else if (paymentChoice == 2) {
                paymentStrategy = strategyFactory.createPaymentStrategy("Halyk", "0000-0000-0000-0000", "Magzhan Zhambyl", "aergv@bk.ru");
            } else {
                System.out.println("Дұрыс емес.");
                return;
            }

            cart.setPaymentStrategy(paymentStrategy);
            cart.checkout();
        } finally {
            scanner.close();
        }
    }
}
