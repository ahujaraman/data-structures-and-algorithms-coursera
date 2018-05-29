package GreedyAlgorithms;

import java.util.Scanner;

public class MaxNumOfPrizes {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        long num = input.nextLong();
        long count = 0;
        long i=1;
        int stop=0;
        while(stop==0){

            if(i >= num -i){
                stop=1;
                count++;
            }
            else {
                num = num -i;
                count++;
                i++;
            }

        }
            System.out.println(count);

        for (int j=1;j<count;j++){
                System.out.print(j+" ");
        }
        if (num>0){
            System.out.print(num);
        }
    }
}
