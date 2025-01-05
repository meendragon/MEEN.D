import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<testCase;i++){
            String userInput = br.readLine();
            String[] commands = userInput.split(" ");
            boolean isEmpty = dq.isEmpty();
            switch (commands[0]){
                case "push":
                    dq.add(Integer.parseInt(commands[1]));
                    break;
                case "pop":
                    if(isEmpty){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(dq.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(isEmpty){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(isEmpty){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(isEmpty){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.getLast()).append("\n");
                    }
            }
        }
        System.out.println(sb.toString());

    }
}