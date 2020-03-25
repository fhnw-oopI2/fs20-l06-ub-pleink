package ui;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Theme {


    private static final double SAT = 0.17;

    private int hue;
    private Map<String, Color> colorMap;


    Theme(int hue){
        this.hue = hue;
        colorMap = new HashMap<>();
        colorMap.put("lighter", Color.hsb(hue, SAT, 0.98));
        colorMap.put("light", Color.hsb(hue, SAT, 0.88));
        colorMap.put("medium", Color.hsb(hue, SAT, 0.73));
        colorMap.put("dark", Color.hsb(hue, SAT, 0.48));
        colorMap.put("darker", Color.hsb(hue, SAT, 0.23));
    }

    public Color lighter(){
        return colorMap.get("lighter");
    }

    public Color light(){
        return colorMap.get("light");
    }

    public Color medium(){
        return colorMap.get("medium");
    }

    public Color dark(){
        return colorMap.get("dark");
    }

    public Color darker(){
        return colorMap.get("darker");
    }
}
