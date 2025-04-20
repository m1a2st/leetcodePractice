package practice.se.ex2.module06_12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("farrago.txt");
        File outputFile = new File("outagain.txt");

        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);
        int c;

        while ((c = in.read()) != -1) { // 讀到檔案的尾端時,read()會回傳-1
            out.write(c);
            System.out.print((char) c);
            System.out.flush();
        }

        in.close();
        out.close();
    }
}
