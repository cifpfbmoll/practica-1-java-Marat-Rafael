

import java.util.Scanner;

public class Practica_1 {

	static Scanner entrada = new Scanner(System.in);
	// declaramos escaner fuera del main para usar con todos metodos
	// esto nos obliga a declarar lo con static

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		boolean salir = false;

		try {

			do {
				System.out.println("*********************************************");
				System.out.println("Elige la opcion: ");
				System.out.println("1. leer 5 numeros, almacenar en array");
				System.out.println("2. Leer 5 numeros y mostrar en orden inverso");
				System.out.println("3. Leer 5 numeros, contar media");
				System.out.println("4. Contar cuantos caracteres tiene texto");
				System.out.println("5. Invertir texto");
				System.out.println("6. Eliminar espacios en texto");
				System.out.println("7. Concatenar dos cadenas");
				System.out.println("8. Sustituir en un texto todas vocales");
				System.out.println("9. Mostara codigo ASCII del texto");
				System.out.println("0. Salir");
				System.out.println("**********************************************");
				opcion = sc.nextInt();				
				switch (opcion) {	// switch para menu

				case 1: // 5 numeros almacenar en array
					crearArray();
					break;

				case 2: // 5 numeros del array mostrarorden inverso
					arrayInverso();
					break;

				case 3: // 5 numeros contar media
					contarMedia();
					break;

				case 4: // contar cuantos caracteres tiene cadena
					System.out.println("Escribe texto: ");
					String texto = entrada.nextLine();
					contarCaracteres(texto);
					break;

				case 5: // invertir cadena del texto
					System.out.println("Escribe texto para invertir: ");
					String text = entrada.nextLine();
					invertirTexto(text);
					break;

				case 6: // eliminar espacios de la cadena
					System.out.println("Escribe texto para borrar espacios: ");
					String textoS = entrada.nextLine();
					eliminarEspacios(textoS);
					break;

				case 7: // concatenar dos cadenas
					System.out.println("Escribe primer texto: ");
					String texto1 = entrada.nextLine();
					System.out.println("Escribe segundo texto: ");
					String texto2 = entrada.nextLine();
					concatenarCadenas(texto1, texto2);
					break;

				case 8:// sustituir vocales
					System.out.println("Escribe texto donde sustituimos vocales: ");
					String textoVocales = entrada.nextLine();
					System.out.println("Escribe letra: ");
					char letra = entrada.nextLine().charAt(0);
					sustituirVocales(textoVocales, letra);
					break;

				case 9: // pasar cada caracter del texto a ASCII
					System.out.println("Escriba texto para pasarlo al ASCII: ");
					String textoAsci = entrada.nextLine();
					mostrarAscii(textoAsci);
					break;

				case 0:// salida
					salir = true;
					break;

				default:
					System.out.println("No esta disponible esta opcion, elige entre 1 a 9 , 0 para salir");
				}

			} while (!salir);

		} catch (Exception e) {
			System.out.println("Error, solo se puede inserter los numeros");
		}

		sc.close();

	}// fin main

	// metodo para crear array de 5 numeros y lo mostramos
	public static void crearArray() {

		int numeros[] = new int[5]; // desclaramos array
		for (int i = 0; i < numeros.length; i++) { // for para pedir numeros
			System.out.println("Dame " + (i + 1) + " numero, por favor");
			int num = entrada.nextInt();
			numeros[i] = num;
		}
		System.out.print("Los numeros introducidos son: "); // mostramos numeros con un for
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}

		System.out.println();
		System.out.println();

	}// fin crearArray

	// metodo para pedir 5 numeros y mostrar en orden inversa
	public static void arrayInverso() {
		Scanner sc = new Scanner(System.in); // declaramos objeto de escaner
		int numeros[] = new int[5]; // declaramos array de 5 posiciones
		for (int i = 0; i < numeros.length; i++) { // for para pedir numeros y guardar en el array
			System.out.println("Dame " + (i + 1) + " numero, por favor");
			int num = sc.nextInt();
			numeros[i] = num;
		}
		System.out.print("Los numeros introducidos son: "); // mostramos numeros del array con un for
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();

		System.out.print("Orden inverso de los numeros introducidos: "); // mostramos odren inversa
		for (int i = 0, j = 4; i < numeros.length; i++, j--) {
			System.out.print(numeros[j] + " ");
		}
		sc.close();
		System.out.println();
		System.out.println();

	}// fin arrayInverso

	// metodo para contar media de numeros positivos , media de negativos , y
	// contar zeros
	public static void contarMedia() {
		int totalPositivos = 0; // variable para positivos
		int positivos = 0;// variable para contar cantidad de numeros positivos

		int totalNegativos = 0; // variable para negativos
		int negativos = 0; // variable para contar cantidad de numeros negativos

		int zeros = 0;// contar zeros

		Scanner sc = new Scanner(System.in); // objeto del escaner
		int numeros[] = new int[5]; // declaramos array de 5 posiciones
		for (int i = 0; i < numeros.length; i++) { // for para pedir numeros y guardar en el array
			System.out.println("Dame " + (i + 1) + " numero, por favor");
			int num = sc.nextInt();
			numeros[i] = num;

			if (num > 0) {
				// si es positivo sumamos a positivos y cantidad de positivos aumenta en uno
				totalPositivos += num;
				positivos++;
			} else if (num < 0) {
				// si es negativo sumamos a negativos y cantidad de negatvos aumenta en uno
				totalNegativos += num;
				negativos++;
			} else {
				// en otro caso es zero
				zeros++;
			}
		}
		System.out.println("Has introducido: ");// primero mostramos todos numeros introducidos con for
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
		System.out.println("Has introducido " + zeros + " zeros");

		// positivos
		// como no podemos dividir en zero , usamos if total no es zero
		if (positivos != 0) {
			System.out.println("Media de los numeros positivos es: " + (double) totalPositivos / positivos);
		} else {
			System.out.println("No has introducido ningun numero positivo");
		}
		// negativos
		// como no podemos dividir en zero, usamos if, para ver si total es zero
		if (negativos != 0) {
			System.out.println("Media de los numeros negativos es: " + (double) totalNegativos / negativos);
		} else {
			System.out.println("No has introducido ningun numero negativo");
		}
		sc.close();
		System.out.println();

	}// fin contarMedia

	// metodo que recibe parametro del texto y devuelve cantidad de caracteres
	public static void contarCaracteres(String cadena) {
		int caracteres = 0;
		for (int i = 0; i < cadena.length(); i++) {
			caracteres++;
		}
		System.out.println("Total caracteres en el texto: '" + cadena + "' es: " + caracteres);
		System.out.println();
		System.out.println();

	}// fin contarCaracteres

	// metodo para invertir texto
	public static void invertirTexto(String cadena) {
		char caracter;
		String cadenaInvertida = "";

		for (int i = 0, j = cadena.length() - 1; i < cadena.length(); i++, j--) {

			caracter = cadena.charAt(j);
			// empesando desde atras cada caracter guardamos en variable
			//
			cadenaInvertida += caracter;
			// añadimos esta variable a la cadenaInvertida
		}
		System.out.println(cadenaInvertida);
		System.out.println();
		System.out.println();

	}// fin invertirTexto

	// funcion para eliminar espacios en el texto
	public static void eliminarEspacios(String cadena) {
		char caracter;
		String cadenaFinal = "";

		for (int i = 0; i < cadena.length(); i++) {

			caracter = cadena.charAt(i);
			//
			if (caracter != 32) { // si es destinto de ASCII 32 que es espacio
				cadenaFinal += caracter;
			}
		}
		System.out.println(cadenaFinal);
		System.out.println();
		System.out.println();

	}// fin eliminarEspacios

	// metodo para concatenar dos cadenas
	public static void concatenarCadenas(String cadena1, String cadena2) {
		String cadenaUnida;
		cadenaUnida = cadena1 + cadena2;
		System.out.println(cadenaUnida);
		System.out.println();
		System.out.println();

	}// fin concatenarCadenas

	// metodo cambiar vocales
	public static void sustituirVocales(String cadena, char caracter) {
		char vocales[] = { 'a', 'e', 'i', 'o', 'u' }; // array vocales
		char caracterActual;
		String textoNuevo = "";

		for (int i = 0; i < cadena.length(); i++) { // primera for para recorer texto
			caracterActual = cadena.charAt(i); // caracter actual durante recorrido

			for (int j = 0; j < vocales.length; j++) {
				// segundo for para recorer con caracteractual array de vocales
				if (caracterActual == vocales[j]) {// si caracteractual esta en el array
					caracterActual = caracter; // cambia caracterActual por la letra
				}
			}
			textoNuevo += caracterActual;// añadimos a nueva cadena caracter por caracter
		}
		System.out.println(textoNuevo);
		System.out.println();
		System.out.println();

	}// fin sustituirVocales

	// metodo para mostrar codico ASCII del texto introducido
	public static void mostrarAscii(String cadena) {
		String cadenaAscii = "";
		char caracterActual;

		for (int i = 0; i < cadena.length(); i++) {
			caracterActual = cadena.charAt(i);
			cadenaAscii += (int) caracterActual;
			cadenaAscii += " ";

		}
		System.out.println(cadenaAscii);
		System.out.println();
	} // fin mostrarASCII

	
}// fin class

/*
 * metodos en java siempre pasa por valor, primitivos hacen una copia dentro
 * del metodo 
 * Objetos complejo ( String, Array , Integer etc - copia de
 * referencia !
 * 
 */
