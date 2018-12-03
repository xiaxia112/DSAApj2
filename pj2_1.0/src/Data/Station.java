package Data;

import java.util.Map;

public class Station {
    private int dist;
    private Map<String,Integer> adjacent;
    private Map<String,String> line;
    private boolean known;
    private String name;
    private Station path;

    Station(String str){
        setKnown(false);
        init(str);
    }

    private void init(String str){
        String[] strs = str.split(" ");
        name = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String[] detail = strs[i].split("-");
            adjacent.put(detail[0],Integer.parseInt(detail[2]));
            line.put(detail[0],detail[1]);
        }
    }

    public boolean hasUnkonwn(Metro metro){
        return false;

    }


    public String getName() {
        return name;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }

    public Map<String, Integer> getAdjacent() {
        return adjacent;
    }

    public Map<String, String> getLine() {
        return line;
    }
    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Station getPath() {
        return path;
    }

    public void setPath(Station path) {
        this.path = path;
    }
}
