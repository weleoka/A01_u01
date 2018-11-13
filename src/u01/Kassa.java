package u01;

/**
 * Klassen kassa jobbar med att räkna fram olika valörer
 * för att återbetala som växel.
 *
 * TODO valorer som ska returneras kan hållas i array och inkrementeras istället för att bara skrivas ut var och en för sig.
 *
 * TODO klassen kassa skulle vara bättre att inte instansiera för varje betalning. ändra från konstruktor till setMetod.
 *
 * @author  Kai Weeks
 * För D0019N - Assignment 1 - Uppgift 1.
 *
 * @version na
 * @since   na
 */
public class Kassa {

    private int vaxelsumma;
    private int[] valorer = {1000, 5000, 200, 100, 50, 20, 2 ,1};

    /**
     * Class constructor.
     *
     * @param vaxelsumma            en int med vaxelsumman att betala tillbaka
     *
     */
    public Kassa(int vaxelsumma) {
        this.vaxelsumma = vaxelsumma;
    }

    public void skriv() {
        System.out.println(this.valorer.length);
        for (int counter = 0; counter <= this.valorer.length - 1; counter++)
            if (this.vaxelsumma - this.valorer[counter] >= 0) {
                this.vaxelsumma = this.vaxelsumma - this.valorer[counter];
                System.out.printf("%nKöparen får tillbaka: %s", this.valorer[counter]);
                counter--;
            }
    }
}
