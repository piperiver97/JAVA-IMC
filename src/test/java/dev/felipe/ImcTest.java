package dev.felipe;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImcTest {

    @Test
    public void testCalculateIMC() {
        double weight = 85;
        double height = 1.75;
        double expectedIMC = 85 / (1.75 * 1.75);
        assertEquals(expectedIMC, Imc.CalculateIMC(weight, height), 0.01);

        assertThrows(IllegalArgumentException.class, () -> Imc.CalculateIMC(-1, 1.75));
        assertThrows(IllegalArgumentException.class, () -> Imc.CalculateIMC(85, -1.75));
        assertThrows(IllegalArgumentException.class, () -> Imc.CalculateIMC(0, 1.75));
        assertThrows(IllegalArgumentException.class, () -> Imc.CalculateIMC(85, 0));
    }

    @Test
    public void testClassifyIMC() {
        assertEquals("Severe Underweight", Imc.classifyIMC(15.5));
        assertEquals("Moderate Underweight", Imc.classifyIMC(16.5));
        assertEquals("Mild Underweight", Imc.classifyIMC(17.5));
        assertEquals("Normal weight", Imc.classifyIMC(22.0));
        assertEquals("Overweight", Imc.classifyIMC(27.0));
        assertEquals("Mild Obesity", Imc.classifyIMC(32.0));
        assertEquals("Moderate Obesity", Imc.classifyIMC(37.0));
        assertEquals("Morbid Obesity", Imc.classifyIMC(42.0));
    }
}
