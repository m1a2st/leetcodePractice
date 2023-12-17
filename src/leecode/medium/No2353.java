package leecode.medium;

import java.util.*;

public class No2353 {

    class FoodRatings {
        Map<String, TreeSet<Pair>> cuisineToRatingAndFoods = new HashMap<>();
        Map<String, String> foodToCuisine = new HashMap<>();
        Map<String, Integer> foodToRating = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; ++i) {
                cuisineToRatingAndFoods.putIfAbsent(
                        cuisines[i],
                        new TreeSet<>((a, b)
                                -> a.rate.equals(b.rate) ? a.foodName.compareTo(b.foodName)
                                : b.rate - a.rate));
                cuisineToRatingAndFoods.get(cuisines[i]).add(new Pair(ratings[i], foods[i]));
                foodToCuisine.put(foods[i], cuisines[i]);
                foodToRating.put(foods[i], ratings[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            final String cuisine = foodToCuisine.get(food);
            final int oldRating = foodToRating.get(food);
            TreeSet<Pair> ratingAndFoods = cuisineToRatingAndFoods.get(cuisine);
            ratingAndFoods.remove(new Pair(oldRating, food));
            ratingAndFoods.add(new Pair(newRating, food));
            foodToRating.put(food, newRating);
        }

        public String highestRated(String cuisine) {
            return cuisineToRatingAndFoods.get(cuisine).first().foodName;
        }

        class Pair {
            Integer rate;
            String foodName;

            public Pair(Integer rate, String foodName) {
                this.rate = rate;
                this.foodName = foodName;
            }
        }
    }
}
