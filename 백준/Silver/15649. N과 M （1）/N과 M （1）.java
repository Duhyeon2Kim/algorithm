import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static boolean[]visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		arr= new int[M];
		recursive(0);
		System.out.println(sb);
		
		
	}
	private static void recursive(int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]+" ");
			}sb.append("\n"); return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[idx]=i+1;
			recursive(idx+1);
			visit[i]=false;}
			
		}
	}
}