import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T;
    static int[][] map;
    static int[][] copy;
    static ArrayList<int[]> conditioner;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        conditioner = new ArrayList<>();

        map = new int[R][C];
        for(int i=0; i<R; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j]==-1) conditioner.add(new int[]{j, i});
            }
        }

        for(int i=0; i<T; i++) {
            spread();
            operation();

        }
        int sum=0;
        for (int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]>0) sum+=map[i][j];
            }
        }
        System.out.println(sum);

    }


    private static void spread() {
        copy = new int[R][C];
        for(int i=0; i<R; i++) {
            copy[i] = map[i].clone();
        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]>0) {
                    int temp=0;
                    for(int t=0; t<4; t++) {
                        if(i+dy[t]<0 || i+dy[t]>=R || j+dx[t]<0 || j+dx[t]>=C) continue;
                        if(map[i+dy[t]][j+dx[t]]>=0) {
                            temp++;
                            copy[i + dy[t]][j + dx[t]] =  copy[i + dy[t]][j + dx[t]]+(map[i][j] / 5);
                        }
                    }
                    copy[i][j]=copy[i][j]-temp*((map[i][j] / 5));
                }
            }
        }
        for(int i=0; i<R; i++) {
            map[i] = copy[i].clone();
        }
    }

    private static void operation() {
        int[] topthing = conditioner.get(0);
        int top = topthing[1];
        int[] downthing = conditioner.get(1);
        int down = downthing[1];

        for (int i = top - 1; i > 0; i--)
            map[i][0] = map[i-1][0];
        for (int i = 0; i < C - 1; i++)
            map[0][i] = map[0][i+1];
        for (int i = 0; i < top; i++)
            map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--)
            map[top][i] = map[top][i-1];
        map[top][1] = 0;

        for (int i = down + 1; i < R - 1; i++)
            map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++)
            map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > down; i--)
            map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--)
            map[down][i] = map[down][i - 1];
        map[down][1] = 0;
    }
}
