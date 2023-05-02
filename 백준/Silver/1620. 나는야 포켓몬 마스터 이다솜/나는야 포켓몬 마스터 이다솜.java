import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            map1.put(i, input);
            map2.put(input, i);
        }
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            int target = 0;
            String s = br.readLine();
            try {
                target = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                flag = false;
            }
            if (flag) {
                sb.append(map1.get(target)+"\n");
            } else {
                sb.append(map2.get(s)+"\n");
            }
        }
        System.out.println(sb);
    }
}