import java.io.*;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        selectionSort(arr,K);
    }
    private static void selectionSort(int[] arr, int stop){
        int count = 0;
        for(int i = arr.length-1;i>=1;i--){
            int max = arr[i];
            int index = -1;
            boolean changed = false;
            for(int j = (i-1);j>=0;j--){
                if(arr[j] > max){
                    max = arr[j];
                    index = j;
                    changed = true;
                }
            }
            if(changed){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                count++;
                if(count == stop){
                    System.out.println(temp + " " + arr[i]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

}
