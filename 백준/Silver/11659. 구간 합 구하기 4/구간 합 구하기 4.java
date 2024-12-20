import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> number = new ArrayList<>(n);
        ArrayList<Integer> sumList = new ArrayList<>(n+1);
        sumList.add(0);
        for(int i = 0;i<n;i++){
            number.add(scanner.nextInt());
        }
        int temp = 0;
        for(int i = 0;i<n;i++){
            temp+=number.get(i).intValue();
            sumList.add(temp);
        }
        int start,end;
        for(int i = 0;i<m;i++){
            start = scanner.nextInt();
            end = scanner.nextInt();
            System.out.println(sumList.get(end).intValue()-sumList.get(start-1).intValue());
        }
        scanner.close();


    }
}