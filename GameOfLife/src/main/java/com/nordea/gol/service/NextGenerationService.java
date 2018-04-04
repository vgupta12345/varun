package com.nordea.gol.service;

/**
 * The Interface NextGenerationService to generate next generation matrix by considering neighbours
 */
public interface NextGenerationService {

	/**
	 * Next generation matrix.
	 *
	 * @param grid
	 *            the grid
	 * @return the string[][]
	 */
	public String[][] nextGenerationMatrix(String[][] grid);

}
