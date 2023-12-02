package se.ex2.module27_33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestRuntime {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = null;
		try {
			Process proc = Runtime.getRuntime().exec("ping 8.8.8.8");
			br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String str = null;
			for (int i = 1; i <= 5; i++) {
				if ((str = br.readLine()) != null)
					System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
