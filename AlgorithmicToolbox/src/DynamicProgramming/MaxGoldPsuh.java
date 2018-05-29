package DynamicProgramming;

import java.util.Scanner;

public class MaxGoldPsuh {
    static int optimalWeight(int W, int[] w) {
        int n_itms = 0;
        for (int item : w) {
            if (item <= W)
                n_itms++;
        }
        int[] items = new int[n_itms];
        int index = 0;
        for (int i = 0; i < w.length - 1; i++) {
            if (w[i] <= W) {
                items[index] = w[i];
                index++;
            }
        }

        int n = W + 1;

        int value[][] = new int[items.length + 1][n];

        for (int col = 0; col <= W; col++) {
            value[0][col] = 0;
        }

        for (int row = 0; row <= items.length; row++) {
            value[row][0] = 0;
        }

        for (int item = 1; item <= items.length; item++) {
            for (int weight = 1; weight <= W; weight++) {
                if (items[item - 1] <= weight) {
                    value[item][weight] = Math.max(items[item - 1] + value[item - 1][weight - items[item - 1]],
                            value[item - 1][weight]);
                } else {
                    value[item][weight] = value[item - 1][weight];
                }
            }
        }
        return value[items.length +1][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
