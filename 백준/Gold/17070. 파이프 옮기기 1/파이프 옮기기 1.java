import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new int[N][N];
		count=0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		map[0][0]=1;
		recursive(1,0,0);
		System.out.println(count);
	
	}

	private static void recursive(int x, int y, int state) {
		
		if(x<0 || x>=N || y<0 || y>=N) return;
		if(state==1 && y-1>=0 && x-1>=0 && (map[y-1][x]==1 || map[y][x-1]==1)) return;
		if(map[y][x]==1) return;
		if(x==N-1 && y==N-1) {count++; return;}
			map[y][x]=1;
			// 가로
			if(state==0) {
				recursive(x+1,y,0);
				recursive(x+1,y+1,1);
			}
		
			//대각선
			if(state==1) {
				recursive(x+1,y,0);
				recursive(x,y+1,2);
				recursive(x+1,y+1,1);
			}
			
			//세로
			if(state==2) {
				recursive(x,y+1,2);
				recursive(x+1,y+1,1);
			}
			map[y][x]=0;
	}
}
