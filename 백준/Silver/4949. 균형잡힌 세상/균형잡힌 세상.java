import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if(input.equals(".")) break;
            char[] arr = input.toCharArray();
            Stack<Character> s = new Stack<>();
            boolean flag = true;
            outer:
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(' || arr[i] == '[') s.add(arr[i]);
                else if (arr[i] == ')') {
                    if (!s.isEmpty() && s.peek() == '(') {
                        s.pop();
                    } else {
                        flag = false;
                        break outer;
                    }
                } else if (arr[i] == ']') {
                    if (!s.isEmpty() && s.peek() == '[') {
                        s.pop();
                    } else {
                        flag = false;
                        break outer;
                    }
                }
            }
            if(!s.isEmpty()) flag =false;
            if (flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
