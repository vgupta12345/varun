package com.nordea.gol.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameOfLifeUtils.
 */
public final class GameOfLifeUtils {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GameOfLifeUtils.class);

	/**
	 * Copies grid.
	 *
	 * @param grid the grid
	 * @return the string[][]
	 */
	public static String[][] copyGrid(String[][] grid) {
		String[][] tempGrid = new String[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				tempGrid[i][j] = grid[i][j];
			}
		}
		return tempGrid;
	}

	/**
	 * Prints the cell matrix.
	 *
	 * @param cellMatrix the cell matrix
	 */
	public static void printCellMatrix(String[][] cellMatrix) {
		StringBuffer sb = new StringBuffer("\n");
		for (int i = 0; i < cellMatrix.length; i++) {
			for (int j = 0; j < cellMatrix[i].length; j++) {
				sb.append("  " + cellMatrix[i][j] + "  ");
			}
			sb.append("\n");
		} LOGGER.info(sb.toString());
	}

}