import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static StringBuilder sb;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		visit = new boolean[N];
		recursive(0);
		System.out.println(sb);
	}
	private static void recursive(int idx) {
		if(idx==N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]+" ");
			}sb.append("\n");
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[idx]=i+1;
				recursive(idx+1);
				visit[i]=false;
			}
		}
	}
}