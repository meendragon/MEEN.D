
import java.io.*;
import java.util.*;


public class Main {
    private static ArrayList<ArrayList<Node>> treeList;
    private static boolean[] visited;
    private static int max_distance,farthestNode = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nodeCount = Integer.parseInt(br.readLine());
        treeList = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            treeList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodeCount - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int par = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            treeList.get(par).add(new Node(child, weight));
            treeList.get(child).add(new Node(par, weight));
        }
        visited = new boolean[nodeCount+1];
        dfs(1, 0);
        visited = new boolean[nodeCount+1];
        max_distance = 0;
        dfs(farthestNode, 0);
        bw.write(String.valueOf(max_distance));
        bw.flush();
        br.close();
        bw.close();


    }
    private static void dfs(int vertex, int distance){
        visited[vertex] = true;
        if(max_distance<distance){
            farthestNode = vertex;
            max_distance = distance;
        }
        for(Node node : treeList.get(vertex)){
            if(!visited[node.vertex]){
                dfs(node.vertex,distance+node.weight);
            }
        }
    }

}
class Node{
    int vertex,weight;
    Node(int vertex, int weight){
        this.weight = weight;
        this.vertex = vertex;
    }
}