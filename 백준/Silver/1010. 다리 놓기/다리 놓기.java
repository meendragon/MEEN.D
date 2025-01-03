import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0;i<testCase;i++){
            String userInput = br.readLine();
            String[] tokens = userInput.split(" ");
            double ans = 1;
            double N = Double.parseDouble(tokens[0]);
            double M = Double.parseDouble(tokens[1]);
            for(int j = 0;j<N;j++){
                ans*=((M-j)/(N-j));
            }
            String roundedAns = String.format("%.0f", ans);
            System.out.println(roundedAns);
        }
    }
}