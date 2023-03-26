import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static LinkedHashSet<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visit = new boolean[N];
		list = new LinkedHashSet<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		recursive(0,0);
		for(String x: list) {
			System.out.println(x);
		}
		
	}
	private static void recursive(int idx,int target) {
		if(idx == M) {
			String temp="";
			for(int i=0; i<M; i++) {
				temp+=result[i]+" ";
			}
			{list.add(temp);}
			return;
		}
		for(int i=target; i<N; i++) {
			if(!visit[i]) {
				visit[i]=true;
				result[idx]=arr[i];
				recursive(idx+1,i+1);
				visit[i]=false;	
			}
		}
	}
}