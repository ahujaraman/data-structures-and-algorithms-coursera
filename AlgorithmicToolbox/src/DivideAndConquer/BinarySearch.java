package DivideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String args[]){

       Scanner input =  new Scanner(System.in);

        int n  = input.nextInt();
        int[] arr_input_sorted = new int[n];

        for(int i =0;i<n;i++){
            arr_input_sorted[i] = input.nextInt();
        }


        int k = input.nextInt();
        int[] arr_input_search = new int[k];
        for(int i =0;i<k;i++){
            int key = input.nextInt();
          arr_input_search[i] =   BinarySearchNumber(arr_input_sorted,0,n-1,key);
        }

        for (int i=0;i<k;i++){
                System.out.print(arr_input_search[i] + " ");
        }
      //System.out.println(BinarySearchNumber(arr_input_sorted,0,n-1,0));
    }


    public static int BinarySearchNumber(int[] arr_input_sorted,int low, int high, int key){

        if(high < low){
            return -1;
        }
        int mid = (low + (high - low) / 2);

        if (key == arr_input_sorted[mid])
            return mid;
        else if(key< arr_input_sorted[mid])
            return BinarySearchNumber(arr_input_sorted,low,mid-1,key);
        else return BinarySearchNumber(arr_input_sorted,mid+1,high,key);
    }
}
