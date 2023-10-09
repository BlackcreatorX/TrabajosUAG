package granja;

import java.util.Scanner;

public class Granja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		String direccion;
		String numero;
		double num1, num2;

		// VARIBALES

		/*
		 * //ADQUIRIR DATOS E IMPRIMIR
		 * Scanner scanf = new Scanner(System.in);
		 * 
		 * System.out.println("dame el nombre de la granja");
		 * 
		 * nombre=scanf.nextLine();
		 * 
		 * System.out.println("El nombre de la granja es: "+nombre);
		 * 
		 * 
		 * 
		 * Scanner scandir = new Scanner(System.in);
		 * 
		 * System.out.println("dame la direccion de la granja");
		 * 
		 * direccion=scandir.nextLine();
		 * 
		 * System.out.println("La direccion de la granja es: "+direccion);
		 * 
		 * 
		 * 
		 * Scanner scannum = new Scanner(System.in);
		 * 
		 * System.out.println("dame el numero de la grnaja");
		 * 
		 * numero=scannum.nextLine();
		 * 
		 * System.out.println("El numero de la granja es: "+numero);
		 */

		System.out.println("danos el numero 1");

		Scanner scannum = new Scanner(System.in);
		num1 = scannum.nextDouble();
		System.out.println("danos el numero 2");

		Scanner scannum2 = new Scanner(System.in);
		num2 = scannum2.nextDouble();

		suma(num1, num2);
		res(num1, num2);
		div(num1, num2);
		mul(num1, num2);

	}

	public static double suma(double num1, double num2) {

		return num1 + num2;

	};

	public static double res(double num1, double num2) {

		return num1 - num2;

	};

	public static double div(double num1, double num2) {

		return num1 / num2;

	};

	public static double mul(double num1, double num2) {

		return num1 * num2;

	};

}

/*
 * codig viejo
 * Scanner scanner = new Scanner (System.in);
 * 
 * scanner.nextLine();
 * 
 * 
 * Scanner pepe = new Scanner (System.in);
 * pepe.nextLine()
 */