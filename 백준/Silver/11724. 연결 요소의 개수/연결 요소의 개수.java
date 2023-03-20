import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] check;
	static int N;// 정점의 갯수
	static int M; // 간선의 갯수
	
	public static void dfs(int i) {
		check[i]=true;
		
		for(int j=1; j<=N; j++) {
			if(arr[i][j]==1 && !check[j]) {dfs(j);}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		 arr = new int[N+1][N+1];
		 check = new boolean[N+1];
		 
		for(int i=0; i<M; i++) {
			int adam = sc.nextInt();
			int eve = sc.nextInt();
			arr[adam][eve] = 1;
			arr[eve][adam] = 1;
		}
		
		int count =0;
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				count++;
				dfs(i);
			}
		}
		
		System.out.println(count);
		
	}
}