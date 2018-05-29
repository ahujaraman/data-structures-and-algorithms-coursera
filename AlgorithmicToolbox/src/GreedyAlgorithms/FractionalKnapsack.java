package GreedyAlgorithms;

import java.util.Scanner;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int capacity = input.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        double[] unit = new double[n];

        for(int i=0;i<n;i++){
            value[i] = input.nextInt();
            weight[i] = input.nextInt();
            unit[i] = value[i] / weight[i];
        }
    }
}
