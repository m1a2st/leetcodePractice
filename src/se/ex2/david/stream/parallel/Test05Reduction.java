package se.ex2.david.stream.parallel;

import java.util.stream.IntStream;

public class Test05Reduction {
	
public static void main(String[] args) {
        
        int r1 = IntStream.rangeClosed(1, 5)
        	.parallel()
            .reduce(0, (sum, element) -> sum + element);
        
        System.out.println("Result: " + r1);
        
    }
}
