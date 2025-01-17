import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        String [] tokens = userInput.split(" ");
        BigInteger N = new BigInteger(tokens[0]);
        BigInteger M = new BigInteger(tokens[1]);
        BigInteger ans = N.add(M);
        System.out.println(ans);

    }
}