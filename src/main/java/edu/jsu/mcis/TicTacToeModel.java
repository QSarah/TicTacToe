package edu.jsu.mcis;

public class TicTacToeModel {

    public int[][] grid;
    public boolean xTurn = true;
    private int turnCounter;
    public String Winner = "";
    private TicTacToeView View;

    public TicTacToeModel(){
        
        View = new TicTacToeView(this);
        grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][i] = 0;
            }
        }
        turnCounter = 0;
        xTurn = true;
     
    }

    public int getMark(int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        } else if (grid[row][col] == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public void setMark(int row, int col) {
        if (grid[row][col] == 0) {
            if (xTurn) {
                grid[row][col] = 1;
            } else if (!xTurn) {
                grid[row][col] = 2;
            }

            turnCounter++;
        }
        
        switch (CheckForWin()) {
            case 0:
                Winner = "";
                View.resultLabel.setText("No Winner");
                break;
            case 1:
                if (xTurn) {
                    Winner = "X";
                    View.resultLabel.setText("X");
                } else {
                    Winner = "O";
                    View.resultLabel.setText("O");
                }
                break;
            case 2:
                Winner = "TIE";
                View.resultLabel.setText("TIE");
                break;
            default:
                View.resultLabel.setText("default");
                break;

        }

        xTurn = !xTurn;
    }

    public int CheckForWin() {

        if (CheckHorizontalWin()) {
            return 1;
        }
        if (CheckVerticalWin()) {
            return 1;
        }
        if (CheckDiagonal1()) {
            return 1;
        }
        if (CheckDiagonal2()) {
            return 1;
        }
        if (CheckTieIfAllFilled()) {
            return 2;
        }
        return 0;

    }

    private boolean CheckHorizontalWin() {
        int x, y, z;

        for (int i = 0; i < 3; i++) {
            x = grid[i][0];
            y = grid[i][1];
            z = grid[i][2];
            if ((x == y) && (y == z) && (z != 0)) {
                return true;

            }

        }
        return false;
    }

    private boolean CheckVerticalWin() {
        int a, b, c;

        for (int i = 0; i < 3; i++) {
            a = grid[0][i];
            b = grid[1][i];
            c = grid[2][i];
            if ((a == b) && (b == c) && (c != 0)) {
                return true;

            }
        }
        return false;
    }

    private boolean CheckDiagonal1() {
        int j, k, l;

        j = grid[0][0];
        k = grid[1][1];
        l = grid[2][2];
        if ((j == k) && (k == l) && (l != 0)) {
            return true;

        }
        return false;
    }

    private boolean CheckDiagonal2() {
        int d, e, f;

        d = grid[0][2];
        e = grid[1][1];
        f = grid[2][0];
        if ((d == e) && (e == f) && (f != 0)) {
            return true;

        }
        return false;
    }

    private boolean CheckTieIfAllFilled() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    return false;

                }

            }

        }
        return true;
    }

}
