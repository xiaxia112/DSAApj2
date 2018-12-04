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
        System.out.println("�����վ "+departure.getName()+" ���յ�վ "+terminal.getName()+" ��ֱ�������·Ϊ��");
        printPath(terminal);
    }

    void transfer(){
        enterStations();
        departure.setDist(0);
        dijkstra(departure);
        System.out.println("\n�����վ "+departure.getName()+" ����תվ "+transfer.getName()+" �ľ�����·Ϊ��");
        printPath(transfer);

        metro.refresh();

        transfer.setDist(0);
        dijkstra(transfer);
        System.out.println("\n\n����תվ "+transfer.getName()+" ���յ�վ "+terminal.getName()+" �ľ�����·Ϊ��");
        printPath(terminal);
    }



    private void enterStations(){
        System.out.println("������ \"���վ (��תվ�� �յ�վ\"");
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

    //dijkstra�㷨
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

