
import java.io.*;
import java.util.*;


public class Main {
    private static int dasom;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<N-1;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while(!pq.isEmpty()){
            int elected = pq.poll();
            if(elected < dasom) break;
            pq.add(--elected);
            dasom++;
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();


    }



}