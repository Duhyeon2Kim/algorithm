import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int Y,X;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = new int[] {-1,1,0,0};
	static int[] dx = new int[] {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		visit = new boolean[Y][X];
		for(int i=0; i<Y; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0; j<X; j++) {
				map[i][j]=Integer.parseInt(st2.nextToken());
			}
		}
		int leftcheeze=check();
		int count=0;
		
		outer2:
		for(int c=0; c<100; c++) {
			outer:
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				if(!visit[i][j] &&  map[i][j]==0) {bfs(j,i); break outer;}
			}
		}
			for(int i=0; i<Y; i++) {
				for(int j=0; j<X; j++) {
					if(visit[i][j]==true&&map[i][j]==1) map[i][j]=0;
				}
			}
			
			count++;
			visit = new boolean[Y][X];
			int temp=check();
			if(temp==0) break outer2;
			else leftcheeze=temp;
		}
		
		System.out.println(count);
		System.out.println(leftcheeze);
		
	}
	private static int check() {
		int restcheeze=0;
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				if(map[i][j]==1) restcheeze++;
			}
		}
		return restcheeze;
	}
	
	private static void bfs(int Xidx, int Yidx) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {Xidx,Yidx});
		visit[Yidx][Xidx]=true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX=now[0];
			int nowY=now[1];
			
			for(int i=0; i<4; i++) {
				int nextX=nowX+dx[i];
				int nextY=nowY+dy[i];
				if(nextX<0 || nextX>=X||nextY<0 || nextY>=Y ) continue;
				
				if(!visit[nextY][nextX]&&map[nextY][nextX]==0) {
					q.add(new int[] {nextX,nextY}); visit[nextY][nextX]=true;
				}
				if(!visit[nextY][nextX]&&map[nextY][nextX]==1)visit[nextY][nextX]=true;
			}
		}
	}
}	