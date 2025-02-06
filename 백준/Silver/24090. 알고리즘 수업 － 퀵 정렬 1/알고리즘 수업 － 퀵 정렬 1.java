import java.io.*;
import java.util.*;

public class Main {
    // 전역 변수 : swap 횟수, 목표 교환번호 K, 결과 저장 플래그 및 두 수
    static long swapCount = 0;
    static int K;
    static boolean found = false;
    static int swapA = -1, swapB = -1;

    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader, StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        quickSort(list, 0, list.size() - 1);

        // K번째 교환이 발생하지 않은 경우
        if (!found) {
            System.out.println("-1");
        } else {
            // 두 수를 작은 수부터 출력
            int a = swapA, b = swapB;
            if(a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            System.out.println(a + " " + b);
        }
    }

    // 퀵 정렬 (배열 list의 p부터 r까지 정렬)
    public static void quickSort(ArrayList<Integer> list, int p, int r) {
        if (found) return; // 이미 K번째 swap을 찾은 경우 재귀 중단
        if (p < r) {
            int q = partition(list, p, r);
            if(found) return; // partition 도중 K번째 swap을 찾은 경우
            quickSort(list, p, q - 1);
            quickSort(list, q + 1, r);
        }
    }

    // partition 함수 (마지막 원소를 피벗으로 사용)
    public static int partition(ArrayList<Integer> list, int p, int r) {
        int x = list.get(r);   // 기준원소 (피벗)
        int i = p - 1;         // x보다 작거나 같은 원소들의 끝 위치
        for (int j = p; j < r; j++) {
            if (list.get(j) <= x) {
                i++;
                swap(list, i, j);  // swap하면서 swapCount 증가
                if(found) return 0; // K번째 swap을 찾은 경우 바로 중단
            }
        }
        if (i + 1 != r) { // 피벗을 올바른 위치로 이동 (자기 자신과의 swap도 포함)
            swap(list, i + 1, r);
            if(found) return 0;
        }
        return i + 1;
    }

    // swap 함수: list의 i와 j 위치의 값을 교환하며 swapCount 증가
    public static void swap(ArrayList<Integer> list, int i, int j) {
        int a = list.get(i);
        int b = list.get(j);
        swapCount++;
        // K번째 swap이라면 두 수를 기록
        if (!found && swapCount == K) {
            swapA = a;
            swapB = b;
            found = true;
        }
        // 실제 swap 수행
        list.set(i, b);
        list.set(j, a);
    }
}