import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            Map<Long, Long> countMap = new HashMap<>();

            int validCount = 0;

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                long num = Long.parseLong(st.nextToken());

                if (command == 'I') {
                    // 삽입
                    minHeap.add(num);
                    maxHeap.add(num);
                    countMap.put(num, countMap.getOrDefault(num, 0L) + 1L);
                    validCount++;
                } else {
                    // 삭제
                    if (validCount == 0) continue; // 비어있다면 무시

                    if (num == 1) {
                        // 최댓값 삭제
                        Long removed = removeValid(maxHeap, countMap);
                        if (removed != null) validCount--;
                    } else {
                        // 최솟값 삭제
                        Long removed = removeValid(minHeap, countMap);
                        if (removed != null) validCount--;
                    }
                }
            }
            if (validCount == 0) {
                // 큐가 비어있다면
                sb.append("EMPTY\n");
            } else {
                // 유효한 최댓값, 최솟값 확인 (삭제는 아직 하지 않음)
                Long maxVal = getTopValid(maxHeap, countMap);
                Long minVal = getTopValid(minHeap, countMap);

                if (maxVal == null || minVal == null) {
                    // 둘 중 하나라도 유효하지 않으면 EMPTY
                    sb.append("EMPTY\n");
                } else if (maxVal.equals(minVal)) {
                    // 같으면 같은 값 두 번 출력
                    sb.append(maxVal).append(" ").append(maxVal).append("\n");
                } else {
                    // 다르면 각각 한번씩 제거(출력)
                    maxVal = removeValid(maxHeap, countMap);
                    minVal = removeValid(minHeap, countMap);
                    sb.append(maxVal).append(" ").append(minVal).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    private static Long removeValid(PriorityQueue<Long> pq, Map<Long, Long> countMap) {
        while (!pq.isEmpty()) {
            long top = pq.poll();
            Long cnt = countMap.get(top);
            if (cnt != null && cnt > 0) {
                // 유효한 값이면 count 감소 후 반환
                countMap.put(top, cnt - 1);
                if (countMap.get(top) == 0) {
                    countMap.remove(top);
                }
                return top;
            }
            // 유효하지 않은 값이면 계속 반복
        }
        return null; // 유효한 값이 없다면 null
    }
    private static Long getTopValid(PriorityQueue<Long> pq, Map<Long, Long> countMap) {
        while (!pq.isEmpty()) {
            long top = pq.peek();
            Long cnt = countMap.get(top);
            // 유효하면 반환
            if (cnt != null && cnt > 0) {
                return top;
            }
            // 유효하지 않다면 poll()로 버리고 계속
            pq.poll();
        }
        return null; // 유효한 값이 없으면 null
    }

}
