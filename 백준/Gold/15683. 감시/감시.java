import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] mapCopy;
    static ArrayList<int[]> cctv;
    static int cctvCnt;
    static int[] cctvDirections;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctv = new ArrayList<>();
        cctvCnt = 0;
        answer = Integer.MAX_VALUE;

        // cctv엔 cctv 종류, x, y가 순서대로 담긴다.
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j]>=1 && map[i][j]<6) {cctvCnt++;  cctv.add(new int[]{map[i][j], j, i});}

            }
        }

        cctv.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0],o1[0]);
            }
        });

        cctvDirections = new int[cctvCnt];
        combination(0);

        System.out.println(answer);

    }

    private static void combination(int depth) {

        if(answer==0) return;

        if(depth==cctvCnt) {
//            for (int i = 0; i < cctvDirections.length; i++) {
//                System.out.print(cctvDirections[i]+" ");
//            }
//            System.out.println();
            answer=Math.min(check(),answer);
            return;
        }

        for(int i=1; i<=4; i++) {
            cctvDirections[depth]=i;
            combination(depth+1);
        }



    }

    private static int check() {
        mapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            mapCopy[i] = map[i].clone();
        }

        for (int i = 0; i < cctvCnt; i++) {
            int[] select = cctv.get(i);
            int X = select[1];
            int Y = select[2];
            if(select[0]==5) {
                northCheck(X, Y);
                eastCheck(X, Y);
                southCheck(X, Y);
                westCheck(X, Y);
            }
            if(select[0]==4) {
              if(cctvDirections[i]==1) {
                  eastCheck(X, Y);
                  southCheck(X, Y);
                  westCheck(X, Y);
              }
                if(cctvDirections[i]==2) {
                    northCheck(X, Y);
                    southCheck(X, Y);
                    westCheck(X, Y);
                }
                if(cctvDirections[i]==3) {
                    northCheck(X, Y);
                    eastCheck(X, Y);
                    westCheck(X, Y);
                }
                if(cctvDirections[i]==4) {
                    northCheck(X, Y);
                    eastCheck(X, Y);
                    southCheck(X, Y);
                }

            }
            if(select[0]==3) {
                if(cctvDirections[i]==1) {
                    northCheck(X, Y);
                    eastCheck(X, Y);
                }
                if(cctvDirections[i]==2) {
                    eastCheck(X, Y);
                    southCheck(X, Y);
                }
                if(cctvDirections[i]==3) {
                    westCheck(X, Y);
                    southCheck(X, Y);
                }
                if(cctvDirections[i]==4) {
                    northCheck(X, Y);
                    westCheck(X, Y);
                }
            }
            if(select[0]==2) {
                if(cctvDirections[i]==1 || cctvDirections[i]==3 ) {
                    northCheck(X, Y);
                    southCheck(X, Y);
                }
                if(cctvDirections[i]==2 || cctvDirections[i]==4 ) {
                    eastCheck(X, Y);
                    westCheck(X, Y);
                }
            }

            if(select[0]==1) {
                if(cctvDirections[i]==1) {
                    northCheck(X, Y);
                }
                if(cctvDirections[i]==2) {
                    eastCheck(X, Y);
                }
                if(cctvDirections[i]==3) {
                    southCheck(X, Y);
                }
                if(cctvDirections[i]==4) {
                    westCheck(X, Y);
                }
            }
        }
        return safezone();
    }

    private static int safezone() {
        int safezone=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(mapCopy[i][j]==0) safezone++;
            }
        }
        return safezone;

    }

    private static void northCheck(int X, int Y) {
        for(int i = Y; i>=0; i--) {
            if(mapCopy[i][X]==6) break;
            mapCopy[i][X]=9;
        }
    }

    private static void southCheck(int X, int Y) {
        for(int i = Y; i<N; i++) {
            if(mapCopy[i][X]==6) break;
            mapCopy[i][X]=9;
        }
    }

    private static void westCheck(int X, int Y) {
        for(int i = X; i>=0; i--) {
            if(mapCopy[Y][i]==6) break;
            mapCopy[Y][i]=9;

        }
    }

    private static void eastCheck(int X, int Y) {
        for(int i = X; i<M; i++) {
            if(mapCopy[Y][i]==6) break;
            mapCopy[Y][i]=9;
        }
    }

}
