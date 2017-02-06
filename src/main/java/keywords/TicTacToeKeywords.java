package keywords;

import edu.jsu.mcis.*;

public class TicTacToeKeywords {

    private TicTacToeModel model;

    public void startNewGame() {
        model = new TicTacToeModel();
    }

    public void markLocation(int row, int col) {
        model.setMark(row, col);
    }

    public String getMark(int row, int col) {
        int temp = model.getMark(row, col);
        if (temp == 1) {
            return "X";
        }
        if (temp == 2) {
            return "O";
        }
        if (temp == 0) {
            return "EMPTY";
        }
        return "";
    }

    public String getWinner() {
        model.CheckForWin();
        return model.Winner;
    }
}
