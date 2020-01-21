public class Main {
    public static void main(String[] args) {
        CalcEngine eng = new CalcEngine();

        eng.numberPressed(-1);
        eng.minus();
        eng.numberPressed(-1);
        eng.minus();
        eng.numberPressed(2);
        eng.minus();
        eng.numberPressed(2);
        System.out.println("The result is " + eng.equals());
    }
}
