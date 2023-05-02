import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> arr = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();

            if (arr.contains(temp)) {
                {answer++; result.add(temp); }
            }
        }
        Collections.sort(result);
        System.out.println(answer);
        for (String s : result) {
            System.out.println(s);
        }
    }
}