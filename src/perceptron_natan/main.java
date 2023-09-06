/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perceptron_natan;


/**
 *
 * @author FATEC ZONA LESTE
 */
public class main {

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();

        perceptron.treinar();

        int epocas = perceptron.getCount();
        System.out.println("Treinamento concluído em " + epocas + " épocas.");

        int entrada1 = 1;
        int entrada2 = 0;
        int resultado = perceptron.executar(entrada1, entrada2);
        System.out.println("Resultado para entrada (" + entrada1 + ", " + entrada2 + "): " + resultado);
    }
}