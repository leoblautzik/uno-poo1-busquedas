import java.util.Scanner;
import java.util.*; 
public class Busqueda{

    public int busquedaSecuencial(int[] arreglo, int datoAbuscar){
        boolean encontrado=false;
        int i=0;
        int pos=-1;
        while(!encontrado && i<arreglo.length){
            if(datoAbuscar==arreglo[i]){
                encontrado=true;
                pos = i;
            }
            i++;
        }
        return pos;    
    }

    /**
     *Precondicion: el arreglo debe estar ordenado. 
     *
     *
     *
     */
    public int busquedaBinaria(int [] arreglo, int datoAbuscar){
        int inicio=0;
        int fin=arreglo.length-1;
        int medio;

        while(inicio<=fin){
            medio = (inicio+fin)/2;

            if(arreglo[medio]==datoAbuscar)
                return medio;

            if(arreglo[medio] < datoAbuscar)
                inicio=medio+1;

            if(arreglo[medio] > datoAbuscar)
                fin=medio-1;
        }    
        return -1;
    }

    /**
     *busqueda binaria recursiva usando recursividad indirecta
     *
     */
    public int busquedaBinariaConRecursividad(int [] arreglo, int valorAbuscar){

        return busquedaBinariaRecursiva(arreglo, valorAbuscar, 0, arreglo.length-1);

    }

    /**
     * busqueda binaria recursiva
     */
    public int busquedaBinariaRecursiva(int [] arreglo, int valorAbuscar, int inicio, int fin){
        if(inicio <= fin){
            int medio = (inicio+fin)/2;
            if(arreglo[medio]==valorAbuscar)
                return medio;
            if(arreglo[medio]<valorAbuscar)
                return busquedaBinariaRecursiva(arreglo, valorAbuscar, medio+1, fin);
            if(arreglo[medio]>valorAbuscar)
                return busquedaBinariaRecursiva(arreglo, valorAbuscar, inicio, medio-1);
        }
        return -1;
    }

    public static void main (String[] args){
        int valorAbuscar; 
        int [] numeritos = {2,4,6,12,9,0,6,5,78,45,32,45,-1, 5,-55,56};
        int [] ordenados = {2,4,6,12,9,28,45,52,54,58,78,88,90};
        //                  0 1 2  3 4  5  6  7  8  9 10 11 12 
        Scanner tecladito = new Scanner(System.in);
        System.out.println("Ingrese el valor a buscar");    
        valorAbuscar = tecladito.nextInt(); 
        tecladito.close();

        Busqueda bus = new Busqueda();

        System.out.println(bus.busquedaSecuencial(numeritos, valorAbuscar));
        System.out.println(bus.busquedaBinaria(ordenados, valorAbuscar));
        System.out.println(bus.busquedaBinariaConRecursividad(ordenados, valorAbuscar));
        System.out.println(Arrays.binarySearch(ordenados, valorAbuscar));
    }


}

