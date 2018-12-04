package Data;

import java.io.*;

public class Metro{
    private Station[] stations = new Station[324];

    public Metro(){
        init();
    }

    public void refresh(){
        for (Station station:stations) {
            station.refresh();
        }
    }

    //从txt文件读取数据，并生成相应站点
    private void init(){
        File file = new File("materials/stations.txt");
            try{
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent;
                int i =0;
                while((lineContent = br.readLine())!=null ){
                    stations[i] = new Station(lineContent);
                    i++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("cannot found this file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("cannot read this file");
                e.printStackTrace();
            }
    }

    public Station getStation(String name){
        for (int i = 0; i < 324; i++) {
            if (stations[i].getName().equals(name)){
                return stations[i];
            }
        }
        return null;
    }

    //直接获取当前station的最小unknown邻站点，无则返回null
    public Station minimum(){
        Station min = null;
        for (Station station:stations) {
            if (station.isKnown()){
                if (min == null || station.getDist() < min.getDist()){
                    min = station;
                }
            }
        }
        return min;
    }
}
