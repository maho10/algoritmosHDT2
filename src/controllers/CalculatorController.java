package controllers;

import controllers.stacks.StackControllerVector;

public class CalculatorController implements Calculator {

    private static CalculatorController instance = new CalculatorController();
    private StackControllerVector<Double> equationStack = new StackControllerVector<>();

    private CalculatorController(){}
    public static CalculatorController getInstance(){
        return instance;
    }

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

                            num1 = equationStack.remove() + equationStack.remove();
                            equationStack.add(num1);
                        break;
                    case "*":
                            num1 = equationStack.remove() * equationStack.remove();
                            equationStack.add(num1);
                        break;
                    case "-":
                            num1 = equationStack.remove() - equationStack.remove();
                            equationStack.add(num1);
                        break;
                    case "/":
                            double num2 = equationStack.remove();
                            if (num2 == 0) {
                                System.out.println("No existe la división entre 0");
                                num1 = equationStack.remove()/num2;
                                equationStack.add(num1);
                                break loop;
                            }
                                num1 = equationStack.remove()/num2;
                                equationStack.add(num1);

                        break;
                    default:
                        System.out.println("Se ha ingresado un signo no válido");
                        break loop;
                }
            }
        }
        if(equationStack.size()>1 || equationStack.empty()) {
            System.out.println("No se ha ingresado una operación válida");
        }
        return equationStack.remove();
    }
}
