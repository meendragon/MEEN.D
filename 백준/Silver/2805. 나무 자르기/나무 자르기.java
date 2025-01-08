import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static long maxx = Integer.MIN_VALUE;
    static int N,M;
    static int[] treeHeight;
    static long minn = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String nmInput = br.readLine();
        String[] tokens = nmInput.split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);
        String treeInput = br.readLine();
        String[] trees = treeInput.split(" ");
        //입력완료
        treeHeight = new int[N];
        for(int i = 0;i<N;i++){
            int currentTree = Integer.parseInt(trees[i]);
            treeHeight[i] = currentTree;
            maxx = Math.max(maxx, currentTree);
        }// 최대 최소 값 설정
        long chainsawHeight = (minn+maxx)/2;
        long woodCount,exHeight;
        do{
            woodCount = cutTree(chainsawHeight);
            exHeight = chainsawHeight;
            if(woodCount > M){
                minn = chainsawHeight;
                chainsawHeight = (maxx+minn)/2;
            }else if(woodCount < M){
                maxx = chainsawHeight;
                chainsawHeight = (maxx+minn)/2;
            }
        }while(woodCount != M & exHeight!=chainsawHeight);
        if(cutTree(chainsawHeight)<M){
            chainsawHeight++;
        }
        String ans = Long.toString(chainsawHeight);
        bw.write(ans);
        bw.flush();
        br.close();
    }
    public static long cutTree(long height){
        long woodSum = 0;
        for(int i = 0;i<N;i++){
            if(treeHeight[i]>height){
               woodSum+=(treeHeight[i]-height);
            }
        }
        return woodSum;
    }
}