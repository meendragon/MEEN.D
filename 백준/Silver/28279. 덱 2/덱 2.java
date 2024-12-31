import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int nCount = Integer.parseInt(br.readLine());
        for(int i = 0;i<nCount;i++){
            String userInput = br.readLine();
            String[] tokens = userInput.split(" ");
            int command = Integer.parseInt(tokens[0]);
            switch(command){
                case 1:
                    dq.addFirst(Integer.parseInt(tokens[1]));
                    break;
                case 2:
                    dq.addLast(Integer.parseInt(tokens[1]));
                    break;
                case 3:
                    Integer polledFirst = dq.pollFirst();
                    if(polledFirst == null){
                        System.out.println(-1);
                    }else{
                        System.out.println(polledFirst);
                    }
                    break;
                case 4:
                    Integer polledLast = dq.pollLast();
                    if(polledLast == null){
                        System.out.println(-1);
                    }else{
                        System.out.println(polledLast);
                    }
                    break;
                case 5:
                    System.out.println(dq.size());
                    break;
                case 6:
                    if(dq.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case 7:
                    Integer peekedFirst = dq.peekFirst();
                    if(peekedFirst==null){
                        System.out.println(-1);
                    }else{
                        System.out.println(peekedFirst);
                    }
                    break;
                case 8:
                    Integer peekedLast = dq.peekLast();
                    if(peekedLast ==null){
                        System.out.println(-1);
                    }else{
                        System.out.println(peekedLast);
                    }
                    break;
            }
        }
    }
}
