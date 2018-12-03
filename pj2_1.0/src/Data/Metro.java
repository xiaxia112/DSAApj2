package Data;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Metro implements Serializable {
    public Station[] stations = new Station[323];

    public Metro(){
        init();

    }

    //从Excel文件读取数据，
    private void init(){
        File file = new File("materials/Timetable.xls");
        if (file.exists()){
            try{
                Workbook wb = Workbook.getWorkbook(file);
                int sheets = wb.getNumberOfSheets();
                for (int i = 0; i < sheets; i++) {
                    String

                }
                String linename

/*
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent;
                int i =0;
                while((lineContent = br.readLine())!=null ){
                    System.out.println(lineContent);
                    stations[i] = new Station(lineContent);
                    i++;
                }
*/
            }catch (IOException e){
                System.out.println("fail to read file");
                e.printStackTrace();
            } catch (BiffException e) {
                System.out.println("not support .xlxs file");
                e.printStackTrace();
            }
        }
    }

    //计算两个时间之间差了多少分钟
    private long getWeight(String str1,String str2){
        DateFormat df = new SimpleDateFormat("HH:mm");
        try {
            Date date1 = df.parse(str1);
            Date date2 = df.parse(str2);
            return Math.abs(date1.getTime() - date2.getTime() / (1000 * 60));
        } catch (Exception e) {
            System.out.println("Time computing fail ");
            e.printStackTrace();
        }
        return 0;
    }

    public Station getStation(String name){
        Station station = null;
        for (int i = 0; i < 323; i++) {
            if (stations[i].getName().equals(name)){
                station = stations[i];
                break;
            }
        }
        return station;
    }

    //直接获取当前station的最小unknown邻站点，无则返回null
    public Station minimum(Station station){
        Station s = null;
        int min = 9999;
        Map<String, Integer> map = station.getAdjacent();
        for (String key:map.keySet()) {
            Station station1 = getStation(key);
            if (!station1.isKnown()){
                if (map.get(key)<min){
                    s =  station1;
                    min = map.get(key);
                }
            }
        }
        return s;
    }
}
