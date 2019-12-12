package Alex.Gochenour.GameOfLifeAPI;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;


public class CellularLogicTest {

//	@Test
	public void dieIfOnlyOneHorizontalNeighbor() {
		CellularLogic underTest = new CellularLogic();
		char[] testArray = {'.', '.', '.', '.', '.', '.'};
		char[] result = underTest.lonelinessDeathHorizontal(testArray);
		char[] secondPhase = {'.', '.', '.', '.', '.', '.'};
		assertArrayEquals(result, secondPhase);
	}
	
//	@Test
	public void canTestForHorizontalIn2DArrays() {
		CellularLogic underTest = new CellularLogic();
		char[][] testArray = {{'.', '.', '.', '.', '.', '.'},
							  {'.', '.', '.', '.', '.', '.'}};
		char[][] result = underTest.lonelinessDeathHorizontal2D(testArray);
		char[][] secondPhase = {{'.', '.', '.', '.', '.', '.'},
							    {'.', '.', '.', '.', '.', '.'}};
		assertArrayEquals(result, secondPhase);
	}
	
//	@Test
	public void canTestForVerticalNeighbors() {
		CellularLogic underTest = new CellularLogic();
		char[][] testArray =   {{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '@', '.'},
								{'.', '.', '@', '.', '@', '.'},
							    {'.', '.', '@', '.', '@', '.'},
							    {'.', '@', '@', '.', '.', '.'},
							    {'.', '.', '.', '.', '.', '.'}};
		char[][] result = underTest.lonelinessDeathVertical(testArray);
		char[][] phaseTwo =    {{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '@', '.'},
								{'.', '.', '@', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.'}};
		assertArrayEquals(result, phaseTwo);
	}
	
//	@Test
	public void moreThanThreeNeighborsCanBeLethal() {
		CellularLogic underTest = new CellularLogic();
		char[][] testArray =   {{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '@', '.', '.', '.'},
							    {'.', '@', '@', '@', '.', '.'},
							    {'.', '.', '@', '.', '.', '.'},
							    {'.', '.', '.', '.', '.', '.'}};
		char[][] result = underTest.deathByFourNeighbors(testArray);
		char[][] phaseTwo =    {{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.'},
								{'.', '.', '@', '.', '.', '.'},
								{'.', '@', '.', '@', '.', '.'},
								{'.', '.', '@', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.'}};
		assertArrayEquals(result, phaseTwo);
	}
	
//	@Test
	public void canResultInLifeOrDeathOnEdges() {
		CellularLogic underTest = new CellularLogic();
		
		char[][] testArray =   {{'.', '.', '.', '@', '@', '@', '.', '.'},
								{'@', '.', '.', '.', '.', '.', '.', '.'},
								{'@', '.', '.', '.', '.', '.', '.', '@'},
								{'@', '.', '.', '.', '.', '.', '.', '@'},
								{'.', '.', '.', '.', '.', '.', '.', '@'},
								{'.', '.', '.', '@', '@', '.', '.', '.'}};
		
		char[][] result = underTest.edgesAndInterior(testArray);
		
		char[][] phaseTwo =    {{'.', '.', '.', '.', '@', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.', '.', '.'},
								{'@', '.', '.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.', '.', '@'},
								{'.', '.', '.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.', '.', '.'}};
		assertArrayEquals(phaseTwo, result);
	}

	@Test
	public void threeNeighborsMakeNewCell() {
		CellularLogic underTest = new CellularLogic();
		
		char[][] testArray =   {{'.', '.', '.', '@', '@', '@', '.', '.'},
								{'@', '.', '.', '.', '.', '.', '.', '.'},
								{'@', '.', '.', '.', '.', '.', '.', '@'},
								{'@', '.', '.', '.', '.', '.', '.', '@'},
								{'.', '.', '.', '.', '.', '.', '.', '@'},
								{'.', '.', '.', '@', '@', '.', '.', '.'}};
		
		char[][] phaseTwo =    {{'.', '.', '.', '.', '@', '.', '.', '.'},
								{'.', '.', '.', '.', '@', '.', '.', '.'},
								{'@', '@', '.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.', '@', '@'},
								{'.', '.', '.', '.', '.', '.', '.', '.'},
								{'.', '.', '.', '.', '.', '.', '.', '.'}};
		
		char[][] result = underTest.edgesAndInterior(testArray);

		assertArrayEquals(phaseTwo, result);
		
		System.out.println("\n");
		
		char[][] testArray2 =  {{'.', '@', '.', '.', '.', '.', '.', '.'},
								{'@', '@', '@', '.', '.', '.', '.', '.'},
								{'.', '@', '.', '.', '.', '.', '@', '.'},
								{'.', '.', '.', '.', '.', '.', '@', '.'},
								{'.', '.', '.', '.', '.', '.', '@', '.'},
								{'.', '.', '.', '.', '.', '.', '.', '.'}};
		
		char[][] phaseTwo2 =    {{'@', '@', '@', '.', '.', '.', '.', '.'},
								 {'@', '.', '@', '.', '.', '.', '.', '.'},
								 {'@', '@', '@', '.', '.', '.', '.', '.'},
								 {'.', '.', '.', '.', '.', '@', '@', '@'},
								 {'.', '.', '.', '.', '.', '.', '.', '.'},
								 {'.', '.', '.', '.', '.', '.', '.', '.'}};
		char[][] result2 = underTest.edgesAndInterior(testArray2);

		assertArrayEquals(phaseTwo2, result2);
		
		System.out.println("\n");
		
		char[][] testArray3 =  {{'.', '.', '.', '@', '.', '.', '@', '.'},
								{'.', '@', '.', '.', '.', '.', '@', '.'},
								{'@', '.', '.', '.', '.', '.', '@', '.'},
								{'.', '@', '.', '.', '.', '.', '.', '.'},
								{'.', '.', '@', '.', '.', '.', '.', '.'},
								{'.', '@', '.', '.', '.', '@', '.', '.'}};
		
		char[][] phaseTwo3 =    {{'.', '.', '.', '.', '.', '.', '.', '.'},
								 {'.', '.', '.', '.', '.', '@', '@', '@'},
								 {'@', '@', '.', '.', '.', '.', '.', '.'},
								 {'.', '@', '.', '.', '.', '.', '.', '.'},
								 {'.', '@', '@', '.', '.', '.', '.', '.'},
								 {'.', '.', '.', '.', '.', '.', '.', '.'}};
		char[][] result3 = underTest.edgesAndInterior(testArray3);

		assertArrayEquals(phaseTwo3, result3);
	}
}
