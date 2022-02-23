package tests;

import controllers.CalculatorController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {
    private final CalculatorController cc = CalculatorController.getInstance(1);

    @Test
    void calculate() {
        assertEquals(15, cc.calculate("1 2 + 4 * 3 +"));
    }
}
