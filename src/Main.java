import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LifeGridCells g = new LifeGridCells(25,25);
        NewLifeCanvas window = new NewLifeCanvas(g);

    }
}