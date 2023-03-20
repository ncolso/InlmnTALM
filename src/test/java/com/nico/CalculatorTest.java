package com.nico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        calculator.textField.setText("2");
        calculator.addBtn.doClick();
        calculator.textField.setText("3");
        calculator.equalBtn.doClick();
        assertEquals("5.0", calculator.textField.getText());
    }

    @Test
    public void testSubtraction() {
        calculator.textField.setText("5");
        calculator.subBtn.doClick();
        calculator.textField.setText("3");
        calculator.equalBtn.doClick();
        assertEquals("2.0", calculator.textField.getText());
    }

    @Test
    public void testMultiplication() {
        calculator.textField.setText("2");
        calculator.mulBtn.doClick();
        calculator.textField.setText("3");
        calculator.equalBtn.doClick();
        assertEquals("6.0", calculator.textField.getText());
    }

    @Test
    public void testDivision() {
        calculator.textField.setText("6");
        calculator.divBtn.doClick();
        calculator.textField.setText("3");
        calculator.equalBtn.doClick();
        assertEquals("2.0", calculator.textField.getText());
    }

    @Test
    public void testClear() {
        calculator.textField.setText("123");
        calculator.clrBtn.doClick();
        assertEquals("", calculator.textField.getText());
    }

    @Test
    public void testDelete() {
        calculator.textField.setText("123");
        calculator.delBtn.doClick();
        assertEquals("12", calculator.textField.getText());
    }
}