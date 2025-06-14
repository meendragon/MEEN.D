import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        ArrayList<Long> classroom = new ArrayList<>();
        for(long i = 0;i<n;i++){
            long k = sc.nextLong();
            classroom.add(k);
        }
        long B = sc.nextLong();
        long C = sc.nextLong();
        long count = n;
        for(int i = 0;i<n;i++){
            long temp = classroom.get(i);
            temp -= B;
            if(temp<=0) continue;
            count +=(temp/C);
            if(temp%C != 0){
                count++;
            }
        }
        System.out.print(count);
    }
}