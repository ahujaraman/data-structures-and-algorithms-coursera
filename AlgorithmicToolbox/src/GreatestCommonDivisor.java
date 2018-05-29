

import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
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

        System.out.println(b);

    }
}
