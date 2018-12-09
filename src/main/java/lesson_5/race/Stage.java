package lesson_5.race;

public abstract class Stage {
    protected int length;
    protected String descrption;

    public String getDescrption() {
        return descrption;
    }

    public abstract void go(Car c);
}
