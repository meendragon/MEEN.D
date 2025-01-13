import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0;i<N-M;i++){
            System.out.println(i + " " +(i+1));
        }
        for(int i = N-M+1;i<N;i++){
            System.out.println(N-M + " " + i);
        }
    }
}