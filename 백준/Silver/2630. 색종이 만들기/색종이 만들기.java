import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int[][] board;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lineLen = Integer.parseInt(br.readLine());
        board = new int[lineLen][lineLen];
        for(int i = 0;i<lineLen;i++){
            String userInput = br.readLine();
            String[] userInputTokens = userInput.split(" ");
            for(int j = 0;j<lineLen;j++){
                board[i][j] = Integer.parseInt(userInputTokens[j]);
            }
        }//board에 입력끝
        divideAndConquer(0,0,lineLen);
        bw.write(white + "\n" + blue + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    public static void divideAndConquer(int x, int y, int size){
        int newSize = size/2;
        if(isUniform(x,y,size)){
            if(board[x][y] == 1){
                blue++;
            }else{
                white++;
            }
        }else{
            divideAndConquer(x,y,newSize); // 왼쪽 위
            divideAndConquer(x,y+newSize,newSize); // 오른쪽 위
            divideAndConquer(x+newSize,y,newSize); // 왼쪽 아래
            divideAndConquer(x+newSize,y+newSize,newSize); // 오른쪽 아래
        }
    }
    public static boolean isUniform(int x, int y, int size){
        int color = board[x][y];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(board[x+i][y+j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
}