package Alex.Gochenour.GameOfLifeAPI;

import org.springframework.beans.factory.annotation.Autowired;

public class CellularLogic {

	@Autowired
	static PetriDishStorage petriDishStorage;
	
	//This method evaluates rows and sees if a given cell dies of loneliness.
	public char[] lonelinessDeathHorizontal(char[] inputArray) {
		char[] outputArray = new char[inputArray.length];
		for (int i = 1; i < inputArray.length - 1; i++) {
			if (inputArray[i - 1] == '.' | inputArray[i + 1] == '.') {
				outputArray[i] = '.';
			} else {
				outputArray[i] = 'O';
			}
		}
		outputArray[0] = '.';
		outputArray[5] = '.';

		return outputArray;
	}

//	This method evaluates cells both horizontally and vertically and sees if a given cell dies of loneliness.
	public char[][] lonelinessDeathHorizontal2D(char[][] inputArray) {

		char[][] outputArray = new char[2][6];

		for (int i = 1; i < inputArray[0].length - 1; i++) {
			if (inputArray[0][i - 1] == '.' | inputArray[0][i + 1] == '.') {
				outputArray[0][i] = '.';
			} else {
				outputArray[0][i] = 'O';
			}
		}
		outputArray[0][0] = '.';
		outputArray[0][5] = '.';

		for (int i = 0; i < outputArray[1].length; i++) {
			outputArray[1][i] = '.';
		}

		return outputArray;
	}

	public char[][] lonelinessDeathVertical(char[][] inputArray) {

		char[][] outputArray = new char[6][6];

		for (int i = 1; i < (inputArray[i].length - 1); i++) {
			for (int j = 1; j < inputArray[j].length - 1; j++) {
				outputArray[i][0] = '.';
				outputArray[i][5] = '.';
				if (inputArray[i - 1][j] == '.' || inputArray[i + 1][j] == '.') {
					outputArray[i][j] = '.';
				} else {
					outputArray[i][j] = '@';
				}
			}
		}
		for (int i = 0; i < outputArray.length; i++) {
			outputArray[0][i] = '.';
			outputArray[5][i] = '.';
		}
		return outputArray;
	}

//	This evaluates if a cell dies of overcrowding
	public char[][] deathByFourNeighbors(char[][] inputArray) {

		char[][] outputArray = inputArray;

		for (int i = 1; i < (inputArray[i].length - 1); i++) {
			for (int j = 1; j < inputArray[j].length - 1; j++) {
				int totalNeighbors = 0;
				if (inputArray[i - 1][j - 1] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i - 1][j] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i - 1][j + 1] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i][j - 1] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i][j + 1] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i + 1][j - 1] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i + 1][j] == '@') {
					totalNeighbors++;
				}
				if (inputArray[i + 1][j + 1] == '@') {
					totalNeighbors++;
				}
				if (totalNeighbors > 3) {
					outputArray[i][j] = '.';
				}
				if (totalNeighbors < 2) {
					outputArray[i][j] = '.';
				}
			}
		}
		return outputArray;
	}

//	This accounts for both death and birth of cells
	public char[][] deathAndBirth(char[][] inputArray) {
		char[][] outputArray = new char[inputArray.length][inputArray[0].length];
		
		for (int i = 1; i < (inputArray[i].length - 1); i++) {
			for (int j = 1; j < inputArray[j].length - 1; j++) {
				int totalNeighbors = 0;
				if (inputArray[i - 1][j - 1] == '@') {
					totalNeighbors++;
					System.out.println("One above and to the right.");
				}
				if (inputArray[i - 1][j] == '@') {
					totalNeighbors++;
					System.out.println("One above.");
				}
				if (inputArray[i - 1][j + 1] == '@') {
					totalNeighbors++;
					System.out.println("One above and to the left.");
				}
				if (inputArray[i][j - 1] == '@') {
					totalNeighbors++;
					System.out.println("One behind");
				}
				if (inputArray[i][j + 1] == '@') {
					totalNeighbors++;
					System.out.println("One to the right");
				}
				if (inputArray[i + 1][j - 1] == '@') {
					totalNeighbors++;
					System.out.println("One below and to the left");
				}
				if (inputArray[i + 1][j] == '@') {
					totalNeighbors++;
					System.out.println("One below");
				}
				if (inputArray[i + 1][j + 1] == '@') {
					totalNeighbors++;
					System.out.println("One below and to the right");
				}
				System.out.println("Total neighbors: " + totalNeighbors);
				
//				Death from loneliness
				if ((inputArray[i][j] == '@') && (totalNeighbors <= 1)) {
					outputArray[i][j] = '.';
				} 
				
//				Birth from three neighbors
				else if ((inputArray[i][j] == '.') && (totalNeighbors == 3)) {
					outputArray[i][j] = '@';
				}
				
//				State unchanged, two neighbors
				else if ((inputArray[i][j] == '@') && (totalNeighbors == 2)) {
					outputArray[i][j] = '@';
				}

//				State unchanged, three neighbors
				else if ((inputArray[i][j] == '@') && (totalNeighbors == 3)) {
					outputArray[i][j] = '@';
				}
//				Death from overcrowding
				else if ((inputArray[i][j] == '@') && (totalNeighbors >= 4)) {
					outputArray[i][j] = '.';
				}
				
			}
		}
		for (int i = 0; i < outputArray.length; i++) {
			System.out.println(outputArray[i]);
		}
		return outputArray;
	}

//	I have extracted the logic that determines a cell's fate from the method that follows this one.
	public static char determineCellFate(int neighbors, char inputChar) {
		if (neighbors > 3) {
			return '.';
		} else if (neighbors == 3) {
			return '@';
		} else if ((inputChar == '.') && (neighbors == 2)) {
			return '.';
		} else if ((inputChar == '@') && (neighbors == 2)) {
			return '@';
		} else
			return '.';
	}
	
//	This is the final iteration of the core logic of this program:
	public static char[][] edgesAndInterior(char[][] inputArray) {
		char[][] outputArray = new char[inputArray.length][inputArray[0].length];
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[0].length; j++) {
				outputArray[i][j] = '.';
			}
		}
		
//		This For-Loop only touches the first and last rows:
		for (int i = 0; i < inputArray.length - 1; i += (inputArray.length-1)) {
			for (int j = 1; j < inputArray[0].length - 2; j++) {
//				First row, excluding the corners:
				if (i == 0) {
					int totalNeighbors = 0;
					if (inputArray[i][j-1] == '@')  {totalNeighbors++;}
					if (inputArray[i+1][j-1] == '@'){totalNeighbors++;}
					if (inputArray[i+1][j] == '@')  {totalNeighbors++;}
					if (inputArray[i+1][j+1] == '@'){totalNeighbors++;}
					if (inputArray[i][j+1] == '@')  {totalNeighbors++;}
					
					outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);
//				Last row, excluding corners:
				} else if (i == inputArray[0].length - 1) {
					int totalNeighbors = 0;
					if (inputArray[i][j-1] == '@')  {totalNeighbors++;}
					if (inputArray[i-1][j-1] == '@'){totalNeighbors++;}
					if (inputArray[i-1][j] == '@')  {totalNeighbors++;}
					if (inputArray[i-1][j+1] == '@'){totalNeighbors++;}
					if (inputArray[i][j+1] == '@')  {totalNeighbors++;}

					outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);
				}
			}
//				First row, corners only:
			for (int j = 0; j < inputArray.length - 1; j += (inputArray.length-1)) {
				if (j == 0) {
					int totalNeighbors = 0;
					if (j == 0 && inputArray[i][j+1] == '@')   {totalNeighbors++;}
					if (j == 0 && inputArray[i+1][j] == '@')   {totalNeighbors++;}
					if (j == 0 && inputArray[i+1][j+1] == '@') {totalNeighbors++;}
					
					outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);

				} else if (j == (inputArray.length - 1)) {
					int totalNeighbors = 0;
					if (j == 0 && inputArray[i][j-1] == '@')   {totalNeighbors++;}
					if (j == 0 && inputArray[i+1][j-1] == '@')   {totalNeighbors++;}
					if (j == 0 && inputArray[i+1][j] == '@') {totalNeighbors++;}

					outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);
				}
			}
		}
		
//		Leftmost and rightmost columns only:
		for (int i = 1; i < inputArray.length -1; i++) {
			for (int j = 0; j < inputArray[0].length; j+= (inputArray[0].length - 1)) {
//				leftmost column, excluding corners
				if (j==0) {
					int totalNeighbors = 0;
					if (inputArray[i-1][j]=='@') {totalNeighbors++;}
					if (inputArray[i-1][j+1]=='@') {totalNeighbors++;}
					if (inputArray[i][j+1]=='@') {totalNeighbors++;}
					if (inputArray[i+1][j+1]=='@') {totalNeighbors++;}
					if (inputArray[i+1][j]=='@') {totalNeighbors++;}
					
					outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);
				} 
//				rightmost column, excluding corners
				else if (j==(inputArray[0].length-1)) {
					int totalNeighbors = 0;
					if (inputArray[i-1][j]=='@') {totalNeighbors++;}
					if (inputArray[i-1][j-1]=='@') {totalNeighbors++;}
					if (inputArray[i][j-1]=='@') {totalNeighbors++;}					
					if (inputArray[i+1][j-1]=='@') {totalNeighbors++;}
					if (inputArray[i+1][j]=='@') {totalNeighbors++;}
					
					outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);
				}
			}
		}
		
//		INTERIOR
		for (int i = 1; i < (inputArray.length - 1); i++) {
			for (int j = 1; j < (inputArray[0].length - 1); j++) {
				int totalNeighbors = 0;
				
//				Previous row
				if (inputArray[i-1][j-1]=='@') {totalNeighbors++;}
				if (inputArray[i-1][j]=='@')   {totalNeighbors++;}
				if (inputArray[i-1][j+1]=='@') {totalNeighbors++;}
//				Current row
				if (inputArray[i][j-1]=='@')   {totalNeighbors++;}
				if (inputArray[i][j+1]=='@')   {totalNeighbors++;}
//				Following row
				if (inputArray[i+1][j-1]=='@') {totalNeighbors++;}
				if (inputArray[i+1][j]=='@')   {totalNeighbors++;}
				if (inputArray[i+1][j+1]=='@') {totalNeighbors++;}
				
				outputArray[i][j] = determineCellFate(totalNeighbors, inputArray[i][j]);
			}
		}
		
		for (int i = 0; i < outputArray.length; i++) {
			System.out.println(outputArray[i]);
		}
		return outputArray;
		}

}
