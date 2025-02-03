import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int[] arr = new int[arrSize];
        int stopPoint = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<arrSize;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int testCount = 0;
        for(int i = 0;i<arrSize-1;i++){
            for(int j = 0;j<arrSize-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    testCount++;
                    if(testCount == stopPoint){
                        System.out.println(arr[j] + " " + arr[j+1]);
                    }
                }
            }
        }
        if(testCount<stopPoint){
            System.out.println(-1);
        }
    }

}
