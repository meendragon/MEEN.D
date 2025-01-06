import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int bufferSize = Integer.parseInt(br.readLine());
        Queue<Integer> routerBuffer = new ArrayDeque<>();
        int num;
        while ((num = Integer.parseInt(br.readLine())) != (-1)) {
            if (num == 0) {
                routerBuffer.poll();
            }else if (routerBuffer.size() < bufferSize) {
                routerBuffer.add(num);
            }
        }
        while(!routerBuffer.isEmpty()){
            bw.write(routerBuffer.poll()+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}