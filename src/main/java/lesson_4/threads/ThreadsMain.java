package lesson_4.threads;

public class ThreadsMain {
    public static void main(String[] args) {
        PrintChars pc = new PrintChars();

        Thread t1 = new Thread(() -> {
            pc.printA();
        });

        Thread t2 = new Thread(() -> {
            pc.printB();
        });

        Thread t3 = new Thread(() -> {
            pc.printC();
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
