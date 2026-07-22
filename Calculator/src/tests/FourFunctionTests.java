package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JTextArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.FourFunctionCalculator;


public class FourFunctionTests {

	FourFunctionCalculator ffc;
	
    @BeforeEach
	public void setup() {
		ffc = new FourFunctionCalculator();
		ffc.reset();
	}
	
    private void pressNumber(int digit) throws Exception {
        Method numberMaker = FourFunctionCalculator.class.getDeclaredMethod("number_maker", int.class);
        numberMaker.setAccessible(true);
        numberMaker.invoke(ffc, digit);

        Method turn = FourFunctionCalculator.class.getDeclaredMethod("turn");
        turn.setAccessible(true);
        turn.invoke(ffc);
    }

    private void pressFunc(int index) throws Exception {
        Method numberChanger = FourFunctionCalculator.class.getDeclaredMethod("number_changer", int.class);
        numberChanger.setAccessible(true);
        numberChanger.invoke(ffc, index);

        Method turn = FourFunctionCalculator.class.getDeclaredMethod("turn");
        turn.setAccessible(true);
        turn.invoke(ffc);
    }

    private String getDisplayText() throws Exception {
        Field displayField = FourFunctionCalculator.class.getDeclaredField("display");
        displayField.setAccessible(true);
        JTextArea display = (JTextArea) displayField.get(ffc);
        return display.getText();
    }

    @Test
    void DisplayTest1() throws Exception {
        pressNumber(1);
        pressNumber(2);
        pressFunc(0);  
        pressNumber(3);

        String text = getDisplayText();
        System.out.println("Display shows: " + text + "");

        assertEquals("12.0 +  3.0", text);
    }
    @Test
    void DisplayTest2() throws Exception {
        pressNumber(1);
        pressNumber(2);
        pressFunc(0);  
        pressNumber(3);
        pressFunc(4);  

        String text = getDisplayText();
        System.out.println("Display shows: " + text + "");

        assertEquals("15.0", text);
    }
    @Test
    void DisplayTest3() throws Exception {
        pressNumber(1);
        pressNumber(0);
        pressFunc(1);  
        pressNumber(3);
        pressNumber(2);

        String text = getDisplayText();
        System.out.println("Display shows: " + text + "");

        assertEquals("10.0 -  32.0", text);
    }
}