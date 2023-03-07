import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int times=sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int[][] ranges = new int[times][2];
		
		for(int i=0; i<times; i++) {
			ranges[i][0] =sc.nextInt()-1;
			ranges[i][1] =sc.nextInt();
		} // 계산해야할 범위가 들어가있음
		
		for(int i=1; i<=N; i++) {
			arr[i]+=arr[i-1];
		} // 누적합 배열이 되어버림.
		
		for(int i=0; i<times; i++) {
			System.out.println(arr[ranges[i][1]]-arr[ranges[i][0]]);
		}
	}
}