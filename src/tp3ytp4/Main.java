package tp3ytp4;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long numero1 ;
		long numero2 ;
		long resultado;
		
		Scanner leerlong = new Scanner(System.in);	
		
		System.out.println("\n** TP3 ** \nIngrese dos numeros y averiguaremos si son coprimos\n\nIngrese el primer numero");
		numero1  = leerlong.nextLong();
		
		System.out.println("\nIngrese el segundo numero");
		numero2  = leerlong.nextLong();
		
		resultado = mcd(numero1,numero2);
		
		if (resultado == 1){
			System.out.println("\nLos numeros son coprimos! ");
		}else {
			System.out.println("\nLos numeros NO son coprimos.");
			System.out.println("Su máximo comun divisor es " + resultado);
		}
}

	
public static long  mcd(long a,long b) 
	{
		if (b == 0) 
			return a; 
		else 
			return mcd(b, a%b);
		}
}