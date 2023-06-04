import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<int[]>> adjList;
    static boolean[] visit;
    static int V;
    static int Answer=0;
    static int targetNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            while (true) {
                int nodeNum = Integer.parseInt(st.nextToken());
                if (nodeNum == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                adjList.get(startNode).add(new int[]{nodeNum, distance});
            }
        }


            visit = new boolean[V + 1];
            visit[1]=true;
            dfs(1, 0);

            visit = new boolean[V + 1];
            visit[targetNode]=true;
            dfs(targetNode, 0);
            System.out.println(Answer);
    }

    private static void dfs(int startNode, int totalDistance) {
        if(totalDistance>Answer) {
            Answer = totalDistance;
            targetNode = startNode;
        }
            ArrayList<int[]> endNode = adjList.get(startNode);
            for (int j = 0; j < endNode.size(); j++) {
                int[] nodeInfo = endNode.get(j);
                if(visit[nodeInfo[0]]) continue;
                visit[nodeInfo[0]] = true;
                dfs(nodeInfo[0],totalDistance+nodeInfo[1]);
        }
    }
}