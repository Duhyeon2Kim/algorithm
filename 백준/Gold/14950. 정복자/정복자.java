import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,t;
	static int[] parent;
	static PriorityQueue<int[]> pQueue;
	public static void main(String[] args) throws IOException {
		// 보충때 배운 pQ 야무지게 써보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); // 도시갯수
		M=Integer.parseInt(st.nextToken()); // 도로갯수
		t=Integer.parseInt(st.nextToken());	// 오르는 정복비용
		pQueue= new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		for(int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int node1=Integer.parseInt(st2.nextToken());
			int node2=Integer.parseInt(st2.nextToken());
			int weight=Integer.parseInt(st2.nextToken());
			pQueue.add(new int[] {node1,node2,weight});
		}
		
		parent = new int[N+1];
		for(int i=0; i<=N; i++) {
			parent[i]=i;
		}
		
		int ans=0;
		int pick=0;
		while(!pQueue.isEmpty()) {
			int[] now =pQueue.poll();
			int node1 =now[0];
			int node2 =now[1];
			int weight=now[2];
			if(findSet(node1)==findSet(node2)) continue;
			unionSet(node1,node2);
			ans+=(weight+t*pick);
			pick++;
			if(pick==N-1) break;
		}
		System.out.println(ans);
	}
	private static void unionSet(int X, int Y) {
		parent[findSet(Y)]=findSet(X);
		
	}
	private static int findSet(int X) {
		if(X==parent[X]) return X;			
		return parent[X]=findSet(parent[X]);
	}
}