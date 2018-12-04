package Core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solve solve = new Solve();
        Scanner scanner = new Scanner(System.in);
        System.out.println("起点-->终点，请输入a\n起点-->中转站-->终点，请输入b\n退出，请输入任意内容");
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
