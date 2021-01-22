package solitario;

import java.util.Scanner;
import java.util.Stack;

public class Juego {

    private Monticulo[] tablero;
    private Monticulo[] subida;
    private BarajaAyuda barajaAyuda = new BarajaAyuda();
    public static Baraja barajaJuego = new Baraja();
    public boolean jugando = true;

    public Juego() {
        barajaJuego.barajar();
        generarMonticulos();
        empezarElJuego();
    }

    public void generarMonticulos() {
        tablero = new Monticulo[7];
        for (int i = 1; i < 8; i++) {
            tablero[i - 1] = new PilaTablero(i);
        }
        subida = new Monticulo[4];
        for (int i = 0; i < 4; i++) {
            subida[i] = new PilaSubida();
        }
        //llenarlos
    }

    public void empezarElJuego() {
        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        System.out.println("SOLITARIO");
        int opc = 0;
        while (jugando) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            mostrarMonticulos();
            System.out.println("___________________________________");
            System.out.println("0 Para salir.");
            System.out.println("1 Hacer intercambio.");
            System.out.println("2 Mostrar carta de la baraja.");
            System.out.println("3 Mostrar baraja destapada.");
            System.out.println("___________________________________");
            System.out.println("");

            System.out.print("Opcion: ");
            opc = entradaEscaner.nextInt();
            System.out.println("___________________________________");
            System.out.println("");
            switch (opc) {
                case 0: //salir del juego
                    jugando = false;
                    break;
                case 1: // hacer intercambios
                    System.out.println("0.De tablero a tablero:");
                    System.out.println("1.De tablero a palo:");
                    System.out.println("2.De baraja a tablero:");
                    System.out.println("3.De baraja a palo:");
                    int op = entradaEscaner.nextInt();

                    switch (op) {
                        case 0:
                            System.out.print("DE TABLERO: ");
                            int opc1 = entradaEscaner.nextInt();
                            ((Pila) tablero[opc1]).mostrarPilaEnumerada();
                            System.out.print("DESDE QUE CARTA DESEA MOVER: ");
                            int opc10 = entradaEscaner.nextInt();
                            Carta cartaPivote = (Carta) ((Pila) tablero[opc1]).getMonticulo(((Pila) tablero[opc1]).size() - opc10);

                            System.out.print("A TABLERO: ");
                            int opc2 = entradaEscaner.nextInt();
                            ((PilaTablero) tablero[opc2]).recibirMonticulo(((PilaTablero) tablero[opc1]).desapilarPro(cartaPivote));

                            break;
                        case 1:
                            System.out.print("DE TABLERO: ");
                            int opc3 = entradaEscaner.nextInt();
                            System.out.print("A PALO: ");
                            int opc4 = entradaEscaner.nextInt();

                            break;
                        case 2:
                            Carta c = (Carta) barajaAyuda.entregarCarta();
                            System.out.println("MI CARTA: " + c);
                            System.out.print("A TABLERO: ");
                            int opc6 = entradaEscaner.nextInt();

                            Pila p = new PilaTablero();
                            p.push(c);

                            if (!((Pila) tablero[opc6]).recibirMonticulo(p)) {
                                System.out.println("entro!!");
                                barajaAyuda.devolverCarta(c);
                            }
                            break;
                        case 3:
                            System.out.print("DE BARAJA: ");
                            int opc7 = entradaEscaner.nextInt();
                            System.out.print("A PALO: ");
                            int opc8 = entradaEscaner.nextInt();

                            break;
                        default:
                            System.out.println("opcion invalida");
                            break;
                    }
                    break;
                case 2:
                    if (barajaAyuda.cantidadCartas() > 0) {
                        barajaJuego.agregarCartaAlFinal((Carta) barajaAyuda.entregarCarta());
                    }
                    barajaAyuda.agregarCartaAlFinal((Carta) barajaJuego.entregarCarta());
                    break;
                case 3:
                    barajaJuego.imprimirBarajaDestapada();
                    break;
                default: // opcion invalida
                    System.out.println("opcion invalida");
                    break;
            }
        }
    }

    public void mostrarMonticulos() {// INCIAR JUEGO
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.print("Baraja: ");
        barajaAyuda.imprimirBaraja();
        System.out.println("");
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________");

        destaparUltimaCartaDeLosTableros();
        imprimirTablero(subida, "Palos completos 1-4", "SUBIDA");
        imprimirTablero(tablero, "Palos tablero 1-7", "TABLERO");

    }

    public void imprimirTablero(Monticulo[] tablero, String titulo, String column) {
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(titulo.toUpperCase());
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________________________________");

        //saber que tablero tiene mas tamaño para imprimir
        int tamañoMasGrandeTablero = 0;
        for (int i = 0; i < tablero.length; i++) {
            if (((Pila) tablero[i]).size() > tamañoMasGrandeTablero) {
                tamañoMasGrandeTablero = ((Pila) tablero[i]).size();
            }
        }
        //imprimir titulo de cada tablero
        for (int y = 0; y < tablero.length; y++) {
            System.out.print(column + " " + y + "\t\t | ");
        }
        System.out.println("");
        //Imprimir tablero como matriz
        for (int i = 0; i < tamañoMasGrandeTablero; i++) {

            for (int y = 0; y < tablero.length; y++) {
                ((Pila) tablero[y]).mostrarPila(i);
            }
            System.out.println("");
        }
    }

    private void destaparUltimaCartaDeLosTableros() {
        for (Monticulo tablero1 : tablero) {
            PilaTablero pilaAux = (PilaTablero) tablero1;
            if (((Carta) pilaAux.entregarCarta()).isTapada()) {
                ((Carta) pilaAux.entregarCarta()).destapar();
            }
        }
    }
}
