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
        tokens = userInput.split(" ");
        int pokedex = Integer.parseInt(tokens[0]); // 도감 속 포켓몬 수
        int testCase = Integer.parseInt(tokens[1]); // 테스트 케이스
        Map<String,String> pokemonName = new HashMap<>();
        Map<String, String> pokemonNumber = new HashMap<>();
        //공간복잡도 2배로 설정
        for(int i = 1;i<=pokedex;i++){
            userInput = br.readLine();
            pokemonName.put(userInput,Integer.toString(i));
            pokemonNumber.put(Integer.toString(i),userInput);//도감번호도 String으로 바꿔서 저장
        }
        for(int i = 0;i<testCase;i++){
            userInput = br.readLine();
            if(pokemonName.containsKey(userInput)){
                bw.write(pokemonName.get(userInput));
            }else{
                bw.write(pokemonNumber.get(userInput));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}