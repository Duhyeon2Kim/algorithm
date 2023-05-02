import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] temp = str.split(" ");
        int answer = temp.length;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].equals("")) answer--;
        }
        System.out.println(answer);
    }
}
