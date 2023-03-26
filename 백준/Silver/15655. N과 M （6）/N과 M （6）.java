import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int N;
static int[] arr;
static int M;
static int[] result; 
static int idx;
static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr = new int[N];
		result = new int[M];
		idx=0;
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0,0);
		System.out.println(sb);
	}
	private static void dfs(int def,int idx) {
		if(def==M) {
			for(int i=0; i<M; i++) {
			sb.append(result[i]+" ");}
			sb.append("\n"); return;
		}
		if(idx==N) {
			return;
		}
		result[def]=arr[idx];
		dfs(def+1,idx+1);
		dfs(def,idx+1);
	}
}