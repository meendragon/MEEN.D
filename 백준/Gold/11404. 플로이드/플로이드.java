import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용해 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] adjList = new int[N][N];

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                adjList[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0;i<N;i++){
            adjList[i][i] = 0;
        }
        StringTokenizer st;
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
           if(c<adjList[a][b]){
               adjList[a][b] = c;
           }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(adjList[i][k]!=Integer.MAX_VALUE&&adjList[k][j]!=Integer.MAX_VALUE){
                        if((adjList[i][k] + adjList[k][j])<adjList[i][j]){
                            adjList[i][j] = adjList[i][k] + adjList[k][j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(adjList[i][j] == Integer.MAX_VALUE ? "0" : adjList[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
