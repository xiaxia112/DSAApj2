package Core;

import Data.Metro;
import Data.Station;

import java.util.Map;
import java.util.Scanner;

public class Slove {

    final private int INFINITY = 9999;
    private Station departure, transfer, terminal;
    private Metro metro;

    public Slove(){
        metro = new Metro();
        stations();


    }

    private void stations(){
        System.out.println("Please enter \"departure transfer terminal\"");
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.next().split(" ");
        departure = metro.getStation(strs[0]);
        if (strs.length == 3){
            transfer = metro.getStation(strs[1]);
            terminal = metro.getStation(strs[2]);
        }
        else
            terminal = metro.getStation(strs[1]);
    }

    //dijkstra算法
    void dijkstra(Station s){
        for (Station station:metro.stations) {
            station.setDist(INFINITY);
            station.setKnown(false);
        }
        s.setDist(0);

        while (metro.minimum(s)!=null){
            Station v = metro.minimum(s);
            v.setKnown(true);
            Map<String, Integer> map = v.getAdjacent();
            for (String name: map.keySet()) {
                Station w = metro.getStation(name);
                if (!w.isKnown()){
                    int cvw = map.get(name);
                    if (v.getDist()+cvw<w.getDist()){

                    }
                }
            }
        }
    }

    void printPath(Station departure){
        if (departure.getPath()!=null){
            printPath(departure.getPath());
            System.out.print("to");
        }
        System.out.println(departure);

    }



}
