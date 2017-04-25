
/**
 * Created by BoogieJay
 * 4/23/17.
 */

public class Board {

    private final int SIZE = 4;
    private final Cell[][] cells;
    private int currentRow;
    private int currentCol;

    public Board () {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean isTie () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].getContent() == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWin(Seed seed) {

        if (cells[currentRow][0].getContent() == seed
                && cells[currentRow][1].getContent() == seed
                && cells[currentRow][2].getContent() == seed
                && cells[currentRow][3].getContent() == seed) {
            return true;
        }

        if (cells[0][currentCol].getContent() == seed
                && cells[1][currentCol].getContent() == seed
                && cells[2][currentCol].getContent() == seed
                && cells[3][currentCol].getContent() == seed) {
            return true;
        }

        if (currentCol == currentRow
                && cells[0][0].getContent() == seed
                && cells[1][1].getContent() == seed
                && cells[2][2].getContent() == seed
                && cells[3][3].getContent() == seed) {
            return true;
        }

        if (currentCol + currentRow == SIZE - 1
                && cells[0][3].getContent() == seed
                && cells[1][2].getContent() == seed
                && cells[2][1].getContent() == seed
                && cells[3][0].getContent() == seed) {
            return true;
        }

        return false;
    }

    public void paint() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].paint();
                System.out.print("|");
            }
            System.out.println();
            System.out.println("--------");
        }
        System.out.println();
    }

    public void setCurrentRow(int row) {
        this.currentRow = row;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }

    public void setCurrentCol(int col) {
        this.currentCol = col;
    }

    public int getCurrentCol() {
        return this.currentCol;
    }

    public int getSIZE() {
        return this.SIZE;
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Error in row and col");
        }
        return cells[row][col];
    }
}