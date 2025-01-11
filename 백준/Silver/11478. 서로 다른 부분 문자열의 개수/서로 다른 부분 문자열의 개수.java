import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String userInput;
    private static String[] tokens;
    public static void main(String[] args) throws IOException {
        userInput = br.readLine();
        int len = userInput.length();
        Map<String, Boolean> subStr = new HashMap<>();
        for(int i = 0;i<len;i++){
            int beginIndex = i; // ababc 가 있으면 순차적으로 a, ab, aba, abab, ababc 처럼 beginIndex를 i로 두어서 0,1,2..subString을 구해서 Map에 넣는다
            int endIndex = i+1;
            while(endIndex<=len){
                String temp = userInput.substring(beginIndex,endIndex);//subString은 endIndex를 포함하지 않기때문에 범위 설정 잘해주어야
                endIndex++;
                subStr.put(temp,true);
            }
        }
        bw.write(Integer.toString(subStr.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}