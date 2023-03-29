import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=Testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			count=0;
			int t=N-M;
			double up=1;
			for(int i=0; i<t; i++) {
				up=up*N;
				N--;
//				System.out.println(up);
			}
//			System.out.println(up);
			double down=1;
 			for(int i=1; i<=t; i++) {
 				down=down*i;
 			}
 			// 진짜 악질이네
 			System.out.println(((int) Math.round(up/down)));
 			
			
//			sb.append((int) up/down+"\n");
			
		}
//		System.out.println(sb);
	}
//	private static int combination(int n,int r){ 
//		 if(r==0 || r==n)
//		     return 1;
//		  else
//		      return combination(n-1, r-1) + combination(n-1, r);
//}
}
