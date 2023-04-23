import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,D;
    static int[][] map;
    static int[][] originMap;
    static int[] archer;
    static int answer=0;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1}; // 좌 상 우 하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        originMap= new int[N][M];

        for(int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                originMap[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        archer = new int[5];
        comnbination(0,0);
        System.out.println(answer);

    }

    private static void comnbination(int target, int depth) {
        if(depth==3) {
            for(int i=0; i<N; i++) {
                map[i]=originMap[i].clone();
            }
            answer=Math.max(answer,war());
            return;}

        if(target==M) return;

        archer[depth]=target;
        comnbination(target+1,depth+1);
        comnbination(target+1,depth);



    }

    private static int war() {
        int kill = 0;
        for (int t = 0; t < N; t++) {
            Queue<int[]> check = new LinkedList<>();

            for (int i = 0; i < 3; i++) {
                // 좀비 선택
                boolean[][] visit = new boolean[N][M];
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{archer[i], N});

                outer:
                while (!q.isEmpty()) {
                    int[] now = q.poll();
                    int nowX = now[0];
                    int nowY = now[1];

                    for (int j = 0; j < 4; j++) {
                        int nextX = nowX + dx[j];
                        int nextY = nowY + dy[j];
                        if( Math.abs(nextY-N)+Math.abs(nextX-archer[i])>D) continue;
                        if (nextX >= M || nextX < 0 || nextY >= N || nextY < 0 || visit[nextY][nextX]) continue;
                        if (map[nextY][nextX] == 1) {
                            check.add(new int[]{nextX, nextY});

                            break outer;
                        } else {
                            q.add(new int[]{nextX, nextY});
                            visit[nextY][nextX] = true;
                        }
                    }

                }
            }
            // 좀비 삭제
            while (!check.isEmpty()) {
                int[] target = check.poll();
                if (map[target[1]][target[0]] == 1) {
                    kill++;
                    map[target[1]][target[0]] = 0;
                }
            }

            // 한칸 이동
            for (int i = N - 2; i >= 0; i--) {
                int[] copy = map[i].clone();
                map[i + 1] = copy;
            }
            Arrays.fill(map[0],0);
//            for (int i = 0; i <N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println(kill);

        }
        return kill;
    }
}
