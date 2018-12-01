package Core;

import Data.Station;

import java.util.Scanner;

public class Slove {
    private Station departure, transfer, terminal;

    public Slove(){
        stations();


    }

    private void stations(){
        System.out.println("Please enter \"departure transfer terminal\"");
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.next().split(" ");
        departure = strs[0];
        if (strs.length == 3){
            transfer = strs[1];
            terminal = strs[2];
        }
        else
            terminal = strs[1];
    }


}
