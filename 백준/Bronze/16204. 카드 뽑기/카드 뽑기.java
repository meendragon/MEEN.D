import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cardCount = scanner.nextInt();
        int foreO = scanner.nextInt();
        int backO = scanner.nextInt();
        int foreX = cardCount-foreO;
        int backX = cardCount-backO;

        int sameShape = Math.min(foreO,backO) + Math.min(foreX,backX);

        System.out.print(sameShape);
        scanner.close();
    }
}
