package se.ex1.module07_08;
/*
 * 三種迴圈比較用法
 */
public class Test3TenAdd {

	public static void main(String[] args) {
		 /* for */
        int sum = 0;   
        for (int count = 1; count <= 10; count++)
              sum += count;
    
    
    
//        while
//        int sum = 0;
//        int count = 1;
//        while ( count <= 10) {
//             sum += count;
//             count++;
//        }
     
    
    
//         do…while
//         int sum = 0;
//         int count = 1;
//         do {
//             sum += count;
//             count++;
//         } while ( count <= 10);
    
         System.out.println(sum);

	}

}
