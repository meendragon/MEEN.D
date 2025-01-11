import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> cards = new HashMap<>();
        String userInput = br.readLine();
        String[] tokens = userInput.split(" ");
        //N과 상근이가 가진 카드 입력
        for(int i = 0;i<N;i++){
            int temp = Integer.parseInt(tokens[i]);
            int value = cards.getOrDefault(temp,0); // map에 해당key가 있으면 Value를 아니면 0을 줌
            value++; // 1개 추가해서
            cards.put(temp,value); // map에 다시 넣어주기
        }
        int M = Integer.parseInt(br.readLine());
        userInput = br.readLine();
        tokens = userInput.split(" ");
        for(int i = 0;i<M;i++){
            int temp = Integer.parseInt(tokens[i]);
            bw.write(cards.getOrDefault(temp,0) + " ");
        }//해당 카드 출력 없으면 0이 출력됨
        bw.flush();
        br.close();
        bw.close();
    }
}