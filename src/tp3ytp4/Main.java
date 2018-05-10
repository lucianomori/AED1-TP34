package tp3ytp4;
import java.util.Scanner;


public class Main {

	static int elementos ;
	
	static final int A = 48271;
	static final int M = 2147483647;
	static final int Q = M / A;
	static final int R = M % A;
	
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
	
	
		long semilla ;
		int generador;
		Scanner leerInt = new Scanner(System.in);	
		System.out.println("\n** TP4a ** \nGenerador de numeros pseudo aleatorios\n\nIngrese la cantidad de elementos");
    	elementos = leerInt.nextInt();
      	System.out.println("\nIngrese un numero entero como semilla" );
		semilla = leerInt.nextLong();
	    System.out.println("\nIngrese el tipo de generador.\n1 para Vonn Newmann (cuadrado medio).\n2 para Congruencial");
		generador = leerInt.nextInt();
				
		if (generador == 1) {
		  System.out.println("\nGenerando " + elementos + " elementos por método de Cuadrado Medio. La semilla es " + semilla + "\n" );
		  generadorVonnNewmann(elementos,semilla);
		}else {
	      System.out.println("\nGenerando " + elementos + " elementos por congruencial. La semilla es " + semilla + "\n");
   			generadorCongruencial(elementos, (int) semilla);
	    }
		System.out.println("\n** TP4b ** \nIngrese la semilla para generar 100 numeros con los dos métodos generadores.");
		semilla = leerInt.nextLong();
		elementos = 100;
	    System.out.println("\nGenerando " + elementos + " elementos por método de Cuadrado Medio. La semilla es " + semilla + "\n" );
	  	generadorVonnNewmann(elementos,semilla);
	    System.out.println("\nGenerando " + elementos + " elementos por congruencial. La semilla es " + semilla + "\n");
 		generadorCongruencial(elementos, (int) semilla);
	    leerInt.close();
}

	public static int generadorCongruencial(int elem, int sem) {
      int res = A * (sem % Q) - R * (sem / Q);
 	  if (res < 0 ) {
		 res = res + M - 1;
          }
      if (elem > 0) {
    	  int tmpres = res/100;
    	  tmpres = res - (tmpres * 100);
    	  System.out.println("Congruencial elemento " + ( elementos - elem + 1) + " = " + tmpres);
      	  generadorCongruencial(elem-1,res); 
       }
      return res;
      }


public static long generadorVonnNewmann(int elem, long sem) {
  long res = sem * sem; 		  
  if (elem > 0) {
	   String resStr =  String.valueOf(res); 
	   if (resStr.length() > 2){ 
		  resStr = resStr.substring((int) resStr.length()/2, (int) (resStr.length()/2) + 2);
		  }
	   if ((res == 1) && (sem != res)){
		   System.out.println("\nVonnNewmann se ha generado un desbordamiento en el elemento " + ( elementos - elem + 1)  + " no se puede continuar.");
		   elem = 0;
	       }else {
		   System.out.println("\nVonnNewmann elemento " + ( elementos - elem + 1) + " = " + resStr);
		   res = generadorVonnNewmann(elem-1,res);
	       }	  	
       }
  return res;
  }


public static long  mcd(long a,long b) {
	if (b == 0) 
	  return a; 
	else 
	  return mcd(b, a%b);
	}


}
