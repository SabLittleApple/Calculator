/**
 * The main part of the calculator doing the calculations.
 *
 * @version 0.1 (in progress)
 * @author: (Sabrina)
 */
public class CalcEngine {
    private int displayValue;
    private char previousOperator;
    private int leftOperand;
    private int rightOperand;
    private int result;

    /**
     * Create a CalcEngine.
     */
    public CalcEngine() {
        displayValue = 0;
        leftOperand = 0;
        rightOperand = 0;
        previousOperator = ' ';
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public int getDisplayValue() {

        return displayValue;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     *
     * @param number The number pressed on the calculator.
     */
    public void numberPressed(int number) {
        displayValue = displayValue * 10 + number;
        if (previousOperator != ' ') {
            rightOperand = displayValue;
            result = leftOperand;
            applyPreviousOperator();
        }
    }

    /**
     * The 'plus' button was pressed.
     */
    public void plus() {
        previousOperator = '+';
        if (leftOperand == 0) {
            leftOperand = displayValue;
            displayValue = 0;
        }
    }

    /**
     * The 'minus' button was pressed.
     */
    public void minus() {
        previousOperator = '-';
        if (leftOperand == 0) {
            leftOperand = displayValue;
            displayValue = 0;
        }
    }

    /**
     * The '=' button was pressed.
     */
    public int equals() {

        return result;
    }


    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear() {
        displayValue = 0;
        rightOperand = 0;
        leftOperand = 0;
        previousOperator = ' ';
    }


    /**
     * An operator button has been pressed.
     * Apply the immediately preceding operator to
     * calculate an intermediate result. This will
     * form the left operand of the new operator.
     */
    public void applyPreviousOperator() {
        if (previousOperator == '+') {
            result += rightOperand;
        } else if (previousOperator == '-') {
            result -= rightOperand;
        }
        leftOperand = result;
        displayValue = 0;
    }


    /**
     * @return The title of this calculation engine.
     */
    public String getTitle() {

        return "Super Calculator";
    }

    /**
     * @return The author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor() {

        return "Written by Sabrina Melina";
    }

    /**
     * @return The version number of this engine. This string is displayed as
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion() {

        return "Version 1.1";
    }


    public int getLeftOperand() {

        return leftOperand;
    }

    public int getRightOperand() {

        return rightOperand;
    }
}
