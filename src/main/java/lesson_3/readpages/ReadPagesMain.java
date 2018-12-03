package lesson_3.readpages;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadPagesMain {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream("txtfiles/3/1.txt")){
            byte[] arr = new byte[1800];
            int x;
            while ((x = in.read(arr)) > 0) {
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - t);
    }
}
