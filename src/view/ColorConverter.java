package view;

import java.awt.*;

public abstract class ColorConverter {

    public static Color getColor(){
        return new Color(0,0,0);
    }

    public static Color getColor(int r, int g, int b){
        return new Color(r,g,b);
    }

    public static Color getColor(String colorValue){
        Color color;
        if(colorValue.length()==7) color = Color.decode(colorValue);
        else color=new Color(0,0,0);
        return color;
    }

}
