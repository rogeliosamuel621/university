package paracaidista;


import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        double masa, resistencia, gravedad = 9.8;
        Scanner Keyboard = new Scanner(System.in);
        //Introduccion de datos

        //Peso
        do{
            System.out.println("Inserte el peso del paracaidista");
            masa = Keyboard.nextFloat();
            if(masa < 1){
                System.out.println("Inserte un valor valido");
            }
        }while(masa < 1);

        //Resistencia
        do{
            System.out.println("Inserte la coeficiencia de la resistencia del aire");
            resistencia = Keyboard.nextFloat();
            if(masa < 1){
                System.out.println("Inserte un valor valido");
            }
        }while(resistencia < 1);
        System.out.println("-----------------------------|-----------------------------"
                +"\n|            t               |           v                |"
                +"\n-----------------------------|-----------------------------");
        //calculo de velocidad
        for(int i=0; i<10; i++){
            System.out.println("             " + (i+1) +"               |      "
                    +((gravedad*masa)/resistencia)*(1-Math.pow(2.7, (-(resistencia/masa)*(i+1))))
            +"\n-----------------------------|-----------------------------");
        }

    }
}