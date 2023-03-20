import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	static int N;
	static int M;
	static int tar;
	static int get;
	static int answer=1;
	
	public static void dfs(int tar, int get, int chonsu) {
		if(tar==get) {answer=chonsu; return;}
		check[tar]= true;
		
		for(int x: arr[tar]) {
			if(!check[x]) {
				dfs(x,get,chonsu+1);
			}
		}check[tar]=false;
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tar = sc.nextInt();
		get = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N+1];
		check = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i]= new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int adam=sc.nextInt();
			int eve = sc.nextInt();
		arr[adam].add(eve);
		arr[eve].add(adam);
		}
		
		
		dfs(tar,get,1);
		if(answer-1==0) answer=0;
		 System.out.println(answer-1);
		
	}
}