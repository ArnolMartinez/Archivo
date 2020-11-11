package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

       Scanner entrada=new Scanner(System.in);
        int opc=1;
        while (opc==1){
            System.out.println("Seleccione una opcion");
            System.out.println("1.Crear Archivos");
            System.out.println("2.Escribir en Archivos");
            System.out.println("3.Leer Archivos");
            System.out.println("4.Eliminar Archivos");
            System.out.println("5.buscar");
            opc= entrada.nextInt();
            switch (opc){
                case 1:
                    crear();
                    break;
                case 2:
                    Escribir();
                    break;
                case 3:
                    leer();
                    break;
                case 4:
                    Eliminar();
                    break;
                case 5:
                    buscar();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
            System.out.println("Presione 1 para continuar/ 2 para salir");
            System.out.println("Para salir ingrese 2");
            opc=entrada.nextInt();
        }

    }

    public static  void crear() throws IOException {
        Scanner info=new Scanner(System.in);
        System.out.println("Desea crear un directorio para este archivo (1=si/2=no)");
        int opc=info.nextInt();
        String d;
        info.nextLine();

        if (opc==1){
         d=directorios();
            String h=".txt";
            System.out.println("Ingrese el nombre del archivo");
            String nombre=info.nextLine();
            String y=d+"\\"+nombre+h;
            File archivo=new File(y);

            try {
                boolean a=archivo.createNewFile();
                if(archivo.exists()){
                    System.out.println("El archivo se creo correctamente");
                }

            }
            catch (IOException e){
                System.out.println("El archivo no se pudo crear"+e);
            }
           }
        else{
            System.out.println("Ingrese el nombre del archivo");
            String nombre=info.nextLine();
            String h=".txt";
            String y=nombre+h;
            File archivo=new File(y);
              try {
                boolean a=archivo.createNewFile();
                if(archivo.exists()){
                    System.out.println("El archivo se creo correctamente");
                }

            }
            catch (IOException e){
                System.out.println("El archivo no se pudo crear"+e);
            }
        }

        }
    public static void Eliminar(){
        Scanner entrada=new Scanner(System.in);
        String t=Carpetas();
        File eliminar=new File(t);
        if (eliminar.delete()){
            System.out.println("Archivo eliminado");
        }
        else{
            System.out.println("Error al eliminar el archivo");
        }
    }
    public static void leer(){
        Scanner entrada=new Scanner(System.in);
        String t=Carpetas();

        File leer=new File(t);
        try {
            Scanner sc=new Scanner(leer);
            while (sc.hasNextLine()){
                String lectura=sc.nextLine();
                System.out.println(lectura);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static  String directorios()  {
        Scanner info=new Scanner(System.in);
        String d;
            System.out.println("Cual es el nombre para el directorio");
        d=info.nextLine();
        File directorio=new File(d);
        directorio.mkdir();
        return d;

    }
    public static void  Escribir() throws IOException {
        Scanner a=new Scanner(System.in);
        String c=Carpetas();
                FileWriter escritura= new FileWriter(c,true);
        //PrintWriter agregar=new PrintWriter(escritura);
         boolean f=false;
String cerrar="t";
         while(f!=true){
             System.out.println("Nombre:");
             String texto=a.nextLine();
             System.out.println("Apellido:");
             String texto2=a.nextLine();

             if(texto.equals("t")){
                 System.out.println("Adios");
                 f=true;
             }
             else{
                 escritura.write(texto+" "+texto2+"\n");
             }

         }
          escritura.close();

    }
/*
    public static void buscarPalabra() {

        Scanner a=new Scanner(System.in);
                File archivo=new File("arc.txt");
        int lineasTotales=0;
        int totalCoincidencias=0;
        System.out.println("ingrese palabra");
        String palabra=a.nextLine();
        try {

            // SI EXISTE EL ARCHIVO
            if(archivo.exists()) {
                // ABRE LECTURA DEL ARCHIVO
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                // LINEA LEIDA
                String lineaLeida;
                // MIENTRAS LA LINEA LEIDA NO SEA NULL
                while((lineaLeida = leerArchivo.readLine()) == "\n") {
                    lineasTotales = lineasTotales + 1;
                    String[] palabras = lineaLeida.split(" ");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equals(palabra)) {
                           System.out.println(lineaLeida);
                            System.out.println("En la linea: " + lineasTotales + " se encontro la palabra a buscar: " + palabra);
                            System.out.println("");
                            break;
                        }
                    }
                }
            }
            System.out.println("En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscar2() {
        Scanner  entrada=new Scanner(System.in);
        String y=Carpetas();
        try {
            FileReader fr = new FileReader(y);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            System.out.println("Ingrese el nombre que desea visualizar ");
            String buscar=entrada.nextLine();
            while((linea = br.readLine()) != null){
                String[] b=new String[2];
                b= linea.split(" ");
                if (b[0].equals(buscar)) {
                    System.out.println(linea);
                    System.out.printf("Nombre: %s Apellido: %s \n",b[0],b[1]);
                    break;
                }

            }

            fr.close();
        }
        catch(Exception e) {
            System.out.println("Excepcion leyendo fichero "+ y + ": " + e);
        }
    }
 */
    public static String Carpetas() {
        Scanner entrada=new Scanner(System.in);
        System.out.println("El archivo esta en un directorio?");
        System.out.println("1=Si/2=No");
        int n=entrada.nextInt();
        entrada.nextLine();
        String t;
        if(n==1){
            System.out.println("Ingrese el nombre del directorio");
            String directorio=entrada.nextLine();
            System.out.println("Cual es el nombre del archivo");
            String d=entrada.nextLine();
            t=directorio+"\\"+d+".txt";
        }
        else {
            System.out.println("Cual es el nombre del archivo");
            String d=entrada.nextLine();
            t=d+".txt";
        }
        return t;
    }
    public static void buscar(){
        Scanner entrada=new Scanner(System.in);
        String t=Carpetas();
        System.out.println("Que palabra desea buscar");
        String texto=entrada.nextLine();
        File leer=new File(t);
        try {
            Scanner sc=new Scanner(leer);

            while (sc.hasNextLine()){
                String[] palabras=new String[2];
                String lectura=sc.nextLine();
                palabras=lectura.split(" ");
                if(texto.equals(palabras[0])){
                    System.out.printf("Nombre: %s Apellido: %s \n",palabras[0],palabras[1]);
                }
                }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}




