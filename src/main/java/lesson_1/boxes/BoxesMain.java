package lesson_1.boxes;

public class BoxesMain {
    public static void main(String[] args) {
        Box<Orange> orangeBox1 = new Box<Orange>();
        Box<Orange> orangeBox2 = new Box<Orange>();
        Box<Apple> appleBox1 = new Box<Apple>();
        Box<Apple> appleBox2 = new Box<Apple>();

        for (int i = 0; i < 20; i++) {
            orangeBox1.addFruit(new Orange());
        }
        System.out.println("Масса апельсинов в первой коробке: " + + orangeBox1.getWeight());

        for (int i = 0; i < 30; i++) {
            orangeBox2.addFruit(new Orange());
        }
        System.out.println("Масса апельсинов во второй коробке: " + orangeBox2.getWeight());

        for (int i = 0; i < 30; i++) {
            appleBox1.addFruit(new Apple());
        }
        System.out.println("Масса яблок в первой коробке: " + appleBox1.getWeight());

        for (int i = 0; i < 50; i++) {
            appleBox2.addFruit(new Apple());
        }
        System.out.println("Масса яблок во второй коробке: " + appleBox2.getWeight());

        if (orangeBox1.compare(appleBox1)) {
            System.out.println("Масса первой коробки с апельсинами равна массе первой коробки с яблоками");
        } else {
            System.out.println("Масса первой коробки с апельсинами не равна массе первой коробки с яблоками");
        }

        if (orangeBox1.compare(appleBox1)) {
            System.out.println("Масса второй коробки с апельсинами равна массе второй коробки с яблоками");
        } else {
            System.out.println("Масса второй коробки с апельсинами не равна массе второй коробки с яблоками");
        }

        orangeBox1.moveBoxToBox(orangeBox2);

        System.out.println("Масса яблок в первой коробке: " + appleBox1.getWeight());
        System.out.println("Масса яблок во второй коробке: " + appleBox2.getWeight());
    }
}
