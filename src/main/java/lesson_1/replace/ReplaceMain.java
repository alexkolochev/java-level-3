package lesson_1.replace;

public class ReplaceMain {
    public static <T> T[] replace(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        return arr;
    }

    public static void main(String[] args) {
        String[] strs = { "Один", "Два", "Три", "Четыре", "Пять" };
        Integer[] ints = { 1, 2, 3, 4, 5 };

        for (String str: strs) {
            System.out.print(str + " ");
        }
        System.out.println();

        replace(strs, 0, 4);

        for (String str: strs) {
            System.out.print(str + " ");
        }
        System.out.println();

        for (Integer i: ints) {
            System.out.print(i + " ");
        }
        System.out.println();

        replace(ints, 0, 3);

        for (Integer i: ints) {
            System.out.print(i + " ");
        }
    }
}
