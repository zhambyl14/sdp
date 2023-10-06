import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadSafety {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Поток саны: ");
        int numThreads = scanner.nextInt();
        scanner.close();
//потоктар жиналатын жер
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                Singleton singleton = Singleton.getInstance();
                System.out.println("Thread " + Thread.currentThread().getId() + " Singleton instance: " + singleton.hashCode());
            });
            threads.add(thread);
        }
//если потоктар кезек күтпейтін болса блокка кетеді ал мынау астындагы код оны болғызбайды
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
