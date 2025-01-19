
import java.io.*;
import java.util.*;


public class Main {
    private static int[] nodeArr;
    private static ArrayList<ArrayList<Integer>> levels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int buildingCount = (1<<K)-1; //2^K
        nodeArr = new int[buildingCount];
        for(int i = 0;i<buildingCount;i++){
            nodeArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }// 입력 숫자들을 배열에 저장
        levels = new ArrayList<>();
        for(int i = 0;i<buildingCount;i++){
            levels.add(new ArrayList<>());
        }//2차원 리스트 구현
        binaryTree(0, buildingCount - 1, 0);//트리 순회
        for(ArrayList<Integer> level : levels){
            for(int num : level){
                bw.write(num+ " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
    private static void binaryTree(int start, int end, int depth){
        if(start>end) return;
        int mid = (start+end)/2;
        levels.get(depth).add(nodeArr[mid]);// 깊이에 맞춰서 2차원 리스트에 추가
        
        binaryTree(start, mid-1, depth+1);
        binaryTree(mid+1,end, depth+1);
    }
}
class TreeNode{
    TreeNode right;
    TreeNode left;
    int data;
    TreeNode(int data){
        this.data = data;
        this.right = this.left  = null;
    }
}