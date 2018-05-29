package DivideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr_input[] =  new int[n];
        int maj_index = 0;
        int cur_count=1;


        arr_input[0] = input.nextInt();
        for(int i =1; i<n;i++){
            arr_input[i] = input.nextInt();
            if(arr_input[maj_index] == arr_input[i]){
                cur_count++;
            }
            else
                cur_count--;
            if(cur_count==0){
                maj_index=i;
                cur_count=1;
            }

        }



        int count_max_index=0;
        for (int i=0;i<n;i++){
            if (arr_input[i]== arr_input[maj_index]){
                count_max_index++;
            }
        }

         double count_mid = n/2.0;

        if (n==1){
            System.out.println(0);
        }
        else {
            if (count_max_index > count_mid){
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }

    }
}
