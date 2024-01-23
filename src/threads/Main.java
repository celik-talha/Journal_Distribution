package threads;
import gui.*;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new maingui_thread());
        Thread thread2 = new Thread(new report_thread());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
    }
}
