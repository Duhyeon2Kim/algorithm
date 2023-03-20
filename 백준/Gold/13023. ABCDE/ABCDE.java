import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	static boolean flag;
	
	public static void dfs(int i, int depth) {
		if(depth==5 || flag) {
			flag=true; return;}
		
			check[i]=true;
		
		for(int j: arr[i]) {
			if(!check[j]) {
				dfs(j,depth+1);
			}
		} check[i]=false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N];
		check = new boolean[N];
		flag=false;
		
		for(int i=0; i<N; i++) {
			arr[i]= new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			int adam = sc.nextInt();
			int eve = sc.nextInt();
			arr[adam].add(eve);
			arr[eve].add(adam);
		}
		for(int i=0; i<N; i++) {
			dfs(i,1);
			if(flag) break;
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
		 
	}
}