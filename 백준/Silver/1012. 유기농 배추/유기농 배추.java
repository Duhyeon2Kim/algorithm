import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int height;
	static int width;
	
	public static void dfs(int y,int x) {
		if(arr[y][x]==0) {return;}
		arr[y][x]=0;
		
		for(int i=-1; i<=1; i++) {
				if(y+i>=0 && y+i<height &&  arr[y+i][x]==1) dfs(y+i,x);
		}
		for(int i=-1; i<=1; i++) {
			if(x+i>=0 && x+i<width &&arr[y][x+i]==1) dfs(y,x+i);
	}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc=1; tc<=testcase; tc++) {
		width = sc.nextInt();
		height = sc.nextInt();
		int baechu = sc.nextInt();
		
		arr = new int[height][width];
		
		for(int i=0; i<baechu; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			arr[Y][X]=1;
		}
		
		int count=0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(arr[i][j]==1) {dfs(i,j); count++; }
			}
		}
		
		System.out.println(count);
		}
	}
}