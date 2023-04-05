import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	static int answer;
	static int[] dx = new int[] {-1,1,0,0};
	static int[] dy = new int[] {0,0,-1,1};
	
	static class Node implements Comparable<Node> {
		int X;
		int Y;
		int cost;
		
		public Node(int x, int y, int cost) {
			X = x;
			Y = y;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase=1;
		while(true) {
		answer=0;
		N=Integer.parseInt(br.readLine());
		if(N==0) {break;}
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println("Problem "+(testcase++)+": "+dijkstra(0,0));
		
		} // 반복문
	}

	private static int dijkstra(int X, int Y) {
		int[][] distance = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		distance[0][0]=map[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, Y, distance[0][0]));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nowX = now.X;
			int nowY = now.Y;
			if(nowX==N-1 && nowY==N-1) break;
			if(visit[nowY][nowX]) continue;
			visit[nowY][nowX]=true;
			
			for(int i=0; i<4; i++) {
				int nextX = nowX+dx[i];
				int nextY = nowY+dy[i];
				if(nextX<0|| nextX>=N ||nextY<0|| nextY>=N) continue;
				int nowDistance = now.cost+map[nextY][nextX];
				if(distance[nextY][nextX]>nowDistance) {
					distance[nextY][nextX]=nowDistance;
					pq.offer(new Node(nextX, nextY, nowDistance));
				}
			}
		}
		return distance[N-1][N-1];
	}
}