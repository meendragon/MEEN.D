import java.io.*;
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int operationCount = Integer.parseInt(br.readLine()); // 입력받기

        for (int i = 0; i < operationCount; i++) {
            String[] input = br.readLine().split(" "); // 한 줄 입력 분리
            String command = input[0];

            switch (command) {
                case "all":
                    allElement();
                    break;

                case "empty":
                    clearElement();
                    break;

                case "add":
                    int addValue = Integer.parseInt(input[1]);
                    map.put(addValue, addValue);
                    break;

                case "remove":
                    int removeValue = Integer.parseInt(input[1]);
                    map.remove(removeValue);
                    break;

                case "check":
                    int checkValue = Integer.parseInt(input[1]);
                    boolean checkResult = checkElement(checkValue);
                    bw.write((checkResult ? "1" : "0") + "\n");
                    break;

                case "toggle":
                    int toggleValue = Integer.parseInt(input[1]);
                    boolean hasElement = checkElement(toggleValue);
                    if (hasElement) {
                        map.remove(toggleValue);
                    } else {
                        map.put(toggleValue, toggleValue);
                    }
                    break;
            }
        }

        bw.flush(); // 출력 버퍼 비우기
        br.close();
        bw.close();
    }

    public static boolean checkElement(int data) {
        return map.containsKey(data);
    }

    public static void clearElement() {
        map.clear();
    }

    public static void allElement() {
        clearElement();
        for (int i = 1; i <= 20; i++) {
            map.put(i, i);
        }
    }
}
