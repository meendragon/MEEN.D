import java.util.Scanner;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String money = scanner.next();
        String n = scanner.next();
        scanner.close();
        BigInteger moneyBig = new BigInteger(money);
        BigInteger nBig = new BigInteger(n);
        System.out.println(moneyBig.divide(nBig));
        System.out.println(moneyBig.mod(nBig));

    }
}