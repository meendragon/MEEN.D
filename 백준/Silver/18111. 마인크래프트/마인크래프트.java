
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int [][] ground = new int[N][M];
        TreeMap<Integer,Integer> exheight = new TreeMap<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++){
                int temp = Integer.parseInt(st.nextToken());
                min = Math.min(min,temp);
                max = Math.max(max,temp);
                ground[i][j] = temp;
                if(exheight.containsKey(temp)){
                    int count = exheight.get(temp);
                    exheight.put(temp,count+1);
                }else{
                    exheight.put(temp,1);
                }
            }
        }
        List<Map.Entry<Integer,Integer>> height = new ArrayList<>(exheight.entrySet());
        //complete setting!!
        int ans = Integer.MAX_VALUE;
        int ansTop = 256;
        for(int top = min;top<=max;top++){
            int pocket = B;
            int sum = 0;
            for(Map.Entry<Integer, Integer> entry : height){
                int key = entry.getKey();
                int count = entry.getValue();
                if(key>top){
                    int diff = key-top;
                    pocket += diff*count;
                    sum += 2*diff*count;
                }else if(key<top){
                    int diff = top-key;
                    pocket-=diff*count;
                    sum+=diff*count;
                }
                if(pocket<0){
                    sum = Integer.MAX_VALUE;
                    break;
                }
            }
            if (sum <= ans) {
                ans = sum;
                ansTop = top;
            }
        }
        System.out.print(ans+" ");
        System.out.println(ansTop);

    }
}