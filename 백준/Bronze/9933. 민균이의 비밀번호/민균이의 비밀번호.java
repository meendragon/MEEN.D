import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // test횟수
        Map<String, Character> passwordList = new HashMap<>();//문자열과 가운데 문자를 넣을 맵
        String ans = " ";
        int ansLength = 0;
        for(int i = 0;i<testCase;i++){
            String userInput = br.readLine();// password 입력받음
            int midWord = userInput.length()/2; //정 중앙 단어 인덱스
            passwordList.put(userInput,userInput.charAt(midWord)); // 추후 속도 개선이 필요하면 char[] 로 String 받아서 하면 됨
            String reverse = new StringBuilder(userInput).reverse().toString();//입력받은 문자열 뒤집기
            if(passwordList.containsKey(reverse)){//리스트에 뒤집은 문자열이 존재한다면
                ans = reverse;
                ansLength = reverse.length();
            }
        }
        System.out.println(ansLength + " " + passwordList.get(ans));
    }
}