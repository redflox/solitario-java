package solitario;

import java.util.Stack;

public abstract class Pila implements Monticulo {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    protected Stack<Monticulo> cartas = new Stack<Monticulo>();

    public Monticulo desapilar() {
        return cartas.pop();
    }

    public Monticulo entregarCarta() {
        return cartas.peek();
    }

    public int size() {
        return cartas.size();
    }

    public Stack<Monticulo> getCartas() {
        return cartas;
    }

    public void mostrarPila() {
        for (Monticulo m : cartas) {
            System.out.println(((Carta) m));
        }
    }

    public void mostrarPila(int i) {
        try {
            if ((!((Carta) cartas.get(i)).esNegra()) && !((Carta) cartas.get(i)).isTapada()) {
                if (cartas.get(i).toString().length() == 13) {
                    System.out.print("" + ANSI_RED + cartas.get(i) + ANSI_RESET + "\t | ");
                } else if (cartas.get(i).toString().length() == 14) {
                    System.out.print("" + ANSI_RED + cartas.get(i) + ANSI_RESET + "\t | ");
                } else if (cartas.get(i).toString().length() > 14) {
                    System.out.print("" + ANSI_RED + cartas.get(i) + ANSI_RESET + "\t | ");
                } else {
                    System.out.print("" + ANSI_RED + cartas.get(i) + ANSI_RESET + "\t\t | ");
                }
            } else {
                if (cartas.get(i).toString().length() == 13) {
                    System.out.print(cartas.get(i) + "\t | ");
                } else if (cartas.get(i).toString().length() == 14) {
                    System.out.print("" + cartas.get(i) + "\t | ");
                } else if (cartas.get(i).toString().length() > 14) {
                    System.out.print("" + cartas.get(i) + "\t | ");
                } else {
                    System.out.print("" + cartas.get(i) + "\t\t | ");
                }
            }

        } catch (Exception e) {
            System.out.print("" + "\t\t\t | ");
        }

    }

    public void mostrarPila1(int i) {
        try {

            System.out.print(cartas.get(i).toString().length() + "|");

        } catch (Exception e) {
            System.out.print("|");
        }

    }

    public Stack<Monticulo> getPila() {
        return cartas;
    }

}
