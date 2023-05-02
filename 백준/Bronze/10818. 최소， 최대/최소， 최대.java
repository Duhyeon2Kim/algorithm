import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();
            Max = Math.max(Max, target);
            Min = Math.min(Min, target);
        }

        System.out.println(Min+" "+Max);
    }
}