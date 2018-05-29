import java.util.Scanner;

public class FibonnaciSumLastDigit {
    public static void main(String[] args) {

        Scanner input =  new Scanner(System.in);
        long  n = input.nextLong();
        long sum =1;

        if(n>=2)
        {

            long prev= 1;
            long  prev_prev = 0;
            long  cur=0;
            for(long i=2;i<=n;i++)
            {
                /*
                arr[i] = arr[i-1] + arr[i-2];
                arr[i] = arr[i]%10;
                sum = sum%10 + arr[i];
                */
                cur = prev + prev_prev;
                cur = cur %10;
                prev_prev = prev;
                prev = cur;
                sum = sum%10 + cur;
            }
            System.out.println(sum%10);
        }
        else
        {

            System.out.println(n);
        }


    }
}
