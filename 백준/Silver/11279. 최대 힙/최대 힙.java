import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙(Max Heap)

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(temp);
            }
        }
        System.out.print(sb.toString());
    }
}
