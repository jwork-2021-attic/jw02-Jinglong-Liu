package task3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
public class Color implements Comparable<Color>{
    public int r;
    public int g;
    public int b;
    
    public String toString(){
        return new String("r = " + r + " g = " + g + " b = " + b);
    }
    @Override
    public int compareTo(Color color){
        return ColorUtil.map.get(this) - ColorUtil.map.get(color);
    }
    @Override
	public boolean equals(Object obj){
        Color color = (Color)obj;
        return color.r == this.r && color.g == this.g && color.b == this.b; 
    }
    @Override
    public int hashCode() {
        String s=String.format("%03d%03d%03d",r,g,b);
        return s.hashCode();
    }
    public int rank(){
        return ColorUtil.map.get(this);
    }
}
class ColorUtil {
    public static HashMap<Color,Integer>map = ColorUtil.getColorMap();
    public static Color[] getRandomColors(){
        Color[] colors = getColor();
        Random random = new Random();
            for(int i = 0; i < Monster.MonsterNum; i++){
               int p = random.nextInt(Monster.MonsterNum);
               Color tmp = colors[i];
               colors[i] = colors[p];
               colors[p] = tmp;
            }
        return colors;
    }
    public static Color[] getColor(){
        Color[]rgb = new Color[Monster.MonsterNum];
        
        BufferedImage bi = null;
        try{
            bi = ImageIO.read(new File("c256.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();

        float w = (float)width/16;
        float h = (float)height/16;
        for(int i = 0;i<Monster.ROW;i++){
            for(int j = 0;j<Monster.COL;j++){
                int x = (int)(w/2 + w * j);
                int y = (int)(h/2 + h * i);
                int pixel=bi.getRGB(x,y);
                rgb[(i*Monster.ROW)+j] = new Color();
                rgb[(i*Monster.ROW)+j].r = (pixel &  0xff0000) >> 16;
                rgb[(i*Monster.ROW)+j].g = (pixel &  0xff00) >> 8;
                rgb[(i*Monster.ROW)+j].b = (pixel &  0xff);
            }
        }
        return rgb;
    }
    public static HashMap<Color,Integer>getColorMap(){
        HashMap<Color,Integer>map = new HashMap<>();
        Color[] rgb = ColorUtil.getColor();
        for(int i = 0;i<Monster.MonsterNum;i++){
            map.put(rgb[i],Integer.valueOf(i));
        }
        return map;
    }
    public static void main(String[] args){
        Color[]rgb = ColorUtil.getColor();
        for(int i = 0;i<256;i++){
            System.out.println(rgb[i]);
        }
    }
}
