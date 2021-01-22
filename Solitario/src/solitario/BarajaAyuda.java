package solitario;

import java.util.ArrayList;
import java.util.Collections;

public class BarajaAyuda {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private ArrayList<Carta> cartas = new ArrayList<Carta>();

    public void imprimirBaraja() {
        for (Carta c : cartas) {
            if(c.esNegra()){
                System.out.println(c);
            }else{
                System.out.println(ANSI_RED+c+ANSI_RESET);
                
            }
            
        }
    }

    public void agregarCartaAlFinal(Carta m) {
        m.destapar();
        cartas.add(m);
    }

    public Monticulo entregarCarta() {
        //Carta x = cartas.remove(0);
        //x.tapar();
        return cartas.remove(0);
    }

    public Monticulo entregarCarta(int i) {
        return cartas.remove(i);
    }

    public void devolverCarta(Carta m) {
        cartas.add(0, m);
    }

    public int cantidadCartas() {
        return cartas.size();
    }

}
