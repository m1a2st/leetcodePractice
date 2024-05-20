package leetcode.easy;

public class No278 {

    public class Solution extends VersionControl {

        public int firstBadVersion(int n) {
            int left = 1, right = n;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    private abstract class VersionControl {

        boolean isBadVersion(int version) {
            return true;
        }
    }
}
