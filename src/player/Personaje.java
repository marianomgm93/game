/*Class con el personaje y sus metodos de:
*   atacar
*   recibir daño
*   combatir
*/

package player;

import java.util.Random;

public class Personaje {
    private String name;
    private int dmg;
    private int ha;
    private int max_hp;
    private int hp;
    private int cash;
    private String estado="VIVO";

    public Personaje() {
    }

    public Personaje(String name, int dmg, int ha, int max_hp, int hp, int cash) {
        this.name = name;
        this.dmg = dmg;
        this.ha = ha;
        this.max_hp = max_hp;
        this.hp = hp;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getHa() {
        return ha;
    }

    public void setHa(int ha) {
        this.ha = ha;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int attack(){
        Random rdm=new Random();

        int dado=rdm.nextInt(100)+1;
        if(dado<=this.ha){
            if(dado<3){
                int critico=((rdm.nextInt(10)+1)+dmg)*(rdm.nextInt(3)+1);
                System.out.println("GOLPE CRITICO:"+critico);
                return critico;

            }else {
                int golpe=(rdm.nextInt(10)+1)+dmg;
                System.out.println("GOLPE:"+golpe);
                return golpe;
            }

        }else if(dado>=98){
            int pifia=(rdm.nextInt(dmg)+1)/2;
            hp=hp-pifia;
            System.out.println(name+" se lastimó intentando golpear, ha perdido "+pifia + "puntos de vida");
            return 0;
        }else{
            System.out.println(name+" ha fallado estrepitosamente");
            return 0;
        }


    }
    public void dmgTaken(int danho){
        hp=hp-danho;
        if(danho>0)System.out.println(name+" ha recibido "+danho+" puntos de daño, ahora tiene "+hp+" puntos de vida");
        if (hp<0){
            estado="MUERTO";
            System.out.println(name+" HA MUERTO!");
        }
    }
    public static void combat(Personaje uno, Personaje dos){
        do{

            System.out.println(uno.name+" intenta golpear!");
            dos.dmgTaken(uno.attack());
            if (uno.estado.equals("VIVO") && dos.estado.equals("VIVO")){
                System.out.println(dos.name+" intenta golpear!");
                uno.dmgTaken(dos.attack());
            }
        }while(uno.estado.equals("VIVO") && dos.estado.equals("VIVO"));
    }


}
