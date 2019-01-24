import java.util.*;
public class Test 
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Connect Four!");
		System.out.println();
		
		Scanner keyboard = new Scanner(System.in);
		ConnectFour game = new ConnectFour();//makes a game object
		String[][] board = game.createBoard();//creates a board and assigns it to a variable named "board"
		game.printBoard(board);//prints out board
		boolean resultHoriz;
		boolean resultVert;
		boolean resultDiag;
		boolean resultDraw;
		
			///////////////ACTUAL GAME//////////////////////
			int a = 1;
			int b = 1;
			
			game_loop:
			for(int i=0;i<42;i++)
			{
				do {
				try
				{
					//////RED PLAYER TURN/////////
					System.out.print("Drop a red disk at (0-6): ");
					int x = keyboard.nextInt();
					game.dropRedDisk(board, x);
					a = 2;
					game.printBoard(board);
					resultHoriz = game.redWinHorizontal(board);
					resultVert = game.redWinVertical(board);
					resultDiag = game.redWinDiagonal(board);
					resultDraw = game.isDraw(board);
					
					if(resultDraw == true)
					{
						System.out.print("The game is a draw.");
						break game_loop;
					}
					
					if(resultHoriz == true || resultVert == true || resultDiag == true)
					{
						System.out.print("RED PLAYER WINS");
						break game_loop;
					}
				}
				catch(Exception ex)
				{
					System.out.println("Please enter a valid column number (press any key to continue).");
					keyboard.next();//stores invalid output into a trash input variable
				}
				}while(a == 1);
				
	
				do {
				try
				{
					///////YELLOW PLAYER TURN////////
					System.out.print("Drop a yellow disk at (0-6): ");
					int y = keyboard.nextInt();
					game.dropYellowDisk(board, y);
					b = 2;
					game.printBoard(board);		
					resultHoriz = game.yellowWinHorizontal(board);
					resultVert = game.yellowWinVertical(board);
					resultDiag = game.yellowWinDiagonal(board);
					resultDraw = game.isDraw(board);
					
					if(resultDraw == true)
					{
						System.out.print("The game is a draw.");
						break game_loop;
					}
		
					if(resultHoriz == true || resultVert == true || resultDiag == true)
					{
						System.out.print("YELLOW PLAYER WINS");
						break game_loop;
					}
				}
				catch(Exception ex)
				{
					System.out.println("Please enter a valid column number (press any key to continue).");
					keyboard.next();//stores invalid output into a trash input variable
				}
				}while(b == 1);
			}
	}
}