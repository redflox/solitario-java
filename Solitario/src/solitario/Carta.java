package solitario;

public class Carta implements Monticulo{
  private int numero;
  private String palo;
  private boolean tapada;

  public Carta(int numero,String palo){
    this.numero = numero;
    this.palo = palo;
    this.tapada = true;
  }

  public boolean esNegra(){
    if(palo=="picas"||palo=="treboles")
      return true;
    return false;
  }

  @Override
  public String toString(){
    if (tapada){
      return "Carta";
    }
    String num = numero + "";
    if(numero == 1)
      num="A";
    if(numero == 11)
      num="J";
    if(numero == 12)
      num="Q";
    if(numero == 13)
      num="K";
    return num+" de "+palo;
  }

  public boolean isTapada(){
    return tapada;
  }
  
  public void tapar(){
    tapada = true;
  }

  public void destapar(){
    tapada = false;
  }

  public int getNumero(){
    return numero;
  }

  public String getPalo(){
    return palo;
  }

  @Override
  public boolean recibirMonticulo(Monticulo m){
    return false;
  }
}