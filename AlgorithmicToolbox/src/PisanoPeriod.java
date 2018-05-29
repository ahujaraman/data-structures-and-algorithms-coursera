import java.util.Scanner;

public class PisanoPeriod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] arr =  new int[10000];
        int stop =0;
        int[] fib = new int[20000000];
        fib[0]=0;
        fib[1]=1;
        arr[0]=0;
        arr[1]=1;
        int count=0;
        String pisanoPeriod = "01";
        int i=2;
        for(i=2;i<=m && stop== 0;i++)
        {
            fib[i] = fib[i-1] + fib[i-2];
            arr[i] = fib[i]%m;
            pisanoPeriod =  pisanoPeriod + arr[i];
            //System.out.println(pisanoPeriod.length());
            if (pisanoPeriod.length()>2) {
                if (pisanoPeriod.substring(pisanoPeriod.length() - 2, pisanoPeriod.length()).equals("01")) {
                    stop = 1;
                }
            }
        }

        pisanoPeriod = pisanoPeriod.substring(0,pisanoPeriod.length()-2);
        int repeat_length = pisanoPeriod.length();
        System.out.println(repeat_length);
        System.out.println(pisanoPeriod);
       int reducedEquivalentNumber = n%repeat_length;
       System.out.println(fib[reducedEquivalentNumber]%m);
    }
}
