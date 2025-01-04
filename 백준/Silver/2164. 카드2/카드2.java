import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        Queue<Integer> q =  new ArrayDeque<>();
        for(int i = 0;i<N;i++){
            q.add(i+1);
        }
        for(int i = 0;i<N-1;i++){
            q.poll();
            Integer top = q.poll();
            q.add(top);
        }
        System.out.println(q.peek());
    }
}