import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T[];
    static int P[];
    static int N,answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        answer = 0;
        
        for(int i=0; i<N; i++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(answer);

    }

    public static void dfs(int depth, int sum) {
        if(depth == N) {
            answer = Math.max(answer,sum);
            return;
        }
        if(depth > N) return;
        dfs(depth + T[depth], sum+P[depth]);
        dfs(depth+1, sum);

    }
}