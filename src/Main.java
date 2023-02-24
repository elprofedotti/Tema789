import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        //DAR VUELTA UNA CADENA
        String cadena="Hola mundo";
        String anedac="";

        for(int c=cadena.length()-1;c>=0;c--){
            anedac+=cadena.charAt(c);
        }
        System.out.println("Damos vuelta una cadena");
        System.out.println("Cadena original: -->"+cadena);
        System.out.println("Cadena 'alveres' -->"+anedac);
        System.out.println("------------------------");

        //recorrer un array unidimensional de Strings
        String array[]={"Matias", "Federico","Heloise","Dotti"};
        System.out.println("Recorriendo un array unidimensional de String");

        for(String arr:array){
            System.out.println(arr);
        }
        System.out.println("------------------------");
        System.out.println("Recorriendo un array bidimensional de enteros, mostramos posicion y valor");
        int arrayBid[][]=new int[2][2];
        arrayBid[0][0]=1;
        arrayBid[0][1]=2;
        arrayBid[1][0]=3;
        arrayBid[1][1]=4;

        for (int i=0;i<arrayBid.length;i++){
            for (int j=0;j<arrayBid[i].length;j++){
                System.out.println("Posicion--> ["+i+"]["+j+"] Valor-->"+arrayBid[i][j]);
            }
        }
        System.out.println("------------------------");
        System.out.println("Ahora vamos con un Vector");
        Vector<String> vector=new Vector();
        vector.add("Matias");
        vector.add("Heloise");
        vector.add("Madhav");
        vector.add("Semilla");
        vector.add("Micaela");
        vector.remove(1);
        vector.remove(1);

        for (String vec : vector)System.out.println(vec);
        System.out.println("------------------------------");
        System.out.println("QUE PASA SI UN VECTOR CON CAPACIDAD POR DEFAULT LO UTILIZAMOS PARA CONTENER" +
                "1000 ELEMENTOS???");
        System.out.println(">>>>>>>>");
        System.out.println("la capacidad por defecto es 10, si agregraramos 1000 elementos, iria \n" +
                        "aumentando doblando su tamaño, 10, 20, 40, 80, etc... cada vez que hace esto\n" +
                        "significa una copia del vector, para generar el nuevo, esto llega un momento \n" +
                        "q no es optimo... si sabemos que el tamapo sera cerca de los 1000 elementos,\n" +
                        "sera mejor iniciarlizarlo con esa capacidad. y que si se pasa, el incremento no sea el \n" +
                        "doble, sino un 25% por ejemplo.");
        System.out.println("------------------------------");
        ArrayList<String> arraylist = new ArrayList<>();
        LinkedList<String> linkedlist = new LinkedList<>();
        arraylist.add("Heloise");
        arraylist.add("Madhav");
        arraylist.add("Semilla");
        arraylist.add("Micaela");

        for (String arra : arraylist)linkedlist.add(arra);
        System.out.println("Recorro el arraylist");
        for (String arra : arraylist) System.out.println(arra);
        System.out.println("Recorro la linkedlist");
        for (String arra : linkedlist) System.out.println(arra);
        System.out.println("------------------------------");
        System.out.println("CREO ARRAYLIST NUMERICO Y LO RELLENO DEL 1 AL 10");
        ArrayList<Integer> arraNumerico = new ArrayList<>();
        for (int i=0;i<=10;i++){
            arraNumerico.add(i);
        }

        System.out.println("lo recorro chequeando los numeros pares y los elimino del array, quedandome solo los impares:");

        //recorro el array y chequeo el modulo, si es 0 es paro, o sea chau, eliminado...
        for(int i=0; i<arraNumerico.size();i++) if (arraNumerico.get(i)%2==0) arraNumerico.remove(i);

        for (int nume:arraNumerico) System.out.println(nume);
        System.out.println("------------------------------");

        System.out.println("AHORA CREO UNA FUNCION QUE DIVIDA PRO CERO.");
        try{
            DividePorCero(500,0);
        }catch(ArithmeticException e){
            System.out.println("Esto no puede hacerse"+e.getMessage());
        }finally{
            System.out.println("Demo de codigo");
        }
        System.out.println("------------------------------");
        //a traves de la funcion copiar, que recibe dos archivos, fileIn y fileOut, copiare lo de fileIn en fileOut
        System.out.println("Llamare a la funcion copiar, que recibe dos archivos, y los copia.....");
        InputStream fileIn=null;
        PrintStream fileOut=null;
        try{
            fileIn = new FileInputStream("C:/pruebas/original.txt");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            fileOut = new PrintStream("C:/pruebas/copia.txt");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        copiar(fileIn,fileOut);


    }

    private static void copiar(InputStream fileIn, PrintStream fileOut) {
        try {
            byte []datos= fileIn.readAllBytes();
            fileOut.write(datos);
            System.out.println("Se copiaron con exito los archivos");
            fileOut.close();
            fileIn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void DividePorCero(int numeroa, int numerob) throws ArithmeticException{
        int resultado=numeroa/numerob;
        System.out.println(resultado);
    }
}

/*      Sorpréndenos creando un programa de tu elección que utilice InputStream, PrintStream, excepciones, un HashMap y
                 un ArrayList, LinkedList o array.*/