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
	static LinkedHashSet<String> list;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		list = new LinkedHashSet<>();
		sb = new StringBuilder();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st2.nextToken());
		}
		
		Arrays.sort(arr);
		recursive(0);
		for(String x: list) {
			sb.append(x);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static void recursive(int idx) {
		if(idx == M) {
			String temp="";
			for(int i=0; i<M; i++) {
				temp+=result[i]+" ";
			}
			{list.add(temp);}
			return;
		}
		for(int i=0; i<N; i++) {
				result[idx]=arr[i];
				recursive(idx+1);
			}
	}
}