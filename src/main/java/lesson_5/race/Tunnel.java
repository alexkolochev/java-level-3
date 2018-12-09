package lesson_5.race;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore semaphore;

    public Tunnel() {
        this.length = 80;
        this.descrption = "Тоннель " + length + " метров";
        this.semaphore = new Semaphore(2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу (ждет): " + descrption);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + descrption);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + descrption);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
