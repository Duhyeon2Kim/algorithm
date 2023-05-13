import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] W;
    static char[] B;
    static char[][] map;
    static int Answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Answer = Integer.MAX_VALUE;
        W = new char[]{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
        B = new char[]{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            map[i] = temp.toCharArray();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                Answer=Math.min(BoardCheck(j,i),Answer);
            }
        }

        System.out.println(Answer);
    }

    private static int BoardCheck(int X, int Y) {
        int count=0;
        int count2=0;
        for (int i = 0; i < 8; i++) {
            if(i%2==0) {
                for (int j = 0; j < 8; j++) {
                    if(W[j]!=map[i+Y][j+X]) count++;
                    if(B[j]!=map[i+Y][j+X]) count2++;
                }
            }
            else {
                for (int j = 0; j < 8; j++) {
                    if(B[j]!=map[i+Y][j+X]) count++;
                    if(W[j]!=map[i+Y][j+X]) count2++;
                }
            }
            if(count>=Answer && count2>=Answer) return Answer;
         }
        count = Math.min(count2, count);
        return count;
    }
}
