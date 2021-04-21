import player.Personaje;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Personaje jorge=new Personaje("Jorge",2,55,15,15,200);
    Personaje juan=new Personaje("Juan",2,35,20,20,200);

    Personaje.combat(jorge,juan);
        //CORREGIR METODO COMBAT
    }
}
