package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();

        int[] MinNumberSteps = new int[n+1];
        MinNumberSteps[0]=0;
        MinNumberSteps[1]=0;
        int[] TrackSequence = new int[n+1];
        int[] probable_seq = new int[3];
        TrackSequence[1] =1;

        for (int i=2;i<=n;i++){

            MinNumberSteps[i]=999999999;
            int Min_Mul_three = 999999999;
            int Min_Mul_two = 999999999;

            int Min_add = MinNumberSteps[i-1] +1;
            if(i%3 == 0){
                 Min_Mul_three = MinNumberSteps[i/3] +1;
            }
            if(i%2 == 0 ){
                Min_Mul_two = MinNumberSteps[i/2] +1;
            }

            int Min_Overall = Min_add;
            TrackSequence[i]=1;
            MinNumberSteps[i] = Min_Overall;

            if ( Min_Mul_three < Min_Overall){
                MinNumberSteps[i] = Min_Mul_three;
                TrackSequence[i] = 3;
                Min_Overall= Min_Mul_three;
            }
            if (Min_Mul_two < Min_Overall){
                MinNumberSteps[i] = Min_Mul_two;
                TrackSequence[i] = 2;
            }

        }


        int jumper = n;
        sequence.add(n);
        while (jumper>=1){

            if (jumper == 1){
                jumper = -1;
            }
            else {

                if (TrackSequence[jumper] == 3) {
                    sequence.add(jumper / 3);
                    jumper = jumper / 3;
                } else if (TrackSequence[jumper] == 2) {
                    sequence.add(jumper / 2);
                    jumper = jumper / 2;
                } else {
                    sequence.add(jumper - 1);
                    jumper = jumper - 1;
                }
            }

        }


        Collections.reverse(sequence);
        return sequence;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
