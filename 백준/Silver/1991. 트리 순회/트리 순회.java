
import java.io.*;
import java.util.*;


public class Main {
    private static int[][] tree;

    private static int testCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testCase = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(tree[i], -1);
        }
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            for (int j = 0; j < 2; j++) {
                String child = st.nextToken();
                if (!child.equals(".")) {
                    tree[parent][j] = child.charAt(0) - 'A';
                }
            }
        }//인접리스트 생성 완료
        preorderTraversal(0, bw);
        bw.newLine();
        inorderTraversal(0, bw);
        bw.newLine();
        postorderTraversal(0, bw);
        bw.newLine();


        bw.flush();
        bw.close();
        br.close();

    }

    private static void preorderTraversal(int root, BufferedWriter bw) throws IOException {
        int left = tree[root][0];
        int right = tree[root][1];
        bw.write(root + 65);
        if (left != -1) {
            preorderTraversal(left, bw);
        }
        if (right != -1) {
            preorderTraversal(right, bw);
        }
    }

    private static void postorderTraversal(int root, BufferedWriter bw) throws IOException {
        int left = tree[root][0];
        int right = tree[root][1];
        if (left != -1) {
            postorderTraversal(left, bw);
        }
        if (right != -1) {
            postorderTraversal(right, bw);
        }
        bw.write(root + 65);

    }

    private static void inorderTraversal(int root, BufferedWriter bw) throws IOException {
        int left = tree[root][0];
        int right = tree[root][1];
        if (left != -1) {
            inorderTraversal(left, bw);
        }
        bw.write(root + 65);
        if (right != -1) {
            inorderTraversal(right, bw);
        }

    }

}