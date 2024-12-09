package main.java.parctice.se.ex2.module06_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFromKeyboard {
    public static void main(String[] args) {

        System.out.println("請輸入資料....");

        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        try {

            String data = br.readLine();

            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
