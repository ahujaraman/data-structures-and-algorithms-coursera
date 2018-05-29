import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

public class BalancingBrackets {

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        boolean result = true;
        int current_counter = 1;
        int no_closing = 0;
        int returning_position= 0;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length() && result == true; ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                Bracket current_item = new Bracket(next,position);
                opening_brackets_stack.push(current_item);
            }

            if (next == ')' || next == ']' || next == '}') {
                if(opening_brackets_stack.isEmpty() == true){
                    result = false;
                }
                else{
                    Bracket top_item = opening_brackets_stack.pop();
                    result =   top_item.Match(next);
                    no_closing++;
                }

            }
            current_counter++;
        }

        if (opening_brackets_stack.isEmpty() == false && result == true){
            System.out.println(opening_brackets_stack.pop().position + 1);
            result = false;
        }
       else if (result == true && no_closing!=0){
            System.out.println("Success");
       }
       else if (no_closing == 0){
           System.out.println(current_counter-1);
       }
       else {
            System.out.println(current_counter-1);
       }
    }
}
