package leetcode.easy;

public class No334 {

	public static boolean increasingTriplet(int[] arr) {
		int max1 = Integer.MAX_VALUE;
		int max2 = Integer.MAX_VALUE;
		for (int n : arr) {
			if (n <= max1) {
				max1 = n;
			} else if (n <= max2) {
				max2 = n;
			} else {
				return true;
			}
		}
		return false;
	}

}
