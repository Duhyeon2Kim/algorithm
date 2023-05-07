import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long max = (long)Integer.MAX_VALUE+1;
        long min = 0;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(min<max) {
            long middle = (max + min) / 2;
            long totalLine = 0;
            for (int i = 0; i < N; i++) {
                totalLine += (arr[i] / middle);
            }

            if(totalLine>=K) min = middle+1;
            else max = middle;
        }
        System.out.println(max-1);
    }
}
