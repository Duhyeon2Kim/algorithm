import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] crimeNum;
    static int answer =Integer.MIN_VALUE;
    static int mafiaNum;
    static boolean[] deathCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crimeNum = new int[N];
        deathCheck = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crimeNum[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        mafiaNum = Integer.parseInt(br.readLine());

        mafiaGame(N,0);
        System.out.println(answer);


    }//main

    private static void mafiaGame(int restPeople, int days) {
        if(deathCheck[mafiaNum] || restPeople==1) {
            answer = Integer.max(days, answer);
            return;
        }
        if(restPeople%2==1) {
            int targetNum = Integer.MIN_VALUE;
            int temp = 0;
            for (int i = 0; i < N; i++) {
                if(deathCheck[i]) continue;
                if(crimeNum[i]>temp) {targetNum=i; temp=crimeNum[i];}
            }
            deathCheck[targetNum]=true;
            mafiaGame(restPeople-1,days);
            deathCheck[targetNum]=false;
        }

        else {
            for (int i = 0; i <N; i++) {
                if(i==mafiaNum) continue;
                if(deathCheck[i]) continue;

                
                for (int j = 0; j < N; j++) {
                    if(deathCheck[j]) continue;
                    crimeNum[j]+=arr[i][j];}
                
                deathCheck[i]=true;
                mafiaGame(restPeople-1,days+1);
                deathCheck[i]=false;
                
                for (int j = 0; j < N; j++) {
                    if(deathCheck[j]) continue;
                    crimeNum[j]-=arr[i][j];}
            }
        }
    }
}
