package com.nordea.gol.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nordea.gol.constants.GameOfLifeConstants;
import com.nordea.gol.service.MatrixGenerationService;

@Service
public class MatrixGenerationServiceImpl implements GameOfLifeConstants, MatrixGenerationService {

	@Override
	public String[][] generateCellMatrix(List<String> inputMatrixList) {

		String[][] cellMatrixGrid = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		// Iterate though inputList to every row
		for (int i = 0; i < inputMatrixList.size(); i++) {
			// Split every row to get each item in row and put in matrix
			String[] myStringArray = inputMatrixList.get(i).split(" ");
			for (int j = 0; j < myStringArray.length; j++) {
				cellMatrixGrid[i][j] = myStringArray[j];
			}
		}
		return cellMatrixGrid;
	}

}