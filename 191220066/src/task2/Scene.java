package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Scene {
    public static void main(String[] args) throws Exception{
        Snake snake = Snake.instance();

        //Sorter sorter = new SelectSorter();
        Sorter sorter = new QuickSorter();

        snake.setSorter(sorter);

        Line line = Monster.getMonsters(16,16);

        String log = snake.lineUp(line);
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result2.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}
