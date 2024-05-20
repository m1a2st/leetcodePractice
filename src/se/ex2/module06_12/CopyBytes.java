package se.ex2.module06_12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("farrago.txt");
        File outputFile = new File("outagain.txt");

        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        int c;

        while ((c = in.read()) != -1) { // 讀到檔案的尾端時,read()會回傳-1
            out.write(c);
            System.out.print((char) c);
            System.out.flush();
        }

        // 使用FileInputStream,FileOutputStream 時, 解決中文碼印出問題
//		int i = 0;
//		byte ch[] = new byte[(int) inputFile.length()];
//		while ((c = in.read()) != -1) {
//			out.write(c);
//			ch[i++] = (byte) c;
//		}
//		System.out.print(new String(ch));
//		System.out.flush();

        in.close();
        out.close();
    }
}
