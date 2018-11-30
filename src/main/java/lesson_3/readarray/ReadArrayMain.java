package lesson_3.readarray;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadArrayMain {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("txtfiles/1/1.txt")) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
