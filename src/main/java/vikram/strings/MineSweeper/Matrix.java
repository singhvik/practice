package vikram.strings.MineSweeper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Matrix {
    public static final int MINE=9;
    private int rows;
    private int cols;
    private int mines;
    private int[][] mineGrid;
    private int[][] exposedGrid;
    private Set<String> processedItems= new HashSet<>();

    public Matrix(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        mineGrid = new int[rows][cols];
        exposedGrid = new int[rows][cols];
        generateGrid();
        for (int i = 0; i < rows; i++) {
            Arrays.fill(exposedGrid[i], -1);
        }
    }

    private void generateGrid() {
        Random random = new Random();
        int x, y;
        for (int i = 0; i < mines; ) {
            x = random.nextInt(rows);
            y = random.nextInt(cols);
            if (mineGrid[x][y] == 0) {
                i++;
                mineGrid[x][y] = 9;
                addNeighbour(x-1, y-1);
                addNeighbour(x, y-1);
                addNeighbour(x+1, y-1);

                addNeighbour(x-1, y+1);
                addNeighbour(x, y+1);
                addNeighbour(x+1, y+1);

                addNeighbour(x-1, y);
                addNeighbour(x+1, y);
            }
        }
    }

    private void addNeighbour(int row, int col){
        if(row>0 && row < rows && col>0 && col<cols){
            mineGrid[row][col] +=1;
        }

    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exposedGrid[i][j] == -1) {
                    System.out.print("- ");
                } else {
                    System.out.print(exposedGrid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printMatrixOriginal() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mineGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns true when picked a mine
     * @param row
     * @param column
     * @return
     */
    public boolean pick(int row, int column){
        if(row>=0 && row<rows && column>=0 && column<cols) {
            // valid selection.
            if(mineGrid[row][column] == MINE ){
                // game over
                return true;
            }
            else if(mineGrid[row][column] >0){
                // neighbour of a mine picked
                exposedGrid[row][column] = mineGrid[row][column];
            }else if(!processedItems.contains(row+"-"+column)){
                // not a neighbour of a mine picked.
                exposedGrid[row][column] = mineGrid[row][column];
                processedItems.add(row+"-"+column);
                pick(row-1,column-1);
                pick(row,column-1);
                pick(row+1,column-1);

                pick(row-1,column);
                pick(row+1,column);

                pick(row-1,column+1);
                pick(row,column+1);
                pick(row+1,column+1);
            }
        } else {
            // Invalid selection;
            System.out.println("Invalid selection");
        }
        return false;
    }
}

