import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] adjList;
    static int[] populations;
    static boolean[] check;
    static ArrayList<Integer> areaA,areaB;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N + 1];
        check = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st2.nextToken());
            int adam = i;
            for(int j=0; j<num; j++) {
                int eve = Integer.parseInt(st2.nextToken());
                    adjList[adam].add(eve);
                    adjList[eve].add(adam);
            }
        }


        combination(1);

        if(answer!=Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println(-1);


    }

    private static void combination(int depth) {
        if(answer==0) return;
        if(depth==N+1) {
            areaA = new ArrayList<>();
            areaB = new ArrayList<>();

            for(int i=1; i<=N; i++) {
                if(check[i]==true) {areaA.add(i);}
                else {areaB.add(i);}
            }
            answer = Math.min(election(), answer);
            return;
        }
        check[depth]=true;
        combination(depth+1);
        check[depth]=false;
        combination(depth+1);
    }

    private static int election() {
        if(areaA.size()==0) return Integer.MAX_VALUE;
        if(areaB.size()==0) return Integer.MAX_VALUE;
        boolean[] visit=new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(areaA.get(0));
        visit[areaA.get(0)] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i<adjList[now].size(); i++) {
                int next = adjList[now].get(i);
                if(areaA.contains(next)&&!visit[next]) {visit[next]=true; q.add(next); }
            }
        }
        for(int i=0; i<areaA.size(); i++) {
            if(!visit[areaA.get(i)]) return Integer.MAX_VALUE;
        }

        visit=new boolean[N+1];
        q = new LinkedList<>();
        q.offer(areaB.get(0));
        visit[areaB.get(0)] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i<adjList[now].size(); i++) {
                int next = adjList[now].get(i);
                if(areaB.contains(next)&&!visit[next]) {visit[next]=true; q.add(next); }
            }
        }
        for(int i=0; i<areaB.size(); i++) {
            if(!visit[areaB.get(i)]) return Integer.MAX_VALUE;
        }

        int sumA =0;
        int sumB= 0;
        for(int i=0; i<areaA.size(); i++) {
            sumA+=populations[areaA.get(i)];
            }
        for(int i=0; i<areaB.size(); i++) {
            sumB+=populations[areaB.get(i)];
        }
        return Math.abs(sumA - sumB);
    }
}
