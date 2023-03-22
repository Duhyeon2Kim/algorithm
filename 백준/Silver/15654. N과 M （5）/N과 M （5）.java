import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] check;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr=new int[N];
		result=new int[N];
		check=new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}sb.append("\n"); return;
		} 
		for(int i=0; i<N; i++) {
			if(!check[i]) {
				check[i]=true;
				result[depth]=arr[i];
				dfs(depth+1);
				check[i]=false;
			}
			
		}
	}
}
