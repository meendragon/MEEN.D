import java.io.*;
import java.util.*;

public class Main {
    private static int N,K,count;
    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        count = 0;
        mergeSort(arr, 0,N-1);
        if(count<K){
            System.out.println(-1);
        }
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 배열을 두 부분으로 분할
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // 두 부분을 병합
            merge(arr, left, mid, right);
        }

    }
    private static void merge(int[] arr, int left, int mid, int right) {
        // 두 부분 배열의 길이 계산
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열 생성
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 데이터 복사
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // 두 임시 배열을 병합
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            count++;
            if(isK(count)){
                System.out.println(arr[k-1]);
                return;
            }
        }
        // 남은 원소 복사
        while (i < n1) {
            arr[k++] = L[i++];
            count++;
            if(isK(count)){
                System.out.println(arr[k-1]);
                return;
            }
        }
        while (j < n2) {
            arr[k++] = R[j++];
            count++;
            if(isK(count)){
                System.out.println(arr[k-1]);
                return;
            }
        }
    }
    private static boolean isK(int count){
        if(count==K){
            return true;
        }
        return false;
    }


}