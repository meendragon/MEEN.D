import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long ans = factorial(N);
        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    private static long factorial(int N){
        if(N>1){
            return factorial(N-1)*N;
        }else{
            return 1;
        }
    }
}