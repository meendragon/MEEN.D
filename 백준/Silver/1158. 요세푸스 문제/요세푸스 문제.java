import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();
        LinkedList LL = new LinkedList();
        for(int i = 1;i<=N;i++){
            LL.add(i);
        }
        System.out.print("<");
        for(int i = 0;i<N;i++){
            LL.moveCursor(K-1);
            int ans = LL.pop();
            System.out.print(ans);
            if(i!=N-1){
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class LinkedList{
    private Node head;
    private Node tail;
    private Node cursor;
    LinkedList(){
        head = null;
        tail = null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            cursor = head = tail = newNode;
        }else{
            head.prev = tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            tail = newNode;
        }
    }
    public int pop(){
        if(cursor.next == null){
            return cursor.data;
        }
        int data = cursor.data;
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        cursor = cursor.next;
        return data;
    }
    public void moveCursor(int count){
        for(int i = 0;i<count;i++){
            cursor = cursor.next;
        }
    }

}