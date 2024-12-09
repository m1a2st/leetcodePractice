package parctice.se.ex1.module12_15;

public class TestAssignArray2 {

    static void passReference(int[] intArray) {
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = 0;
    }

    public static void main(String[] args) {
        int[] iArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        passReference(iArray);
        for (int i = 0; i < iArray.length; i++)
            System.out.println(iArray[i]);
    }

}
