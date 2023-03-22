import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb= new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[M];
		dfs(0);
		System.out.println(sb);
		
	}

	private static void dfs(int depth) {
		if(depth==M) {
			for(int i=0;  i<M; i++) {
				sb.append(arr[i]+" ");
			}sb.append("\n");
			return;
		}
		int temp=0;
		if(depth>0) {
		temp = arr[depth-1];}
		for(int i=temp; i<=N; i++) {
			if(i>0) {
			arr[depth]=i;
			dfs(depth+1);}
		}
	}
}