package Core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solve solve = new Solve();
        Scanner scanner = new Scanner(System.in);
        System.out.println("���-->�յ㣬������a\n���-->��תվ-->�յ㣬������b\n�˳�����������������");
        String sc = scanner.nextLine();
        switch (sc){
            case "a":
                solve.direct();break;
            case "b":
                solve.transfer();break;
            case "x":
                System.exit(0);
        }
    }
}
