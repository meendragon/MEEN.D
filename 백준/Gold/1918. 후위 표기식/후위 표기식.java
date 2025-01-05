import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String userInput = br.readLine();
        Stack<Character> symbolStack = new Stack<>();
        for(int i = 0;i<userInput.length();i++){
            char current = userInput.charAt(i);
            switch(current) {
                case '+':
                case '-':
                    while(!symbolStack.empty() && priority(symbolStack.peek())>=1){
                        sb.append(symbolStack.pop());
                    }
                    symbolStack.push(current);
                    break;
                case '*':
                case '/':
                    while(!symbolStack.empty() && priority(symbolStack.peek())>=2){
                        sb.append(symbolStack.pop());
                    }
                    symbolStack.push(current);
                    break;
                case '(':
                    symbolStack.push(current);
                    break;
                case ')':
                    while(!symbolStack.empty()&&symbolStack.peek()!='('){
                        sb.append(symbolStack.pop());
                    }
                    symbolStack.pop();
                    break;
                default:
                    sb.append(current);
            }

        }
        while(!symbolStack.empty() && symbolStack.peek()!='('){
            sb.append(symbolStack.pop());
        }
        System.out.println(sb);
    }
    public static int priority(char operator){
        int ans = 0;
        switch (operator){
            case '*':
            case '/':
                ans = 2;
                break;
            case '+':
            case '-':
                ans = 1;
                break;
        }
        return ans;
    }
}