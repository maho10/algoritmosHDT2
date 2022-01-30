import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CalculatorController implements Calculator {

    private StackController<Double> equationStack = new StackController<>();

    @Override
    public double calculate(String operation) {

        String[] equation = operation.split(" ");

        loop: for (String num : equation) {

            boolean isNum;
            double num1;

            try {
                Double.parseDouble(num);
                isNum = true;
            } catch (Exception e) {
                isNum = false;
            }

            if (isNum) equationStack.add(Double.parseDouble(num));
            else {
                switch (num){
                    case "+":
                        try {
                            num1 = equationStack.remove() + equationStack.remove();
                            equationStack.add(num1);
                        } catch (Exception e){
                            System.out.println("Hacen falta números para completar la operación");
                            break loop;
                        }
                        break;
                    case "*":
                        try{
                            num1 = equationStack.remove() * equationStack.remove();
                            equationStack.add(num1);
                        } catch (Exception e){
                            System.out.println("Hacen falta números para completar la operación");
                            break loop;
                        }
                        break;
                    case "-":
                        try{
                            num1 = equationStack.remove() - equationStack.remove();
                            equationStack.add(num1);
                        } catch (Exception e){
                            System.out.println("Hacen falta números para completar la operación");
                            break loop;
                        }
                        break;
                    case "/":
                        try{
                            double num2 = equationStack.remove();
                            num1 = equationStack.remove()/num2;
                            equationStack.add(num1);
                        } catch (Exception e){
                            System.out.println("Hacen falta números para completar la operación");
                            break loop;
                        }
                        break;
                    default:
                        System.out.println("Se ha ingresado un signo no válido");
                        break loop;
                }
            }
        }
        if(equationStack.size()>1 || equationStack.empty()) {
            System.out.println("No se ha ingresado una operación válida");
            return 0;
        } else return equationStack.remove();
    }
}
