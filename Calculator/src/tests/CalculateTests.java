package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Calculate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CalculateTests {
    private Calculate Calculate;

	@BeforeEach
    void setUp() {
		ArrayList<Double> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		
		a.add(1.0);
		a.add(2.0);
		a.add(3.0);
		a.add(4.0);
		a.add(5.0);
		a.add(6.0);

		b.add(0);
		b.add(0);
		b.add(0);
		b.add(0);
		b.add(0);
		b.add(0);

		Calculate = new Calculate(a, b);
    }

    @Test
    void TruncationTest() {
        assertEquals(121000, Calculate.trunkate(121358.1315, 3));
        
    }
    @Test
    void TestRunCalculation() {
        assertEquals(20, Calculate.run_calculation());
    }

    @Test
    void root_NthRootOfTwoInt() {
        assertEquals(5, Calculate.root(8, 390625));
    }
    @Test
    void exponate() {
        assertEquals(125, Calculate.exponate(5, 3));
    }
}
