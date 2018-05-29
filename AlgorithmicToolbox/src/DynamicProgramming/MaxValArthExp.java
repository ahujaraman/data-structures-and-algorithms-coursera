
package DynamicProgramming;
import java.util.Scanner;

public class MaxValArthExp {
    private static long getMaximValue(String exp) {

        int n = (exp.length() +1)/2 + 1;
         long [][] min_arr = new long[n][n];
        long[][] max_arr = new long[n][n];
        long[] digits = new long[n];
        char[] operands = new char[n];
        int k=1;
        int op_counter = 1;
        //System.out.println("Number : "+n);

        for (int i=0;i<exp.length();i++){
            if (i%2 == 0){
                digits[k] = exp.charAt(i) - '0';
               // System.out.println("Digit : "+digits[k]);
                k++;
            }
            else
            {
                operands[op_counter] = exp.charAt(i);
                //System.out.println("operands : "+operands[op_counter]);
                op_counter++;
            }
        }




        for (int i=1; i<n;i++){
            min_arr[i][i] = digits[i];
            max_arr[i][i] = digits[i];
        }

        for (int s =1;s < n-1 ;s++){
            for (int i=1;i< n-s;i++){
                int j = i+s;
                long[] val = new long[2];
                val = MinAndmax(i,j,min_arr,max_arr,operands);
                min_arr[i][j] = val[0];
                max_arr[i][j] = val[1];


            }
        }





        return max_arr[1][n-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }



    public static long[] MinAndmax(int i, int j, long[][] min_arr,long[][] max_arr,char[] operands){

        long min = 999999999;
        long max = -999999999;

        for(int k=i;k<=j-1;k++){
            char operand_k = operands[k];
            long a = eval(max_arr[i][k],max_arr[k+1][j],operand_k);
            long b = eval(max_arr[i][k],min_arr[k+1][j],operand_k);
            long c = eval(min_arr[i][k],max_arr[k+1][j],operand_k);
            long d = eval(min_arr[i][k],min_arr[k+1][j],operand_k);

            min = Math.min(min,Math.min(a,Math.min(b,Math.min(c,d))));
            max = Math.max(max,Math.max(a,Math.max(b,Math.max(c,d))));
        }

        long[] val = new long[2];
        val[0] = ( min);
        val[1] = ( max);
        return val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
