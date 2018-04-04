package com.nordea.gol;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nordea.gol.service.MatrixGenerationService;
import com.nordea.gol.service.NextGenerationService;
import com.nordea.gol.utils.GameOfLifeUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NextGenerationServiceTests {

	@Autowired
	private NextGenerationService nextGenerationService;

	@Autowired
	private MatrixGenerationService matrixGenerationService;

	@Test
	public void nextGenerationMatrix() {

		List<String> list = new ArrayList<>();
		list.add("X X X X X X");
		list.add("X X X X X X");
		list.add("X . . . X X");
		list.add("X X X X X X");
		list.add("X X X X X X");
		list.add("X X X X X X");
		String[][] cellMatrixGrid = matrixGenerationService.generateCellMatrix(list);
		String[][] nextGenerationMatrix = nextGenerationService.nextGenerationMatrix(cellMatrixGrid);

		Integer sizeOfArray = nextGenerationMatrix.length;
		assertTrue(new Integer(6).equals(sizeOfArray));
		// If Junit is successful, you can verify resulted cell matrix in console
		GameOfLifeUtils.printCellMatrix(nextGenerationMatrix);
		// TODO iterate through nextGenerationMatrix and check if items match the
		// expected items

	}

}