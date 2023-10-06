public class SingletonClient {
    public static void main(String[] args) {
        Singleton singletonInstance1 = Singleton.getInstance();
        singletonInstance1.showMessage();
    }
}
