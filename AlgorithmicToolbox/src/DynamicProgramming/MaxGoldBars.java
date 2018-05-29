package DynamicProgramming;

import java.util.Scanner;

public class MaxGoldBars {

    static int optimalWeight(int W, int[] w) {
        //write you code here

        int n   = w.length + 1;
         W = W +1 ;
        int[][] value = new int[W][n];

        for (int i=0; i<W; i++){
            value[0][i] = 0;
        }

        for (int k =0; k<n; k++){
            value[k][0] = 0;
        }

        int[] weight =  new int[n];

        for (int i=0;i<n-1;i++){
            weight[i+1] = w[i];
        }

        for (int i =1;i<n;i++){
            for (int k =1;k<W;k++){
                value[k][i] =   value[k][i-1];
                if (weight[i] < k){
                    int val  = value[k - i][i-1] + weight[i];
                    if (value[k][i] < val){
                        value[k][i] = val;
                    }
                }
            }
        }


        return value[W-1][n-1];
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
