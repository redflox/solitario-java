package solitario;

import java.util.ArrayList;
import java.util.Collections;

public class BarajaAyuda {

    private ArrayList<Carta> cartas = new ArrayList<Carta>();

    public void imprimirBaraja() {
        for (Carta c : cartas) {
            System.out.println(c);
        }
    }

    public void agregarCartaAlFinal(Carta m) {
        m.destapar();
        cartas.add(m);
    }

    public Monticulo entregarCarta() {
        Carta x = cartas.remove(0);
        x.tapar();
        return x;
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
