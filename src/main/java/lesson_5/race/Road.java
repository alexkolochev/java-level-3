package lesson_5.race;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.descrption = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + descrption);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + descrption);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
