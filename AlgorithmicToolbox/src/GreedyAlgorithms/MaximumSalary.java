package GreedyAlgorithms;

import java.util.*;

public class MaximumSalary {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<Integer> list = new ArrayList<Integer>();

        for (int i=0;i<n;i++){
            list.add( input.nextInt());
        }

        while (!list.isEmpty()){

            int max_digit = -1;
            for(int i =0;i<list.size();i++){
                max_digit = maxDigit(max_digit,list.get(i));
            }

        }
    }

    public static int maxDigit(int num1, int num2){
        int max=-1;
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        int i =0;
        while (num1!=0){
            int right_digit = num1%10;
            arr1.add(right_digit) ;
            if(right_digit>max){
                max = right_digit;
            }
            num1 = num1/10;
            i++;
        }

        i=0;
        while (num2!=0){
            int right_digit = num2%10;
            arr2.add(right_digit);
            if(right_digit>max){
                max = right_digit;
            }
            num2 = num2/10;
        }
        int stop =0;
        i=0;
        while(stop==0){
            for (int j=0;j<arr1.size() && stop==0;j++){
                for (int k=0;k<arr2.size() && stop==0;k++){
                    if (arr1.get(i)> arr2.get(i)){
                        stop=1;
                    }
                }

            }
        }

        return max;
    }
}

