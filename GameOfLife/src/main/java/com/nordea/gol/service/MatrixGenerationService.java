/*
 * 
 */
package com.nordea.gol.service;

import java.util.List;

/**
 * The Interface MatrixGenerationService : to generate a 2/2 cell matrix by reading through an input file
 */
public interface MatrixGenerationService {

	/**
	 * Generate cell matrix.
	 *
	 * @param inputMatrixList the input matrix list
	 * @return the string[][]
	 */
	public String[][] generateCellMatrix(List<String> inputMatrixList);
}