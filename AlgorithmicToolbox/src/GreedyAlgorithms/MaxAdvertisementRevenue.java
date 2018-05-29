

import java.util.Arrays;
import java.util.Scanner;

public class MaxAdvertisementRevenue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n =  input.nextInt();
        long[] profit = new long[n];
        long[] click = new long[n];
        long sum =0;

        for(int i=0;i<n;i++)
        {
            profit[i] = input.nextLong();
        }

        for(int i=0;i<n;i++)
        {
            click[i] = input.nextLong();
        }

        Arrays.sort(profit);
        Arrays.sort(click);

        for (int i=0;i<n;i++){
                sum = sum + profit[i]*click[i];
        }

        System.out.println(sum);
    }
}
