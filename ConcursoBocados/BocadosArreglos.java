import java.io.*;

public class BocadosArreglos{
	
	static 	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static	PrintStream out = System.out;


   	public static void main(String[] args)throws java.io.IOException{
   	
   	int cantParticipantes = 10;
   	String [] nombres;//Este arreglo contendra los nombres participantes
   	double [] pesoBocados;//Este arreglo tendra el peso mayor de cada participante
   	int [] bocados;//Este arreglo guarda los pesos de los bocados de un participante
   	
  	double pesoParticipante;// Guarda el peso Mayor de un participante   	
 
   	int ganador; //guarda el indice del concursante ganador
   	int cantBocados;//Esta variable contendra la cantidad de bocados
 
   	String nombre; //Esta variable contendra los nombres
   	
   	int numParticipante=0;// Contador que lleva el control del numero de participante
   	String opcion="";
   	
   	out.println("Deme la cantidad de bocados por participante");//solicita los nombre de los participantes
	cantBocados=Integer.parseInt(in.readLine());
	
	nombres = new String[cantParticipantes];
	
	bocados = new int[cantBocados];//Arreglo que tiene el tamaño segun al cantidad de bocados por participante
	pesoBocados = new double[cantParticipantes];//Se define que solo son 10 participantes como mucho
		
	/*1.Llenar bocados 
	 *2. Calcular peso Total
	 *3. Obtener indice mayor
	 */
	 
	 while(opcion.equals("x")== false){
	 	
    	out.println("Deme el nombre del concursante");//solicita los noombre de los participantes
		nombre=(in.readLine());//guarda el nombre 
		nombres[numParticipante] = nombre;// guarda el nombre en el arrglo nombres en la posicion correspondiente a numParticipantes
		
		
	 	llenarBocados(bocados);//Invocacion: Se encarga de solicitar los bocados de un participante
	 	pesoParticipante = calcularPesoTotal(bocados);//Calcula el peso mayor de un participante
	 	pesoBocados[numParticipante] = pesoParticipante;//guarda el peso mayor de un participante en el arreglo que almacena todos los pesos mayores de cada respectivo concursante
	 
	 	
	 	out.println("desea continuar x:no s:si");//solicita si desea salir o continuar
		opcion=(in.readLine());//guarda la opcion en dicha variable
		
		numParticipante++;
	 }
	 
	 ganador = obtenerGanador(pesoBocados);// Invocacion que se encarga de: llamar a la rutina encargada de obtener el peso Mayor y por ende el ganador
	 
	 out.println("El nombre del ganador es: " + nombres[ganador] + "y su bocado mayor fue de: " + pesoBocados[ganador] + "el indice del participante corresponde a: " + ganador );
   	}
   	
   	static void llenarBocados(int [] pbocados)throws java.io.IOException{
   	
   		int bocado=0;//variable que guarda cada bocado
   		int totalBocados;// variable que se encarga de guarda la suma de todos los bocados
   		
   		for(int i=0; i<pbocados.length; i++ ){
   			out.println("Deme el bocado #" + (i+1));
   			bocado = Integer.parseInt(in.readLine());
   			pbocados[i] = bocado;
   		}  		
   			
   	}
   	
   	static double calcularPesoTotal(int [] pbocados) throws java.io.IOException{
   		
   		int bocado;
   		double pesoMayor=0;// Variable que guardara el bocado Mayor
   	
   	
   		for(int i=0; i<pbocados.length; i++){
   			bocado = pbocados[i];
   			
   			if(bocado > pesoMayor){
   				
   				pesoMayor = bocado;   				
   				
   			}
   			
   		}
   		return pesoMayor;
   		
   	}
   	

	static int obtenerGanador(double [] ppesosBocados){
		double pesoMayor=0;
		int ganador=0;
		
		for(int i=0; i<ppesosBocados.length; i++){
			if(pesoMayor < ppesosBocados[i]){
				pesoMayor = ppesosBocados[i];
				ganador = i;
				
			}
		}
		return ganador;
	}
	
}