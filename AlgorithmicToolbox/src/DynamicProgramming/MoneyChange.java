package DynamicProgramming;

import java.util.Scanner;

public class MoneyChange {

    private static int getChange(int m, int[] coins) {

        int[] MinNumCoins = new int[m+1];
        MinNumCoins[0] = 0;


        for (int i = 1; i <= m; i++) {
            MinNumCoins[i] = 1818188181;
            int NumCoins = 0;
            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j]) {
                    NumCoins = MinNumCoins[i - coins[j]] + 1;

                    if (NumCoins < MinNumCoins[i]) {
                        MinNumCoins[i] = NumCoins;
                    }
                }
            }
        }

        return MinNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] coins = new int[3];
        coins[0]=1;
        coins[1]=3;
        coins[2]=4;


        System.out.println(getChange(m,coins));

    }
}
