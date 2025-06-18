import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] tooth = new int[4][8];
        StringTokenizer st;
        for(int i = 0;i<4;i++){
            String line = br.readLine();
            for(int j = 0;j<8;j++){
                tooth[i][j] = line.charAt(j) - '0';
            }
        }//세팅완료
        int k = Integer.parseInt(br.readLine());
        for(int i = 0;i<k;i++){
            boolean[] turned = new boolean[4];
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int up = Integer.parseInt(st.nextToken());
            rotate(tooth,turned, num, up);
        }
        int ans = 0;
        for(int i = 0;i<4;i++){
            if(tooth[i][0] == 1){
                ans+=Math.pow(2,i);
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
    public static void rotate(int[][] teeth,boolean[] turned, int num, int up){//굴러가라 굴렁쇠
        int temp;
        turned[num] = true;
        int left = teeth[num][6];
        int right = teeth[num][2];
        if(up == -1){
            temp = teeth[num][0];
            for(int i = 1;i<8;i++){
                teeth[num][i-1] = teeth[num][i];
            }
            teeth[num][7] = temp;
        }else{
            temp = teeth[num][7];
            for(int i = 6;i>=0;i--){
                teeth[num][i+1] = teeth[num][i];
            }
            teeth[num][0] = temp;
        }
        if((num + 1 < 4)&&!turned[num+1]){
            if(teeth[num+1][6] != right){//돌리기전으로 평가해야함 ....
                rotate(teeth, turned, num+1, up*(-1));
            }
        }
        if((num-1 >=0)&&!turned[num-1]){
            if(teeth[num-1][2] != left){
                rotate(teeth, turned, num-1, up*(-1));
            }
        }
    }
}