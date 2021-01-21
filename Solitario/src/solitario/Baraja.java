package solitario;

import java.util.ArrayList;
import java.util.Collections;
public class Baraja{
  private ArrayList<Carta> cartas = new ArrayList<Carta>();
  public Baraja(){
    
    for(int i=1; i<=13; i++){
      cartas.add(new Carta(i, "diamantes"));
      cartas.add(new Carta(i, "picas"));
      cartas.add(new Carta(i, "corazones"));
      cartas.add(new Carta(i, "treboles"));
    }
  }

  public void imprimirBaraja(){
    for(Carta c: cartas){
      System.out.println(c);
    }
  }
  
  public void imprimirBarajaDestapada(){
    for(Carta c: cartas){
        c.destapar();
        System.out.println(c);
        c.tapar();
    }
  }

  public void agregarCartaAlFinal(Carta m){
    cartas.add(m);
  }

  public void barajar(){
    Collections.shuffle(cartas);
  }

  public Monticulo entregarCarta(){
    return cartas.remove(0);
  }

  public Monticulo entregarCarta(int i){
    return cartas.remove(i);
  }

  public void devolverCarta(Carta m){
    cartas.add(0, m);
  }

  public int cantidadCartas(){
    return cartas.size();
  }

}