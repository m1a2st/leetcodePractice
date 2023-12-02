package se.ex2.module06_12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderChain {
	 public static void main(String args[]) {
         int i;
         try {
           	
             FileReader fr = new FileReader("c:\\javawork\\hello.txt");
             while ((i = fr.read()) != -1)
                 System.out.print((char)i);
             fr.close();
            
            
            
            
           /*  
             FileReader fr = new FileReader("c:\\javawork\\hello.txt");
             BufferedReader  br  =   new  BufferedReader(fr) ;
             while ((i = br.read()) != -1)
                 System.out.print((char)i);
             
             br.close();   
             fr.close();
           */
           
           /*
             String str;
             FileReader fr = new FileReader("c:\\javawork\\hello.txt");
             BufferedReader br = new BufferedReader(fr) ;
             while ((str = br.readLine()) != null)
                 System.out.println(str);
             
             br.close();   
             fr.close();
           */
         } catch(IOException e){}
    }
}
