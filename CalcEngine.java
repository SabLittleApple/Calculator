/**
 * The main part of the calculator doing the calculations.
 *
 * @version 1
 * @author Sabrina
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

        clear();

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

        if (leftOperand == 0) {
            displayValue = displayValue * 10 + number;
            applyPreviousOperator();
        } else if (rightOperand == 0) {
            displayValue = 0;
            displayValue = displayValue * 10 + number;
            rightOperand = displayValue;
            result = leftOperand;
        } else {
            leftOperand = result;
            rightOperand = 0;
            displayValue = 0;
            displayValue = displayValue * 10 + number;
            rightOperand = displayValue;
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
        } else if (rightOperand != 0) {
            result = leftOperand + rightOperand;
            displayValue = result;
        }
    }


    /**
     * The 'minus' button was pressed.
     */
    public void minus() {
        previousOperator = '-';
        if (leftOperand == 0) {
            leftOperand = displayValue;
        } else if (rightOperand != 0) {
            result = leftOperand - rightOperand;
            displayValue = result;
        }
    }

    /**
     * The '=' button was pressed.
     */
    public void equals() {

        if (rightOperand != 0) {
            if (previousOperator == '+')
                result = leftOperand + rightOperand;

            if (previousOperator == '-') {
                result = leftOperand - rightOperand;
            }
            displayValue = result;
        }

        if (leftOperand == 0) {
            if (previousOperator == '+') {
                result = leftOperand + rightOperand;
            }
            if (previousOperator == '-') {
                result = leftOperand - rightOperand;
            }
        }
        if (rightOperand == 0) {
            result = leftOperand;
        } else {
            displayValue = result;
        }
        leftOperand = result;
        rightOperand = 0;

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
            if (leftOperand == 0) {
                rightOperand = displayValue;
            }
            result += rightOperand;
        } else if (previousOperator == '-') {
            if (leftOperand != 0) {
                result -= rightOperand;
            } else {
                rightOperand = displayValue;
                result += -rightOperand;
            }
        }
        else {
            result = leftOperand;
        }
    }

        /**
         * @return The title of this calculation engine.
         */
        public String getTitle () {

            return "Super Calculator";
        }

        /**
         * @return The author of this engine. This string is displayed as it is,
         * so it should say something like "Written by H. Simpson".
         */
        public String getAuthor () {

            return "Written by Sabrina Melina";
        }

        /**
         * @return The version number of this engine. This string is displayed as
         * it is, so it should say something like "Version 1.1".
         * public int getLeftOperand() {
         * <p>
         * return leftOperand;
         * }
         * <p>
         * public int getRightOperand() {
         * <p>
         * return rightOperand;
         * }
         */
        public String getVersion () {

            return "Version 1.1";
        }


    }
