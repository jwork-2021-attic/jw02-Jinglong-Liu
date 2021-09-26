package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Scene {
    public static void main(String[] args) throws Exception{
        Snake snake = Snake.instance();

        //Sorter sorter = new SelectSorter();
        Sorter sorter = new QuickSorter();

        snake.setSorter(sorter);

        Matrix line = Monster.getMonsters(12,12);

        String log = snake.lineUp(line);
        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result4.txt"));
        writer.write(log);
        writer.flush();
        writer.close();
    }
}
