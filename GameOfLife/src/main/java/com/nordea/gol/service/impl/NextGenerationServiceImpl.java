/*
 * 
 */
package com.nordea.gol.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nordea.gol.constants.GameOfLifeConstants;
import com.nordea.gol.service.NextGenerationService;
import com.nordea.gol.utils.GameOfLifeUtils;

@Service
public class NextGenerationServiceImpl implements GameOfLifeConstants, NextGenerationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NextGenerationService.class);

	@Override
	public String[][] nextGenerationMatrix(String[][] cellMatrix) {
		String[][] nextGenerationMatrix = GameOfLifeUtils.copyGrid(cellMatrix);

		for (int i = 0; i < cellMatrix.length; i++) {
			for (int j = 0; j < cellMatrix[i].length; j++) {

				List<String> neighbors = new ArrayList<String>();
				// Find the neighbor cells to the current one.
				getNeighbourCells(cellMatrix, i, j, neighbors);

				int countLiveNeighbours = 0;
				// Count live neighbours for cell in question
				for (int k = 0; k < neighbors.size(); k++)
					if (neighbors.get(k).compareTo(LIFE) == 0)
						countLiveNeighbours += 1;

				//Populate next Generation matrix based on countLiveNeighbours
				populateNextGenMatrix(cellMatrix, nextGenerationMatrix, i, j, countLiveNeighbours);
			}
		}
		return nextGenerationMatrix;
	}
	
	
    /**
     * Populate next generation matrix.
     *
     * @param cellMatrix the cell matrix
     * @param nextGenerationMatrix the next generation matrix
     * @param i the i
     * @param j the j
     * @param countLiveNeighbours the count live neighbours
     */
	private void populateNextGenMatrix(String[][] cellMatrix, String[][] nextGenerationMatrix, int i, int j,
			int countLiveNeighbours) {
		if (cellMatrix[i][j].compareTo(DEATH) == 0) {
			// check if new cell can be spawned
			if (countLiveNeighbours == 3) {
				nextGenerationMatrix[i][j] = LIFE;
			}
		} else { // else current cell lives
			// check if cell must die of over-population or under-population
			if (countLiveNeighbours < 2 || countLiveNeighbours > 3) {
				nextGenerationMatrix[i][j] = DEATH;
			}
		}
	}

	/**
	 * Gets the neighbour cells.
	 *
	 * @param cellMatrix the cell matrix
	 * @param i the i
	 * @param j the j
	 * @param neighbors the neighbors
	 * @return the neighbour cells
	 */
	private void getNeighbourCells(String[][] cellMatrix, int i, int j, List<String> neighbors) {
		neighbors.add(cellMatrix[Math.floorMod(i - 1, cellMatrix.length)][Math.floorMod(j - 1, cellMatrix[i].length)]);
		neighbors.add(cellMatrix[Math.floorMod(i - 1, cellMatrix.length)][j]);
		neighbors.add(cellMatrix[Math.floorMod(i - 1, cellMatrix.length)][Math.floorMod(j + 1, cellMatrix[i].length)]);
		neighbors.add(cellMatrix[i][Math.floorMod(j - 1, cellMatrix[i].length)]);
		neighbors.add(cellMatrix[i][Math.floorMod(j + 1, cellMatrix[i].length)]);
		neighbors.add(cellMatrix[Math.floorMod(i + 1, cellMatrix.length)][Math.floorMod(j - 1, cellMatrix[i].length)]);
		neighbors.add(cellMatrix[Math.floorMod(i + 1, cellMatrix.length)][j]);
		neighbors.add(cellMatrix[Math.floorMod(i + 1, cellMatrix.length)][Math.floorMod(j + 1, cellMatrix[i].length)]);
	}

}
