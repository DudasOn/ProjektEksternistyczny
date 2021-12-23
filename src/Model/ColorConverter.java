package Model;

import java.awt.*;

public class ColorConverter {

    private int r, g ,b;
    private Color color;

    public ColorConverter(){
        this.r=0;
        this.g=0;
        this.b=0;
        color= new Color(r,g,b);
    }

    public ColorConverter(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b=b;
        this.color=new Color(r,g,b);
    }

    public ColorConverter(String colorValue){

        if(colorValue.length()==6) color = Color.decode(colorValue);
        else color=new Color(0, 0, 0);
    }

    public Color getColor(){
        return color;
    }
}
