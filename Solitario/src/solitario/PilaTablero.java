package solitario;

import java.util.Iterator;
import java.util.Random;

public class PilaTablero extends Pila{

  public PilaTablero(){
    
  }

  public PilaTablero(int t){
    Random r = new Random(System.currentTimeMillis());
    for(int i = 0; i<t; i++){
      if(i==t-1){
        Carta c = (Carta) Juego.barajaJuego.entregarCarta(r.nextInt(Juego.barajaJuego.cantidadCartas()));
        c.destapar();
        cartas.push(c);
      }else{
        cartas.push(Juego.barajaJuego.entregarCarta(r.nextInt(Juego.barajaJuego.cantidadCartas())));
      }
    }
  }
  
  @Override
  public boolean recibirMonticulo(Monticulo m){
    if(m.getClass().equals(Pila.class)){
      Carta nueva = (Carta) ((Pila) m).getCartas().get(0);
      if(cartas.isEmpty()){
        if(nueva.getNumero()==13){
          cartas.push(m);
          return true;
        }
        return false;
      }
      Carta c = (Carta) cartas.peek();
      if(nueva.esNegra()!=c.esNegra()){
        if(nueva.getNumero()==c.getNumero()-1){
          Iterator i = ((Pila) m).getCartas().iterator();
          while(i.hasNext()){
            cartas.push((Carta) i.next());
          }
          return true;
        }
        return false;
      }
    }
    return false;
  }

  public Monticulo desapilar(Carta carta){
    Pila p = new PilaTablero();
    Iterator i = this.cartas.iterator();
    Carta c = (Carta) i.next();
    while(!c.equals(carta))
       c = (Carta) i.next();
    if(!c.isTapada()){
      while(i.hasNext()){
        p.cartas.push(c);
        i.remove();
        c = (Carta) i.next();
      }
      p.cartas.push(c);
      i.remove();
      return p;
    }
    return null;
  }
}