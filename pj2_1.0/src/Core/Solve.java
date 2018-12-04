package Core;

import Data.Metro;
import Data.Station;

import java.util.ArrayList;
import java.util.Scanner;

class Solve {
    private ArrayList<String> route;
    private Station departure, transfer, terminal;
    private Metro metro;


    Solve(){
        metro = new Metro();
        route = new ArrayList<String>();
    }


    void direct(){
        enterStations();
        departure.setDist(0);
        dijkstra(departure);
        System.out.println("从起点站 "+departure.getName()+" 到终点站 "+terminal.getName()+" 的直达具体线路为：");
        printPath(terminal);
    }

    void transfer(){
        enterStations();
        departure.setDist(0);
        dijkstra(departure);
        System.out.println("\n从起点站 "+departure.getName()+" 到中转站 "+transfer.getName()+" 的具体线路为：");
        printPath(transfer);

        metro.refresh();

        transfer.setDist(0);
        dijkstra(transfer);
        System.out.println("\n\n从中转站 "+transfer.getName()+" 到终点站 "+terminal.getName()+" 的具体线路为：");
        printPath(terminal);
    }



    private void enterStations(){
        System.out.println("请输入 \"起点站 (中转站） 终点站\"");
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");

        departure = metro.getStation(strs[0]);

        if (strs.length == 3){
            transfer = metro.getStation(strs[1]);
            terminal = metro.getStation(strs[2]);
        }
        else
            terminal = metro.getStation(strs[1]);
    }

    //dijkstra算法
    private void dijkstra(Station s){
        s.setKnown(true);
        for (String str:s.getAdjacent().keySet()) {
            if (metro.getStation(str).isKnown()){
                int csv = s.getAdjacent().get(str);
                if (s.getDist()+csv< metro.getStation(str).getDist()){
                    metro.getStation(str).setDist(s.getDist()+csv);
                    metro.getStation(str).setPath(s);
                }
            }
        }
        while (metro.minimum()!=null){
            dijkstra(metro.minimum());
        }
    }

    private void printPath(Station terminal){
        if (terminal.getPath()!=null){
            printPath(terminal.getPath());
            System.out.print("-"+terminal.getPath().getLine().get(terminal.getName())+"-");
        }
        System.out.print(terminal.getName());
        }
    }

