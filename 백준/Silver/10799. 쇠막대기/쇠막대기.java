import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        int len = userInput.length();
        int ans = 0;
        Stack<Character> st = new Stack<>();
        st.push('0');
        for(int i = 0;i<len;i++){
            char current = userInput.charAt(i);
            if(current == '('){
                st.push(current);
            }else if(current ==')'){
                st.pop();
                if(userInput.charAt(i-1) == '('){
                    ans+=st.size()-1;
                }else{
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}