package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.Cell;

public class CellTest {
	Cell cell=new Cell();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCellState() {
		int cs1=cell.cellState(1,1);
		int cs2=cell.cellState(-1,5);
		int cs3=cell.cellState(3,4);
		assertEquals(0,cs1);
		assertEquals(0,cs2);
		assertEquals(1,cs3);
	}

	@Test
	public void testGetNeighbors() {
		int nei1=cell.getNeighbors(2,5);
		int nei2=cell.getNeighbors(11,5);
		int nei3=cell.getNeighbors(0,0);
		assertEquals(3,nei1);
		assertEquals(5,nei2);
		assertEquals(0,nei3);
	}

	@Test
	public void testNextWorld() {
		char[][] world=cell.nextWorld();
		assertEquals('*',world[2][5]);
		assertEquals('*',world[4][5]);
		assertEquals('*',world[9][5]);
		assertEquals('*',world[11][4]);
	}

}
