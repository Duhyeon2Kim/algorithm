import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,start,end;
    static int[] cities;
    static int[] costs;

    static ArrayList<ArrayList<Edge>> adjList;
    static class Edge implements Comparable<Edge>{
        int adam,eve,expense;

        public Edge(int adam, int eve, int expense) {
            this.adam = adam;
            this.eve = eve;
            this.expense = expense;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.expense,o.expense);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        cities = new int[N + 1];
        costs = new int[N + 1];

        Arrays.fill(costs,Integer.MAX_VALUE);

        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int adam = Integer.parseInt(st.nextToken());
            int eve = Integer.parseInt(st.nextToken());
            int expense = Integer.parseInt(st.nextToken());
            adjList.get(adam).add(new Edge(adam, eve, expense));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dikstra(start);
        System.out.println(costs[end]);




    }

    private static void dikstra(int start) {
        PriorityQueue<Edge> pq =new PriorityQueue<>();
        costs[start]=0;
        pq.add(new Edge(start,0,0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            int cost = costs[now.adam];
            if(now.adam==end) return;
            if(costs[now.adam]<cost) continue;
            for (int i=0; i<adjList.get(now.adam).size(); i++) {
                int nowCost= costs[now.adam]+adjList.get(now.adam).get(i).expense;
                if(costs[adjList.get(now.adam).get(i).eve]>nowCost) {
                    costs[adjList.get(now.adam).get(i).eve]=nowCost;
                    pq.add(new Edge(adjList.get(now.adam).get(i).eve,0,nowCost));
                }
            }
        }
    }
}
