package practice.leetcode.easy;

import java.util.Arrays;

public class No2418 {

    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            int n = names.length;
            Person[] people = new Person[n];
            for (int i = 0; i < n; ++i)
                people[i] = new Person(names[i], heights[i]);
            
            Arrays.sort(people);
            
            String[] ans = new String[n];
            for (int i = 0; i < n; ++i)
                ans[i] = people[i].name;
            
            return ans;
        }
        
        class Person implements Comparable<Person> {
            String name;
            int height;
            
            Person(String name, int height) {
                this.name = name;
                this.height = height;
            }

            @Override
            public int compareTo(Person o) {
                return this.height - o.height;
            }
        }
    }
}
