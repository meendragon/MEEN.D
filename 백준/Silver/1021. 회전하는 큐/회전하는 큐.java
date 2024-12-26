import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        LinkedList LL = new LinkedList();
        for(int i = 1;i<=N;i++){
            LL.add(i);
        }
        int ans = 0;
        for(int i = 0;i<M;i++){
            int temp = scanner.nextInt();
            ans += LL.move(temp);
        }
        scanner.close();
        System.out.println(ans);
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
    Node head;
    Node tail;
    Node cursor;
    int size;
    LinkedList(){
        head = tail = cursor = null;
        size = 0;
    }
    void add(int data){
        Node newNode = new Node(data);
        this.size++;
        if(head==null) {
            head = tail = cursor = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            head.prev = tail = newNode;
            tail.next = head;
        }
    }
    void pop(Node element){
        cursor = element.prev.next = element.next;
        element.next.prev = element.prev;
        this.size--;
    }
    int move(int target){
        int count = 0;
        while(cursor.data!=target){
            cursor = cursor.next;
            count++;
        }
        count = Math.min(count,size - count);
        if(this.size!=1) {
            pop(cursor);
        }

        return count;
    }

}
