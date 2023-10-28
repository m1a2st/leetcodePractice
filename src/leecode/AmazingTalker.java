package leecode;

public class AmazingTalker {

    public int test01(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == target) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
