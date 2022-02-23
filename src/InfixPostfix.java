import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import controllers.stacks.*;




public class InfixPostfix {

	
	static String[] operaciones = {};
	static String[] opsPF = {};
	static ArrayList<String> PostFix = new ArrayList<>();
	private static int sel;
	
	static StackFactory<String> factory = new StackFactory<String>();
	static  Stack<String> stack;
	
	
	static void nuevaOperacion(String text) {
		
		String nuevaOperacion = text;
		
		operaciones = Arrays.copyOf(operaciones,operaciones.length + 1);
		operaciones[operaciones.length - 1] = nuevaOperacion;
		
		}
	
	static void leerDatosInfix(String url) {
		
		
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
	
 
	public static void printPostFix(String url) {
		
		infixPostfix();
		
		
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter(url));
			
			for (String PF : opsPF) {
				
				escritor.write(PF + "\n");
				
			}
			
			escritor.close();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	
	
	public static boolean menosPrecedenteOigual(String simbolo1, String simbolo2) {
		
		if (simbolo1.equals("*") && simbolo2.equals("+")) {
			
			return false;
			
		} else if( simbolo1.equals("*") && simbolo2.equals("-")) {
			
			return false;
		
		} else if (simbolo1.equals("/") && simbolo2.equals("+")) {
			
			return false;
			
		} else if (simbolo1.equals("/") && simbolo2.equals("-")) {
			
			return false;
		} else if (simbolo1.equals("+") && simbolo2.equals("(")) {
			
			return false;
			
		}
		
		else {
			
			return true;
			
		}
	}
	
	
    
	public static void infixPostfix() {


		
		for (String op : operaciones) {
			
			String[] fix = op.split("");
			ArrayList<String> infix = new ArrayList<>();
			
			for (String i : fix) {
				
				infix.add(i);
			}
			
			
			
			for (String ch : infix) {
				
				
				  if (ch.matches("[A-Za-z0-9]+")) {
						
						PostFix.add(ch);
						
						
					} else if( ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
						
						if (stack.size() == 0) {
							
							stack.add(ch);
							
							
						} else if( stack.size() != 0) {
							
							if (menosPrecedenteOigual(ch, stack.peek())) {
								
								PostFix.add(stack.peek());
								stack.remove();
								stack.add(ch);
								
								
							} else if (!menosPrecedenteOigual(ch, stack.peek())) {
								
								stack.add(ch);
								
							}
							
						}
						
						
					} else if (ch.equals("(")) {
						
						stack.add(ch);
						
					} else if (ch.equals(")")) {

						while (!stack.peek().equals( "(")) {
							
							PostFix.add(stack.peek());
							stack.remove();	
								
								
							}
						
						stack.remove();
						
						}
						
					}
				  
			infix.clear();
			
			while (stack.size() != 0) {
				
				PostFix.add(stack.peek());
				stack.remove();
				
			}
			
			
			
			String expresion = String.join(" ", PostFix);
			
			
			opsPF = Arrays.copyOf(opsPF,opsPF.length + 1);
			opsPF[opsPF.length - 1] = expresion;
			
			PostFix.clear();
			
		}
		
	}
	
	
	public static void seleccionEstructura() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("--------------------------------------------POSTFIX CALCULATOR CON FACTORY-----------------------------------------------");
		System.out.println(" ");
		System.out.println("--------------------------------------------SELECCION DEL STACK A UTILIZAR---------------------------------------------- ");
		System.out.println(" ");
		System.out.println("	1 ARRAYLIST ");
		System.out.println("	2 VECTOR ");
		System.out.println("	3 LISTA SIMPLE ");
		System.out.println(" 	4 LISTA DOBLEMENTE ENCADENADA");
		System.out.println(" ");
		System.out.print(" SELECCION -> ");

		try{
			sel = in.nextInt();
			
			stack = factory.getStack(sel);
			
		
		
			} catch (Exception e) {
				
				System.out.println("Ha ocurrido un error con la seleccion del stack");
				
			}
	
	}
	public static int stackType(){ return sel;}
	
	
	
	
}


