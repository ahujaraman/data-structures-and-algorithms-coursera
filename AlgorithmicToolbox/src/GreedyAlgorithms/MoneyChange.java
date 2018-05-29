package GreedyAlgorithms;

import java.util.Scanner;

public class MoneyChange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long count=0;
        long remainder=0;



            if(n>10){
                remainder=n%10;
                count = count + n/10;
                n = remainder;
            }
            if(n>=5){
                remainder=n%5;
                count = count + n/5;
                n = remainder;
            }
            if (n<5)
            {
                count= count + n;
                n = 0;
            }

        System.out.println(count);
    }
}
