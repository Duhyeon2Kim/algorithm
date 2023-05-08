import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Testcase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < Testcase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] count = new int[10];
            Queue<int[]> q = new LinkedList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st2.nextToken());
                count[temp]++;
                q.add(new int[]{i, temp});
            }

            int answer=1;
            while (true) {
                int[] now = q.poll();
                boolean flag = true;
                for (int i = now[1]+1; i < 10; i++) {
                    if(count[i]>0) {flag=false; break;}
                }
                if(!flag) q.add(now);
                else {count[now[1]]--;
                    if(now[0]==M) break;
                    answer++;}
            }
            System.out.println(answer);
        }
    }
}
