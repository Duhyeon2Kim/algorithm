import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<ArrayList<Edge>> adjList;
    static int[] arr;

    static class Edge implements Comparable<Edge> {
        int start,end,weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo( Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) break;
            adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }
            int totalPrice = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int adam = Integer.parseInt(st2.nextToken());
                int eve = Integer.parseInt(st2.nextToken());
                int expense = Integer.parseInt(st2.nextToken());
                totalPrice += expense;
                adjList.get(adam).add(new Edge(adam, eve, expense));
                adjList.get(eve).add(new Edge(eve, adam, expense));
            }
            boolean[] visit = new boolean[M];
            visit[0] = true;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < adjList.get(0).size(); i++) {
                pq.add(adjList.get(0).get(i));
            }

            int pick = 1;
            int answer = 0;
            while (pick != M) {
                Edge e = pq.poll();
                if (visit[e.end]) continue;
                answer += e.weight;
                pq.addAll(adjList.get(e.end));
                visit[e.end] = true;
                pick++;
            }
            System.out.println(totalPrice - answer);
        }
    }
}