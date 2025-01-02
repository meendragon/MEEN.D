import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String userInput = bf.readLine();
        String[] dsType = userInput.split(" ");
        userInput = bf.readLine();
        String[] dsData = userInput.split(" ");
        int M = Integer.parseInt(bf.readLine());
        userInput = bf.readLine();
        String[] pushNum = userInput.split(" ");
        //입력 끝
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = N-1;i>=0;i--){
            if(dsType[i].equals("0")) {
                q.add(Integer.parseInt(dsData[i]));
            }
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < M; i++) {
            q.add(Integer.parseInt(pushNum[i]));
            output.append(q.poll()).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}