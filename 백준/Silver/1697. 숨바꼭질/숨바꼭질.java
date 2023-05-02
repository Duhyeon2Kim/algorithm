import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[100001];

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        q.add(new int[] {N,0});
        visit[N]=true;
        int answer=0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int Now = poll[0];
            int depth = poll[1];
            if(Now==K) {answer=depth; break;}
            if(Now<0) continue;
            if(Now>100000) continue;
            if(Now*2<=100000&&!visit[Now*2]) {
                visit[Now*2]=true;
            q.add(new int[] {Now*2,depth+1});}
            if(Now+1<=100000&&!visit[Now+1]) {
                visit[Now+1]=true;
            q.add(new int[] {Now+1,depth+1});}
            if(Now-1>=0&&!visit[Now-1]) {
                visit[Now-1]=true;
            q.add(new int[] {Now-1,depth+1});}

        }
        System.out.println(answer);
    }
}