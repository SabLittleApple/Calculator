import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcEngineTest {
    private int displayValue;
    private char previousOperator;
    private int leftOperand;
    private int rightOperand;


    public CalcEngineTest() {
    }

   @Test
    public void setUp(){
        CalcEngine engine = new CalcEngine();
        engine.numberPressed(5);
        engine.plus();
        engine.numberPressed(1);
        assertEquals(6,6);
    }



}