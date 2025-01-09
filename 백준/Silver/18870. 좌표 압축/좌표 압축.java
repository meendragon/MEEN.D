import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> lineNum = new HashMap<>();
        String userInput = br.readLine();
        String[] tokens = userInput.split(" ");
        int[] temp = new int[N];
        int[] values = new int[N];
        for(int i = 0;i<N;i++){
            values[i] = Integer.parseInt(tokens[i]);
            temp[i] = Integer.parseInt(tokens[i]);
        }
        Arrays.sort(temp);
        int newNum = 0;
        for(int i = 0;i<N;i++){
            if(!lineNum.containsKey(temp[i])){
                lineNum.put(temp[i],newNum);
                newNum++;
            }

        }
        for(int num : values){
            bw.write(lineNum.get(num)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}