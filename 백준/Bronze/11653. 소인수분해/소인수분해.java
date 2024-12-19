import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetNum = scanner.nextInt();
        scanner.close();
        int startNum = 2;
        while(targetNum!=1){
            if(targetNum%startNum == 0){
                System.out.println(startNum);
                targetNum/=startNum;
                startNum = 2;
            }else{
                startNum++;
            }
        }
    }
}