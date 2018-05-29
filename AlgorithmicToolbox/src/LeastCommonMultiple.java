import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int num1=a;
        int num2 = b;
        int c=0;
        int stop=0;

        while(stop==0)
        {
            if(a%b==0)
            {
                stop=1;
            }
            else
            {
                c = a%b;
                a = b;
                b = c;
            }
        }

/*
Applying formula Product of Two numbers = LCM *GCD
 */
 long x = num1/b;
        System.out.println(x*num2);

    }
}
