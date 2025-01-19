
import java.io.*;
import java.util.*;


public class Main {

    private static ArrayList<ArrayList<Node>> edgeList;
    private static int max_distance = 0;
    private static int fatrhtestNode = 0;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        for(int i = 0;i<testCase+1;i++){
            edgeList.add(new ArrayList<Node>());
        }//2차원 리스트 구현 인접리스트로 트리 구현

        for(int i = 0;i < testCase ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentNode = Integer.parseInt(st.nextToken());
            while(true) {
                int nodeNumber = Integer.parseInt(st.nextToken());
                if(nodeNumber == -1)break;
                int pathLen = Integer.parseInt(st.nextToken());
                Node newNode = new Node(nodeNumber, pathLen); // 가중치와 노드번호를 가진 Node 쌍을 만들어서 추가
                edgeList.get(currentNode).add(newNode);
            }

        }
        visited = new boolean[testCase+1];//방문여부 
        dfs(1,0);
        visited = new boolean[testCase+1];
        max_distance = 0;
        dfs(fatrhtestNode,0);//dfs 두번 하기
        bw.write(String.valueOf(max_distance));
        bw.flush();
        bw.close();
        br.close();

    }
    private static void dfs(int vertex, int distance){
        visited[vertex] = true;
        if(distance>max_distance){
            max_distance = distance;
            fatrhtestNode = vertex;
        }
        for(Node current : edgeList.get(vertex)){
            if(!visited[current.vertex]) {
                dfs(current.vertex, distance + current.weight);
            }
        }

    }
}
class Node{
    int vertex;
    int weight;
    Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}