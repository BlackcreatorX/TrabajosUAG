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
            if (currentPlayer.equals(PLAYER_X)) {
                clickedButton.setBackground(Color.CYAN);
            } else {
                clickedButton.setBackground(Color.MAGENTA);
            }
            if (checkForWin() || checkForDraw()) {
                disableAllButtons();
            } else {
                currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
                currentPlayerLabel.setText("Current Player: " + currentPlayer);
            }
        }
    }

    private boolean checkForWin() {
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().equals(EMPTY)) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[0][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().equals(EMPTY)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[0][0].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().equals(EMPTY)) {
            return true;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[0][2].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().equals(EMPTY)) {
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

    private void disableAllButtons() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText(EMPTY);
                buttons[i][j].setBackground(null); // Reset button color
            }
        }
        currentPlayer = PLAYER_X;
        currentPlayerLabel.setText("Current Player: " + currentPlayer);
        resultLabel.setText("");
    }
}
