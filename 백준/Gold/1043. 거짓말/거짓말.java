import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        int [][]people = new int[N][2];
        int [][]parties = new int[M][];
        for(int i = 0;i<T;i++){
            int temp = scanner.nextInt();
            people[temp-1][1] = 1;
        }

        int count = 0;
        for(int i = 0;i<M;i++){
            int partyN = scanner.nextInt();
            parties[i] = new int[partyN];
            for(int j = 0;j<partyN;j++){
                parties[i][j] = scanner.nextInt();
            }
        }
        boolean somethingChanged;
        do{
            somethingChanged = false;
            for(int i = 0;i<M;i++){
                boolean trueMan = false;
                for(int human : parties[i]){
                    if(people[human-1][1] == 1){
                        trueMan = true;
                        break;
                    }
                }
                if(trueMan){
                    for(int human : parties[i]){
                        if(people[human-1][1] == 0){
                            people[human-1][1] = 1;
                            somethingChanged = true;
                        }
                    }

                }
            }
        }while(somethingChanged);


        //count 세기
        for(int i = 0;i<M;i++){
            boolean party = false;
            for(int partyPeople : parties[i]){
                if(people[partyPeople-1][1]==1){
                    party = true;
                }
            }
            if(!party){count++;}
        }

        System.out.println(count);
        scanner.close();

    }
}
