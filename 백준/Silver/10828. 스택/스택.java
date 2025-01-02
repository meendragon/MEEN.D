import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N  = Integer.parseInt(bf.readLine());
        for(int i = 0;i<N;i++){
            String userInput = bf.readLine();
            String[] tokens = userInput.split(" ");
            boolean checkEmpty = stack.isEmpty();
            switch (tokens[0]){
                case "push":
                    stack.push(Integer.parseInt(tokens[1]));
                    break;
                case "pop":
                    if(checkEmpty){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(checkEmpty){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if(checkEmpty){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.peek());
                    }
                    break;
            }

        }

    }
}