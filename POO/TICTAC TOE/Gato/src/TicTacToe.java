import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {

    private final int BOARD_SIZE = 3;
    private final String PLAYER_X = "X";
    private final String PLAYER_O = "O";
    private final String EMPTY = "";
    private String currentPlayer;
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
    private JLabel currentPlayerLabel;
    private JLabel resultLabel;
    private JButton restartButton;

    public TicTacToe() {
        currentPlayer = PLAYER_X;

        setTitle("Tic Tac Toe");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> resetGame());

        currentPlayerLabel = new JLabel("Current Player: " + currentPlayer);
        resultLabel = new JLabel("");

        controlPanel.add(currentPlayerLabel);
        controlPanel.add(restartButton);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals(EMPTY)) {
            clickedButton.setText(currentPlayer);
            if (checkForWin() || checkForDraw()) {

            } else {
                currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
                currentPlayerLabel.setText("Current Player: " + currentPlayer);
            }
        }
    }

    private boolean checkForWin() {
        String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = buttons[i][j].getText();
            }
        }

        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals(EMPTY)) {
                resultLabel.setText("Player " + board[i][0] + " wins!");
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals(EMPTY)) {
                resultLabel.setText("Player " + board[0][i] + " wins!");
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(EMPTY)) {
            resultLabel.setText("Player " + board[0][0] + " wins!");
            return true;
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(EMPTY)) {
            resultLabel.setText("Player " + board[0][2] + " wins!");
            return true;
        }

        return false;
    }

    private boolean checkForDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (buttons[i][j].getText().equals(EMPTY)) {
                    return false;
                }
            }
        }
        resultLabel.setText("It's a draw!");
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText(EMPTY);
            }
        }
        currentPlayer = PLAYER_X;
        currentPlayerLabel.setText("Current Player: " + currentPlayer);
        resultLabel.setText("");
    }
}
