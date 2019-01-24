import java.util.*;
public class ConnectFour
{
	public ConnectFour()
	{
		
	}
	
	public void dividerLine()
	{
		for(int i=0;i<6;i++)
		{
			System.out.println("|");
		}
	}
	
	public String[][] createBoard()
	{
		String[][] board = new String[6][7];
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				board[i][j] = "_";
			}
		}
		return board;
	}
	
	public void printBoard(String[][] board)
	{
		for(int i=0;i<6;i++)
		{
			System.out.print("| ");
			for(int j=0;j<7;j++)
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println("  0   1   2   3   4   5   6");
	}
	
	public void dropRedDisk(String[][] board, int y)
	{
		int x = 5;
		for(int i=0;i<6;i++)
		{
			if(board[x][y].equals("_"))
			{
				board[x][y] = "R";
				break;//once the disk is dropped, opt out of the loop and go to the next turn
			}
			x--;//if the bottom spot is occupied, then check the next spot above
		}
	}
	
	public void dropYellowDisk(String[][] board, int y)
	{
		int x = 5;
		for(int i=0;i<6;i++)
		{
			if(board[x][y].equals("_"))
			{
				board[x][y] = "Y";
				break;//once the disk is dropped, opt out of the loop and go to the next turn
			}
			x--;//if the bottom spot is occupied, then check the next spot above
		}
	}
	
	public boolean redWinHorizontal(String[][] board)
	{
		int count;
		int a = 0;
		int b = 4;
		
		for(int k=0;k<4;k++)//BEGINS A TRIPLE FOR LOOP
		{
			for(int i=0;i<6;i++)
			{
				count = 0;
				for(int j=a;j<b;j++)
				{
					if(board[i][j].equals("R"))
					{
						count += 1;
					}
				}
				if(count == 4)
				{
					return true;
				}
			}
			a += 1;
			b += 1;
		}
		return false;
	}
	
	public boolean redWinVertical(String[][] board)
	{
		int count;
		int a = 0;
		int b = 4;
		
		for(int k=0;k<3;k++)//BEGINS A TRIPLE FOR LOOP
		{
			for(int i=0;i<7;i++)
			{
				count = 0;
				for(int j=a;j<b;j++)
				{
					if(board[j][i].equals("R"))
					{
						count += 1;
					}
				}
				if(count == 4)
				{
					return true;
				}
			}
			a += 1;
			b += 1;
		}
		return false;
	}
	
	public boolean yellowWinHorizontal(String[][] board)
	{
		int count;
		int a = 0;
		int b = 4;
		
		for(int k=0;k<4;k++)//BEGINS A TRIPLE FOR LOOP
		{
			for(int i=0;i<6;i++)
			{
				count = 0;
				for(int j=a;j<b;j++)
				{
					if(board[i][j].equals("Y"))
					{
						count += 1;
					}
				}
				if(count == 4)
				{
					return true;
				}
			}
			a += 1;
			b += 1;
		}
		return false;
	}
	
	public boolean yellowWinVertical(String[][] board)
	{
		int count;
		int a = 0;
		int b = 4;
		
		for(int k=0;k<3;k++)//BEGINS A TRIPLE FOR LOOP
		{
			for(int i=0;i<7;i++)
			{
				count = 0;
				for(int j=a;j<b;j++)
				{
					if(board[j][i].equals("Y"))
					{
						count += 1;
					}
				}
				if(count == 4)
				{
					return true;
				}
			}
			a += 1;
			b += 1;
		}
		return false;
	}
	
	public boolean redWinDiagonal(String board[][])
	{
		//////////////LEFT TO RIGHT///////////////
		for(int i=0;i<4;i++) //ROW 0
		{
			if(board[0][i] == "R" && board[1][i+1] == "R" && board[2][i+2] == "R" && board[3][i+3] == "R")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 1
		{
			if(board[1][i] == "R" && board[2][i+1] == "R" && board[3][i+2] == "R" && board[4][i+3] == "R")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 2
		{
			if(board[2][i] == "R" && board[3][i+1] == "R" && board[4][i+2] == "R" && board[5][i+3] == "R")
			{
				return true;
			}
		}
		
		////////////////RIGHT TO LEFT////////////////////
		for(int i=0;i<4;i++) //ROW 3
		{
			if(board[3][i] == "R" && board[2][i+1] == "R" && board[1][i+2] == "R" && board[0][i+3] == "R")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 4
		{
			if(board[4][i] == "R" && board[3][i+1] == "R" && board[2][i+2] == "R" && board[1][i+3] == "R")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 5
		{
			if(board[5][i] == "R" && board[4][i+1] == "R" && board[3][i+2] == "R" && board[2][i+3] == "R")
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean yellowWinDiagonal(String board[][])
	{
		//////////////LEFT TO RIGHT///////////////
		for(int i=0;i<4;i++) //ROW 0
		{
			if(board[0][i] == "Y" && board[1][i+1] == "Y" && board[2][i+2] == "Y" && board[3][i+3] == "Y")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 1
		{
			if(board[1][i] == "Y" && board[2][i+1] == "Y" && board[3][i+2] == "Y" && board[4][i+3] == "Y")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 2
		{
			if(board[2][i] == "Y" && board[3][i+1] == "Y" && board[4][i+2] == "Y" && board[5][i+3] == "Y")
			{
				return true;
			}
		}
		
		////////////////RIGHT TO LEFT////////////////////
		for(int i=0;i<4;i++) //ROW 3
		{
			if(board[3][i] == "Y" && board[2][i+1] == "Y" && board[1][i+2] == "Y" && board[0][i+3] == "Y")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 4
		{
			if(board[4][i] == "Y" && board[3][i+1] == "Y" && board[2][i+2] == "Y" && board[1][i+3] == "Y")
			{
				return true;
			}
		}
		
		for(int i=0;i<4;i++) //ROW 5
		{
			if(board[5][i] == "Y" && board[4][i+1] == "Y" && board[3][i+2] == "Y" && board[2][i+3] == "Y")
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isDraw(String[][] board)
	{

		int count = 0;
		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(board[i][j] != "_")
				{
					count += 1;
				}
			}
		}
		
		if(count == 42)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}