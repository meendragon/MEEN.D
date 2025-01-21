
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            if(st.hasMoreTokens()){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            if(st.hasMoreTokens()){
                B[i] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = insertion(arr,B);
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
    private static int insertion(int[] arr, int[]B){
        int len = arr.length;
        boolean sameArr = false;
        for(int i = 1;i<len;i++){
            int loc = i-1;
            int currentNum = arr[i];
            boolean hasChanged = false;
            while(loc>=0 && currentNum < arr[loc]){
                arr[loc+1] = arr[loc];
                hasChanged = true;
                sameArr = compareArr(arr,B);
                if(sameArr) return 1;
                loc--;
            }
            if(hasChanged){
                arr[loc+1] = currentNum;
                sameArr = compareArr(arr,B);
                if(sameArr) return 1;
            }
        }
        return 0;
    }
    private static boolean compareArr(int[] A, int[] B){
        return Arrays.equals(A,B);
    }
}