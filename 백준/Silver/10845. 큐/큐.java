import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
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
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.poll());
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(isEmpty){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(isEmpty){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.peek());
                    }
                    break;
                case "back":
                    if(isEmpty){
                        System.out.println(-1);
                    }else{
                        System.out.println(dq.getLast());

                    }
            }
        }

    }
}