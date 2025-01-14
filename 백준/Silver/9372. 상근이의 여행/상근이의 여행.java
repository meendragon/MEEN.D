import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for(int i = 0;i<testCase;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Vector<Vector<Integer>> worlds = new Vector<>();
            for(int j = 0;j<N;j++){
                worlds.add(new Vector<>());
            }
            for(int j = 0;j<M;j++){
                st = new StringTokenizer(br.readLine());
            }
            bw.write((N-1) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}