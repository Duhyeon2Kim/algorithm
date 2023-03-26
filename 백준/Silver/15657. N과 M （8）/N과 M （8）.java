import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		recursive(0,0);
		System.out.println(sb);
		
		
	}
	private static void recursive(int idx,int target) {
		if(idx==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=target; i<N; i++) {
			result[idx]=arr[i];
			recursive(idx+1, i);
		}
	}
}