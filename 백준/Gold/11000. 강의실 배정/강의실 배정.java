
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> classSchedule = new PriorityQueue<>();
        PriorityQueue<Integer> classroom = new PriorityQueue<>();
        //그리디알고리즘 종료시간을 기준으로 우선순위 큐 사용
        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start,end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            Pair input = new Pair(start, end);
            classSchedule.add(input);
        }
        for(int i = 0;i<N;i++){
            int start,end;
            if(!classSchedule.isEmpty()) {
                Pair top = classSchedule.poll();
                start = top.start;
                end = top.end;
                if (classroom.isEmpty()) {
                    classroom.add(end);
                } else {
                    if (classroom.peek() <= start) classroom.poll();
                    classroom.add(end);
                }
            }
        }

        bw.write(String.valueOf(classroom.size()));
        bw.flush();
        br.close();
        bw.close();


    }
}
class Pair implements Comparable<Pair>{
    int start,end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Pair o){
        if(this.start!=o.start) {
            return Integer.compare(this.start, o.start);
        }
        return Integer.compare(this.end, o.end);
    }
}