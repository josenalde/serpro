package serpro.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calc = new Calculator();
    @Test
    public void sum() {
        assertEquals(2, calc.add(1,1));
        //assertNotEquals
        //assertTrue
        //assertFalse
        //assertNull
        //assertNotNull
        //assertThrows
    }


}
