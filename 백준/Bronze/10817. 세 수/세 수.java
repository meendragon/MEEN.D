import java.io.*;
import java.util.*;

public class Main {

    private static boolean swapped;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i = 0;i<3;i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }
        arr = bubblesort(arr);
        System.out.println(arr[1]);

    }
    private static int[] bubblesort(int[] arr){
        for(int i = 0;i<3;i++){
            swapped = false;
            for(int j = 0;j<2;j++){
                if(arr[j] > arr[j+1]){
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swapped)break;
        }
        return arr;
    }


}
