package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Calculate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTests {
    private Calculate Calculate;

	@BeforeEach
    void setUp() {
		Calculate = new Calculate(null, null);
    }

    @Test
    void TruncationTest() {
        assertEquals(121000, Calculate.trunkate(121358.1315, 3));
        assertEquals(100, Calculate.trunkate(123, 1));
        assertEquals(90000, Calculate.trunkate(90234, 2));
        
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
