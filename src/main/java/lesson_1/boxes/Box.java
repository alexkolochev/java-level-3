package lesson_1.boxes;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<T>();
    }

    public float getWeight() {
        float totalWeight = 0.0f;

        for (T fruit: fruits) {
            totalWeight += fruit.getWeight();
        }

        return totalWeight;
    }

    public boolean compare(Box box) {
        if (this.getWeight() == box.getWeight())
            return true;

        return false;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void moveBoxToBox(Box<T> box) {
        while (this.fruits.size() > 0) {
            box.addFruit(this.fruits.remove(0));
        }
    }
}
