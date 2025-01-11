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
        for(int i = 0;i<N;i++){
            int temp = Integer.parseInt(tokens[i]);
            cards.put(temp, 1);
        }
        int M = Integer.parseInt(br.readLine());
        userInput = br.readLine();
        tokens = userInput.split(" ");
        for(int i = 0;i<M;i++){
            int temp = Integer.parseInt(tokens[i]);
            if(cards.containsKey(temp)){
                bw.write(cards.get(temp) + " ");
            }else{
                bw.write(0+" ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}