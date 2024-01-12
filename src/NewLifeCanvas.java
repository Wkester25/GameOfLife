import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NewLifeCanvas extends JFrame {

    private JPanel MainPanel;
    private JPanel ContentPanel;
    private JPanel InputPanel;
    private JButton Start;
    private JSlider slider1;
    private JButton Stop;
    private JButton Fill;
    private JComboBox comboBox1;
    private JPanel SizingPanel;
    private JLabel Title;
    private LifeGridCells grid;
    private Panel GamePanel;



    public NewLifeCanvas(LifeGridCells g) {
        grid = g;
        setContentPane(MainPanel);
        setTitle("Game of Life");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel = makePanel(grid);
        SizingPanel.add(GamePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public Panel makePanel(LifeGridCells m){
        Panel GridPanel = new Panel();
        int widestRow = 0;
        for(Cell[] row : m.getGrid()) {
            if(row.length > widestRow) {
                widestRow = row.length;
            }
        }
        GridPanel.setLayout(new GridLayout(m.getGrid().length, widestRow));
        for(Cell[] row : m.getGrid()) {
            for(Cell col : row) {
                JPanel cell = new JPanel();
                cell.setBackground(col.getCellColor());
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                GridPanel.add(cell);
            }
        }
        return GridPanel;
    }

    public void paintGrid(){
        SizingPanel.removeAll();
        GamePanel = makePanel(grid);
        SizingPanel.add(GamePanel, BorderLayout.CENTER);
        GamePanel.setVisible(true);
        SizingPanel.revalidate();
        MainPanel.repaint();

    }

    public void next(){
        grid.evolve();
        paintGrid();

    }



    public static void main(String[] args) throws InterruptedException {
        LifeGridCells g = new LifeGridCells(25,25);
        g.setCell(1,1, true);
        g.setCell(1,2, true);
        g.setCell(2,1, true);
        g.setCell(2,2, true);
        NewLifeCanvas window = new NewLifeCanvas(g);
        Thread.sleep(1000);
        window.next();
        g.evolve();
        for(Cell[] row : g.getGrid()) {
            for(Cell col : row) {
                System.out.print(col.getState());
            }
            System.out.println();
        }
        System.out.println(window.grid.getCell(1,1).getState());
        System.out.println(window.grid.getCell(1,2).getState());
        System.out.println(window.grid.getCell(2,1).getState());
        System.out.println(window.grid.getCell(2,2).getState());





    }


}
