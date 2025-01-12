import java.io.*;
import java.util.*;

public class Main {
    private static long P,Q;
    private static Map<Long,Long> termMap= new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        termMap.put(0L,1L);

        bw.write(Long.toString(findAn(N)));
        sc.close();
        bw.flush();
        bw.close();
    }
    private static long findAn(long targetN){
        if(!termMap.containsKey(targetN)){
            long temp = findAn(targetN/P)+findAn(targetN/Q);
            termMap.put(targetN,temp);
            return temp;
        }else{
            return termMap.get(targetN);
        }

    }
}