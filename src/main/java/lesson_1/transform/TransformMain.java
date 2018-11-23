package lesson_1.transform;

import java.util.ArrayList;
import java.util.Arrays;

public class TransformMain {
    public static <T> ArrayList<T> transform(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(arr));

        return arrayList;
    }

    public static void main(String[] args) {
        String[] strs = { "Один", "Два", "Три", "Четыре", "Пять" };

        for (String str: strs) {
            System.out.print(str + " ");
        }
        System.out.println();

        ArrayList<String> aLStrs = transform(strs);

        System.out.println(aLStrs);
    }
}
