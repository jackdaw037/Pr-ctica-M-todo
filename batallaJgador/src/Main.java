import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        // Estadísticas jugador
        System.out.print("Ingresa tu nombre: ");
        String nombreJugador = sc.nextLine();

        System.out.println("\nJugador: " + nombreJugador);

        int vidaJugador = 100;
        int vidaMax = 100;
        int atkJugador = 20;
        int defJugador = 5;

        // Estadísticas enemigo
        int vidaEnemigo = 80;
        int atkEnemigo = 15;
        int defEnemigo = 3;


        System.out.println("\n--- COMBATE ---");
        boolean cb = true;

        while (cb) {
            System.out.println("1.Atacar");
            System.out.println("2.Defender");
            System.out.println("3.Estado");

            int opCombate =sc.nextInt();

            switch (opCombate) {
                case 1 :
                    if (opCombate == 1) {
                        int danyoJugador = atacar(atkJugador, defEnemigo);
                        vidaEnemigo -= danyoJugador;

                        System.out.println(nombreJugador + " ataca y causa " + danyoJugador + " de daño");
                        System.out.println("Vida enemigo: " + vidaEnemigo);


                        int danyoEnemigo = atacar(atkEnemigo, defJugador);
                        vidaJugador -= danyoEnemigo;

                        System.out.println("El enemigo ataca y causa " + danyoEnemigo + " de daño");
                        System.out.println("Tu vida: " + vidaJugador);

                        break;
                    }
                case 2:
                    int danyoRecibido = defender(atkEnemigo, defJugador);
                    vidaJugador -= danyoRecibido;

                    System.out.println(nombreJugador + " se defiende!");
                    System.out.println("El enemigo ataca y causa " + danyoRecibido + " de daño");
                    System.out.println("Tu vida: " + vidaJugador);
                    break;

                case 3:
                    if (opCombate == 3){
                        System.out.println("vida actual : "+vidaJugador+" -- Vida Max : "+ vidaMax);
                    }
            }
            if (vidaEnemigo <= 0){
                System.out.println("Derrotaste al enemigo");
                cb = false;

            }
            if (vidaJugador <= 0){
                System.out.println("Te han derrotado");
                cb = false;
            }
        }
    }

        //metodo de ataque//

    public static int atacar(int atkAtacante, int defDefensor) {
        Random rd = new Random();
        int danyoBase = atkAtacante + rd.nextInt(6); // 0–5 extra
        int danyoFinal = danyoBase - defDefensor;

        if (danyoFinal < 0) {
            danyoFinal = 0;
        }

        return danyoFinal;
    }

            //metodo de defensa//

    public static int defender(int atkEnemigo, int defJugador) {
        Random rd = new Random();

        int defensaExtra = defJugador + rd.nextInt(6);
        int danyoenEmigo = atkEnemigo + rd.nextInt(6);

        int danyoFinal = danyoenEmigo - defensaExtra;

        if (danyoFinal < 0) {
            danyoFinal = 0;
        }

        return danyoFinal;
    }
}
