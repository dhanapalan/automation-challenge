import java.util.Scanner;

public class MatrixGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[3][3];
        boolean isValidInput = false;

        // Read input and validate
        while (!isValidInput) {
            System.out.println("Enter the game data (3x3 matrix):");
            for (int i = 0; i < 3; i++) {
                String row = scanner.nextLine().toUpperCase(); // convert input to uppercase
                if (row.length() != 3) {
                    System.out.println("Invalid input. Please enter 3 characters per row.");
                    isValidInput = false;
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    char c = row.charAt(j);
                    if (c != 'X' && c != 'O' && c != ' ') {
                        System.out.println("Invalid input. Please enter 'X', 'O', or ' ' (space).");
                        isValidInput = false;
                        break;
                    }
                    board[i][j] = c;
                    isValidInput = true;
                }
            }
        }

        // Check for winner
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'X') {
                    System.out.println("Winner: X");
                    scanner.close();
                    return;
                } else if (board[i][0] == 'O') {
                    System.out.println("Winner: O");
                    scanner.close();
                    return;
                }
            }
            // Check columns
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'X') {
                    System.out.println("Winner: X");
                    scanner.close();
                    return;
                } else if (board[0][i] == 'O') {
                    System.out.println("Winner: O");
                    scanner.close();
                    return;
                }
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'X') {
                System.out.println("Winner: X");
                scanner.close();
                return;
            } else if (board[0][0] == 'O') {
                System.out.println("Winner: O");
                scanner.close();
                return;
            }
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'X') {
                System.out.println("Winner: X");
                scanner.close();
                return;
            } else if (board[0][2] == 'O') {
                System.out.println("Winner: O");
                scanner.close();
                return;
            }
        }

        // No winner
        System.out.println("No winner.");
        scanner.close(); // scanner close
    }
}
