package solitario;
public class PilaSubida extends Pila{
  @Override
  public boolean recibirMonticulo(Monticulo m){
      System.out.println("1. = "+ m.getClass()+ " 2. =  "+ Carta.class);
    if(m.getClass().equals(Carta.class)){
      Carta nueva = (Carta) m;
      if(cartas.isEmpty()){
        if(nueva.getNumero()==1){
          cartas.push(m);
          return true;
        }
        return false;
      }
      Carta c = (Carta) cartas.peek();
      if(nueva.getPalo().equals(c.getPalo())){
        if(nueva.getNumero()==c.getNumero()+1){
          cartas.push(nueva);
          return true;
        }
        return false;
      }
    }
    return false;
  }
}