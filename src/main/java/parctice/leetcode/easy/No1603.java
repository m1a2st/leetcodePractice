package main.java.parctice.leetcode.easy;

public class No1603 {

    class ParkingSystem {

        int[] parking = new int[3];
        int[] nowParking = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            parking[0] = big;
            parking[1] = medium;
            parking[2] = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                nowParking[0] += 1;
                return parking[0] <= nowParking[0];
            } else if (carType == 2) {
                nowParking[1] += 1;
                return parking[1] <= nowParking[1];
            } else {
                nowParking[2] += 1;
                return parking[2] <= nowParking[2];
            }
        }
    }
}
