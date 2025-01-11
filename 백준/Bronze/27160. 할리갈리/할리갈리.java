import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean hitBell = playHalliGalli(N);//할리갈리 함수에 넣어서 종을 친다 true 안친다 false
        String ans = (hitBell) ? "YES" : "NO";
        System.out.println(ans);
    }
    private static boolean playHalliGalli(int roundCount) throws IOException{
        Map<String, Integer> cards = new HashMap<>();
        boolean ans = false;
        for(int i = 0;i<roundCount;i++){
            String userInput = br.readLine();
            String[] tokens = userInput.split(" ");
            String fruits = tokens[0]; //과일종류
            int count = Integer.parseInt(tokens[1]); // 과일개수
            if(!cards.containsKey(fruits)){
                cards.put(fruits, count);
            }else{
                int currentCount = cards.get(fruits); // 해당 과일의 원래 개수
                currentCount+=count; // 지금 과일 개수 더함
                cards.put(fruits, currentCount); // 다시 맵에 넣음
            }
        }
        for(Map.Entry<String, Integer> entry : cards.entrySet()){
            int count = entry.getValue();
            if(count == 5){
                ans = true;
            }
        }
        return ans;
    }
}