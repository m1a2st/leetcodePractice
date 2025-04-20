package practice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class No2115 {

    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
                                           String[] supplies) {
            List<String> ans = new ArrayList<>();
            Set<String> suppliesSet = new HashSet<>();
            Collections.addAll(suppliesSet, supplies);
            Map<String, List<String>> graph = new HashMap<>();
            Map<String, Integer> inDegrees = new HashMap<>();

            // Build the graph.
            for (int i = 0; i < recipes.length; ++i)
                for (final String ingredient : ingredients.get(i))
                    if (!suppliesSet.contains(ingredient)) {
                        graph.putIfAbsent(ingredient, new ArrayList<>());
                        graph.get(ingredient).add(recipes[i]);
                        inDegrees.merge(recipes[i], 1, Integer::sum);
                    }

            // Perform topological sorting.
            Queue<String> q = Arrays.stream(recipes)
                    .filter(recipe -> inDegrees.getOrDefault(recipe, 0) == 0)
                    .collect(Collectors.toCollection(ArrayDeque::new));

            while (!q.isEmpty()) {
                final String u = q.poll();
                ans.add(u);
                if (!graph.containsKey(u))
                    continue;
                for (final String v : graph.get(u)) {
                    inDegrees.merge(v, -1, Integer::sum);
                    if (inDegrees.get(v) == 0)
                        q.offer(v);
                }
            }

            return ans;
        }
    }
}
