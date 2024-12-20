import java.util.Scanner;
import java.lang.Integer;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int temp = A*B*C;
        String tempString = Integer.toString(temp);
        for(int j = 0;j<10;j++){

            int count = 0;
            for(int i = 0;i<tempString.length();i++){
                if((char)('0'+j) == (tempString.charAt(i))){
                    count++;
                }
            }
            System.out.println(count);
        }


    scanner.close();
    }
}