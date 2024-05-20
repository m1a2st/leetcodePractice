package leetcode.data_structure.subList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubList {
    public static class IdxArray<T> {
        private final int m;
        private final int[] idxArray;

        private IdxArray(int m, int[] idxArray) {
            this.m = m;
            this.idxArray = idxArray;
        }

        public boolean hasNext() {
            return idxArray[0] < m - idxArray.length;
        }

        public IdxArray<T> next() {
            int[] idxArr = Arrays.copyOf(idxArray, idxArray.length);
            int pos = position();
            idxArr[pos]++;
            for (int i = pos + 1; i < idxArr.length; i++) {
                idxArr[i] = idxArr[i - 1] + 1;
            }
            return new IdxArray<>(m, idxArr);
        }

        public List<T> toList(List<T> src) {
            List<T> lt = new ArrayList<>();
            for (int idx : idxArray) {
                lt.add(src.get(idx));
            }
            return lt;
        }

        private int position() {
            if (idxArray[idxArray.length - 1] != m - 1) {
                return idxArray.length - 1;
            } else {
                int pos = idxArray.length - 2;
                while (idxArray[pos + 1] - idxArray[pos] == 1) {
                    pos--;
                }
                return pos;
            }
        }

        public static <T> IdxArray<T> get(int m, int n) {
            int[] idxArray = new int[n];
            for (int i = 0; i < n; i++) {
                idxArray[i] = i;
            }
            return new IdxArray<>(m, idxArray);
        }
    }

    public static <T> List<List<T>> from(List<T> src, int n) {
        IdxArray<T> idxArray = IdxArray.get(src.size(), n);
        List<List<T>> all = new ArrayList<>();
        all.add(idxArray.toList(src));
        while (idxArray.hasNext()) {
            idxArray = idxArray.next();
            all.add(idxArray.toList(src));
        }
        return all;
    }

    public static void main(String[] args) {
        List<Integer> src = Arrays.asList(1, 2, 3, 4, 5);
        for (List<Integer> lt : from(src, 3)) {
            System.out.println(lt);
        }
    }
}
