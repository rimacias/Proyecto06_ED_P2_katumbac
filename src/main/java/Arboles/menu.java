
package Arboles;


import com.mycompany.p_grupo06.App;
import data.DataManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author juand
 */
public class menu {
    /*
    public static void main(String[] args) {
        
        //Carga del archivo de los animales con sus caracteristicas
        DataManager dm = new DataManager(App.pathArchivoRespuestas);
        putQuestionNodes();
       
    }
    public static void Display(BinaryTree<String> bt, int N){
        System.out.println("Ingrese si o no");
        Stack<BinaryTree<String>> pila= new Stack<>();
        System.out.println(bt.getRootContent());
        Scanner sc=new Scanner(System.in);
        String answer1=sc.nextLine().toLowerCase();
        if(answer1.equalsIgnoreCase("si")){
            pila.push(bt.getLeft());
        }
        if(answer1.equalsIgnoreCase("no")){
            pila.push(bt.getRight());
        }
        if(N==1){
            pila.pop().showLeaf();
        }
        while(N>1){
            BinaryTree<String> arbol=pila.pop();
            
            System.out.println(arbol.getRootContent());
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if(arbol.isLeaf()){
                System.out.println("Estabas pensando en un: "+arbol.getRootContent());
           
            }
            if(N==1 && !arbol.isLeaf()){
                System.out.println("hojas");
                arbol.showLeaf();
                
            }else if (answer.equalsIgnoreCase("SI") && arbol.getLeft()!=null){
                pila.push(arbol.getLeft());
            
            }else if(answer.equalsIgnoreCase("NO") && arbol.getRight()!=null){
                pila.push(arbol.getRight());
            }else{
                System.out.println("no es posible Determinar");
                System.exit(0);
            }
            --N;
        }
        if(pila.size()==1){
            System.out.print("Posiblemente estes pensando en un: ");
            pila.pop().showLeaf();     
        }
              
    }
    
    ///menu recibe el arbol cargado y el tamano del arbol  que se obtiene con arbol.countLevelRecursive -1
    public static void menu(BinaryTree t,int i){
        int N = 0;
        int options;
        boolean flag=true;
        System.out.println(" JUEGO -- > ¿En qué animal estás pensando? <--");
        System.out.println("Piensa en un animal");
        System.out.println(">>>>>>>Preguntas a responder <<<<<<<"
                + "\nRecuerda que puedes hacer maximo de ->"+i+" preguntas");
        
       
        boolean continua = false;
        Scanner input= new Scanner(System.in);
        do {
            try {
                System.out.print("Ingrese en cuántas preguntas quisiera que sea adivinado su animal: \n>");
                
                N= input.nextInt();
                while(N>i  ){
                    System.out.print("El numero supera el maximo de preguntas, Ingrese un valor dentro del rango\n>");
                    //Scanner input2= new Scanner(System.in);
                    N= input.nextInt();
                }
                System.out.print("Estas Listo\n1. Start\n2. salir\n>");
                Scanner inputOpt= new Scanner(System.in);
                options=inputOpt.nextInt();

                switch(options){
                    case 1:
                        Display(t,N);

                        flag=false;
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Opcion Invalida\n3");

                }
            } catch (InputMismatchException ex) { //le informamos al usuario que debe ingresar un entero obligatoriamente.
                System.out.println("Debe ingresar obligatoriamente un número entero.");
                input.next();
                continua = true;
            }
        } while (continua);
        
    }
    
    //Agregado 06082022
    public static void putQuestionNodes(){
        //Cantidad de preguntas
        int n = 0;
        int contadorNodo = 0;
        
        int nivel = 0;
        int contador = 0;
        BufferedReader br = null;
        
        //Linea de prueba agregado 06082022
        
        Queue<BinaryTree<String>> queue = new LinkedList<>();
        
        //Constructor vacio
        BinaryTree<String> bt = new BinaryTree<>();
        try{
            
            br = new BufferedReader(new FileReader(App.pathFileQuestions));        
            String line = br.readLine();
            
            
            if(bt == null){
            //System.out.println("No tiene nada");
            }
            
            while(line != null){
                
                if(n == 0){
                    bt.setRootContent(line);
                    queue.offer(bt);
                    n++;
                    line = br.readLine();
                    continue;
                }

                int nodosHojas = (int) Math.pow(2, n);
                             
                while(contadorNodo < nodosHojas){

                    BinaryTree temp = queue.poll();
                    if(temp.getLeft() == null){
                        temp.setLeft(new BinaryTree(line));
                        queue.offer(temp.getLeft());
                        contadorNodo++;

                    }
                    if(temp.getRight() == null){
                        temp.setRight(new BinaryTree(line));
                        queue.offer(temp.getRight());
                        contadorNodo++;
                    }
                                           
                }
                contadorNodo = 0;
                n++;
                nivel++;
                line = br.readLine();
                
            }          

        }catch(IOException e){   
            System.out.println("Archivo no encontrado");
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        respuestaPorNivel(bt);
        menu(bt,bt.countLevelsRecursive()-1);//por las respuestas no son preguntas
        
    }
    
    private static BinaryTree<String> respuestaPorNivel(BinaryTree<String> bt){    
  
        //mapa donde estan como clave los animales y como valor su respuestas a caracterisiticas en preguntas
        Map<String, List<String>> animalsChar = DataManager.animalsResponses;
        
        Stack<BinaryTree<String>> pila = new Stack<>();
        

        pila.push(bt);
        for(Map.Entry<String, List<String>> entry : animalsChar.entrySet()){
            List<String> values= entry.getValue();  

            for(int i=0; i<values.size(); i++){    

                BinaryTree<String> temp = pila.pop();
                
                if(values.get(i).equalsIgnoreCase("no") && temp.getRight() != null){
                    pila.push(temp.getRight());
                }
                if(values.get(i).equalsIgnoreCase("si") && temp.getLeft() != null){
                    pila.push(temp.getLeft());
                }
                if(values.get(i).equalsIgnoreCase("no") && (temp.getRight() == null)){

                    temp.setRight(new BinaryTree<>(entry.getKey()));

                    pila.push(bt);
                }

                if(values.get(i).equalsIgnoreCase("si") && (temp.getLeft() == null)){
                    

                    temp.setLeft(new BinaryTree<>(entry.getKey()));  
                    pila.push(bt);
                    
                }
                
            }
        }

        return pila.peek();

    }*/

}