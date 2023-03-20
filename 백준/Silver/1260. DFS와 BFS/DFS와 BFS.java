import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] check;
	static int total;
	static int link;
	static int start;
	
	
	public static void dfs(int i) {
		check[i]=true;
		System.out.print(i+" ");
		
		for(int j=1; j<=total; j++) {
			if(arr[i][j]==1 && check[j]==false) {
				dfs(j);}
		}
		
	}
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		check[i]=true;
		System.out.print(i+" ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int j=1; j<=total; j++) {
				if(arr[temp][j]==1 && check[j]==false) {
					System.out.print(j+" ");
					q.offer(j);
					check[j]=true;}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();
		link = sc.nextInt();
		start = sc.nextInt();
		arr = new int[total+1][total+1];
		check = new boolean[total+1];
		
		for(int i=0; i<link; i++) {
			int adam = sc.nextInt();
			int eve = sc.nextInt();
			arr[adam][eve]=1;
			arr[eve][adam]=1;
		}
		
		dfs(start);
		check = new boolean[total+1];
		System.out.println();
		bfs(start);
	}
}
