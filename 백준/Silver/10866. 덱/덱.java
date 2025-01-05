import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int X;
            boolean isEmpty = dq.isEmpty();
            switch (commands[0]){
                case "push_front":
                    X = Integer.parseInt(commands[1]);
                    dq.addFirst(X);
                    break;
                case "push_back":
                    X = Integer.parseInt(commands[1]);
                    dq.addLast(X);
                    break;
                case "pop_front":
                    if(isEmpty){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if(isEmpty){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(dq.pollLast()).append("\n");
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
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(isEmpty){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}