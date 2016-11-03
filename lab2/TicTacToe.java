import java.util.Scanner;

public class TicTacToe{

	/*public static void main(String[] args) {

	}*/

	private char[][] board;
	private char player; // 'X' or 'O'

	/*
	 * Instantiate board to be a 3 by 3 char array of spaces.
	 * Set player to be 'X'.
	 */

	public TicTacToe() {
		/*
		* Step 1: create an empty board, with an initial value
		* of a space (' ')
		*/
		board = new char[3][3];
		player = 'X';
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				board[i][j] = ' ';
	}

	/*
	 * If s represents a valid move, add the current player's symbol to the board and return true.
	 * Otherwise return false.
	 */
	public boolean play(String s) {
		/* Step 2: Fill in here with your own
		* play logic, and replace the return with your
		* own.
		*/
		char charColumn = s.charAt(1);
		int column;

		if(charColumn == '1')
			column = 0;
		else if(charColumn == '2')
			column = 1;
		else if(charColumn == '3')
			column = 2;
		else return false;

		if(s.charAt(0) == 'a' || s.charAt(0) == 'A')
		{
			if(board[0][column] == ' ')
			{
				board[0][column] = player;
				return true;
			}
		}
		if(s.charAt(0) == 'b' || s.charAt(0) == 'B')
		{
			if(board[1][column] == ' ')
			{
				board[1][column] = player;
				return true;
			}
		}
		if(s.charAt(0) == 'c' || s.charAt(0) == 'C')
		{
			if(board[2][column] == ' ')
			{
				board[2][column] = player;
				return true;
			}
		}

	  return false;
	}

	/*
	 * Switches the current player from X to O, or O to X.
	 */
	public void switchTurn() {
		// Step 3: Fill in with your code to toggle between
		// 'X' and 'O'
		if(player == 'X')
			player = 'O';
		else
			player = 'X';
	}

	/*
	 * Returns true if the current player has won the game.
	 * Three in a row, column or either diagonal.
	 * Otherwise, return false.
	 */
	public boolean won() {
		/* Step 5: Fill in the code for the won method. This method
        * should return true if the current player has 3 in-a-row
		* in any row, column or diagonal. Otherwise, return false.
		*/

		//check horizontal win
		for(int i = 0; i < 3; i++)
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2])
				return true;

		//check vertical Wins
		for(int i = 0; i < 3; i++)
			if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i])
				return true;

		//check top left to bottom right Wins
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
			return true;
		//check top right to bottom left
		if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
			return true;

		return false; // TODO: replace with your own return statement.
	}

	/*
	 * Returns true if there are no places left to move
	 */
	public boolean stalemate() {
	    /*
		 * Step 4: Fill in the code for the stalemate method. It
         * should return true if there are no more places to move
		 * on the board. Otherwise, return false return false;
		 */
		 for(int i = 0; i < 3; i++)
			 for(int j = 0; j < 3; j++)
				 if(board[i][j] == ' ')
				 	return false;
		 return true;   // replace with your own return
	}
	public char getPlayer() {
		return player;
	}
	public void print() {
		System.out.println();
		System.out.println("\t  1 2 3");
		System.out.println();
		System.out.println("\tA "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("\t  -----");
		System.out.println("\tB "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("\t  "+"-----");
		System.out.println("\tC "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
		System.out.println();
	}

	/*
	 * Step 6: Main Method for Final Step - Delete your main method
	 * and uncomment this one.
	 * Runs the game by getting input from the user, making the
	 * appropriate moves, and prints who won or if it was a stalemate.
	*/

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to tic-tac-toe");
		System.out.println("Enter coordinates for your move following the X and O prompts");

		while(!game.stalemate()) {
			//Print the game
			game.print();

			//Prompt player for their move
			System.out.println("Enter your move: ");
			String move = in.next();

			while(move.length() != 2)
			{
				System.out.println("Invalid move. Enter another move: ");
				move = in.next();
			}

			while(!game.play(move))
			{
				System.out.println("Invalid move. Enter another move: ");
				move = in.next();
			}

			//Loop while the method play does not return true when given their move.
			//Body of loop should ask for a different move

			//If the game is won, call break;
			if(game.won())
				break;

			//Switch the turn
			game.switchTurn();

		}
		game.print();
		if(game.won()){
			System.out.println("Player "+game.getPlayer()+" Wins!!!!");
		} else {
			System.out.println("Stalemate");
		}
	}
}
