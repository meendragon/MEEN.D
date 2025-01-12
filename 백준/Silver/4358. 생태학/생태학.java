import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static String userInput;
    private static String[] tokens;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String,Integer> unorderedTrees = new HashMap<>();
        int count = 0;
        while((userInput = br.readLine())!= null){  // ㄷEnd of File 발생 하면 입력종료
            unorderedTrees.merge(userInput, 1,Integer::sum);//userInput이 존재하면 1을 더하고 아니면 1을 추가
            count++;
        }
        Map<String,Integer> orderedTrees = new TreeMap<>(unorderedTrees); //TreeMap에 넣음으로 문자열 알파벳순으로 정렬
        for(Map.Entry<String, Integer> entry : orderedTrees.entrySet()){
            double proportion = ((double)entry.getValue()/count)*100;
            String formattedProportion = String.format("%.4f",proportion);//4자리수까지만 표현
            bw.write(entry.getKey() + " " + formattedProportion + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}