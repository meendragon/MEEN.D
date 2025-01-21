
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            if(st.hasMoreTokens()){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ans = insertion(K,arr);
        if(ans[0] == -1) bw.write("-1");
        else{
            for(int i = 0;i<arr.length;i++){
                bw.write(ans[i] + " ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    private static int[] insertion(int K, int[] arr){
        int len = arr.length;
        int count = 0;
        for(int i = 1;i<len;i++){
            int loc = i-1;
            int currentNum = arr[i];
            boolean hasChanged = false;
            while(loc>=0 && currentNum < arr[loc]){
                arr[loc+1] = arr[loc];
                hasChanged = true;
                count++;
                if(count == K)return arr;
                loc--;
            }
            if(hasChanged){
                arr[loc+1] = currentNum;
                count++;
                if(count == K)return arr;
            }



        }
        arr[0] = -1;
        return arr;
    }
}