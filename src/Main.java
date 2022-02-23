import controllers.CalculatorController;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	static String[] operaciones = {};
	static double resultados[] = {};
	static CalculatorController calculator = CalculatorController.getInstance(InfixPostfix.stackType());
	
	static void nuevaOperacion(String text) {
		
		String nuevaOperacion = text;
		
		operaciones = Arrays.copyOf(operaciones,operaciones.length + 1);
		operaciones[operaciones.length - 1] = nuevaOperacion;
		
	}
	
	static void nuevoResultado(double resultado) {
		
		double nuevoResultado = resultado;
		
		resultados = Arrays.copyOf(resultados,resultados.length + 1);
		resultados[resultados.length - 1] = nuevoResultado;
		
	}
	static void leerTexto(String url) {
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(url));
			
			
			String linea;
			int i = 0;
			
			while((linea = reader.readLine()) != null) {
				
				nuevaOperacion(linea);
				i = i+1;
			    
			}
			
			reader.close();
			
		} catch(IOException e) {
			
			System.out.println("Algo no funciono. Verifique que la operacion este bien escrita.");
	}
	}
	
	
	public static void calcular() {
		
		for (String operacion: operaciones) {
			
			nuevoResultado(calculator.calculate(operacion));
			
		}
		
	}
	
	public static void imprimirResultados() {
		System.out.println(" ");
		System.out.println("------------------------------------------------RESULTADOS------------------------------------------------");
		System.out.println(" ");
		System.out.println("Tipo de stack empleado: " + InfixPostfix.stack.getClass());
		System.out.println(" ");
		for (int i = 0; i < resultados.length; i++) {
			
			System.out.println("El resultado de la operacion " + i+1 +" es " + resultados[i]);
		}
		
	}
	
	
	public static void prompt() {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("--------------------------------------------POSTFIX CALCULATOR--------------------------------------------");
		System.out.println(" ");
		System.out.print("Ingresa la direccion del archivo de texto INFIX (Ej: C:\\Users\\fulanito\\datos.txt) -> ");

		
		try{
			String direccion = input.nextLine();
			
			InfixPostfix.leerDatosInfix(direccion);
			
			InfixPostfix.printPostFix("datosPF.txt");
			leerTexto("datosPF.txt");
			calcular();
			imprimirResultados();
			
			} catch (Exception e){
				e.printStackTrace();
				System.out.println("No se ingreso una operacion valida");
			}

		
		
	}
	
	
	
	
	
	public static void main(String args[]) {
		
		InfixPostfix.seleccionEstructura();
		
		prompt();
		
	}
	
}
