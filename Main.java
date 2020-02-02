public class Main {
    public static void main(String[] args) {
        CalcEngine eng = new CalcEngine();

        eng.numberPressed(2);
        eng.plus();
        eng.numberPressed(5);
        eng.equals();
        eng.plus();


        //System.out.println("The result is " + eng.equals());
        new UserInterface(eng);
    }
}

