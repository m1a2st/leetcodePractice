package parctice.lintcode.medium;

public class No1153 {

    public class Solution {
        /**
         * @param s: string
         * @return: sort string in lexicographical order
         */
        public String sorting(String s) {
            String[] dictionaries = s.split(",");
            mergeSort(dictionaries);
            StringBuilder sb = new StringBuilder();
            for (String dictionary : dictionaries) {
                sb.append(dictionary).append(",");
            }
            return sb.substring(0, sb.length() - 1);
        }

        private void mergeSort(String[] dictionaries) {
            int len = dictionaries.length;
            if (len > 1) {
                String[] left = new String[len / 2];
                System.arraycopy(dictionaries, 0, left, 0, len / 2);
                mergeSort(left);
                String[] right = new String[len - len / 2];
                System.arraycopy(dictionaries, len / 2, right, 0, len - len / 2);
                mergeSort(right);
                merge(left, right, dictionaries);
            }
        }

        private void merge(String[] left, String[] right, String[] temp) {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.length && j < right.length) {
                if (compare(left[i], right[j])) {
                    temp[k++] = left[i++];
                } else {
                    temp[k++] = right[j++];
                }
            }
            while (i < left.length) {
                temp[k++] = left[i++];
            }
            while (j < right.length) {
                temp[k++] = right[j++];
            }
        }

        private boolean compare(String s, String s1) {
            char[] sArr = s.toCharArray();
            char[] s1Arr = s1.toCharArray();
            int i = 0, j = 0;
            while (i < sArr.length && j < s1Arr.length) {
                if (sArr[i] != s1Arr[j]) {
                    return sArr[i] - s1Arr[j] < 0;
                } else {
                    i++;
                    j++;
                }
            }
            return i >= sArr.length;
        }
    }
}
