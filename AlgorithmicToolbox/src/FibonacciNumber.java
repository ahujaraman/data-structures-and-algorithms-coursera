import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {

        Scanner input =  new Scanner(System.in);
        int n = input.nextInt();
        long arr[] =  new long[n+1];

        if(n>=2)
        {
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<=n;i++)
            {
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[n] %10);
        }
        else
        {

                System.out.println(n);
        }


    }
}
