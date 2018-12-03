package lesson_3.assocfiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class AssocFilesMain {
    public static void main(String[] args) throws IOException {
        ArrayList<InputStream> filesList = new ArrayList<>();

        try {
            filesList.add(new FileInputStream("txtfiles/2/in1.txt"));
            filesList.add(new FileInputStream("txtfiles/2/in2.txt"));
            filesList.add(new FileInputStream("txtfiles/2/in3.txt"));
            filesList.add(new FileInputStream("txtfiles/2/in4.txt"));
            filesList.add(new FileInputStream("txtfiles/2/in5.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(filesList));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("txtfiles/2/out.txt"));

        int x;
        while ((x = in.read()) != -1) {
            bos.write(x);
        }
        in.close();
        bos.close();

        try (FileInputStream inS = new FileInputStream("txtfiles/2/out.txt")) {
            while ((x = inS.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
