import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용해 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] adjList = new int[N][N];
        StringTokenizer st;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<N;j++){
                if(Integer.parseInt(st.nextToken())==1){
                    adjList[i][j] = 1;
                }
            }
        }
        floyd(adjList, N);
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }

    }
    private static void floyd(int[][] adjList, int N) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (adjList[i][k] == 1 && adjList[k][j] == 1) {
                        adjList[i][j] = 1;
                    }
                }
            }
        }
    }
}