public class LifeGrid {
    private int width;
    private int height;
    private int[][] grid;

    public LifeGrid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[width][height];
    }

    public void setCell(int x, int y, int value) {
        grid[x][y] = value;
    }

    public int getCell(int x, int y) {
        return grid[x][y];
    }

    public int getNumCols() {
        return width;
    }

    public int getNumRows() {
        return height;
    }

    public void evolve(){
        int[][] newGrid = new int[width][height];
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                int neighbors = countNeighbors(x, y);
                if (neighbors == 3) {
                    newGrid[x][y] = 1;
                } else if (neighbors == 2 && grid[x][y] == 1) {
                    newGrid[x][y] = 1;
                } else {
                    newGrid[x][y] = 0;
                }
            }
        }
        grid = newGrid;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if ((i >= 0 && i < width) && (j >= 0 && j < height)){
                    count += grid[i][j];
                }
            }
        }
        count -= grid[x][y];
        return count;
    }
}
