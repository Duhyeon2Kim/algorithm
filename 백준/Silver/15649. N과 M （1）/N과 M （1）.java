import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[] check;
	static int[] arr;

	private static void dfs(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (check[i] == false) {
				check[i] = true;
				arr[idx] = i;
				dfs(idx + 1);
				check[i] = false;
			}
		}



	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		check = new boolean[N + 1];
		arr = new int[M+1];

		dfs(0);
	}
}