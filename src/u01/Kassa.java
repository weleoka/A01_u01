package u01;

/**
 * Klassen Kassa räknar fram växel beroende på olika valörer.
 *
 * todo Valorer som ska returneras kan hållas i array och inkrementeras istället för att bara skrivas ut var och en för sig.
 * todo Gör klassen till ett singleton.
 *
 * @author  Kai Weeks
 * För D0019N - Assignment 1 - Uppgift 1.
 *
 * @version na
 * @since   na
 *
 */
public class Kassa {
    private int[] valorer = {1000, 5000, 200, 100, 50, 20, 2 ,1};


    /**
     * Class constructor.
     *
     */
    public Kassa() {}


    /**
     * Class constructor.
     * Låter ett specifikt set med valorer sättas för kassan.
     *
     * todo Kontrollera att arrey har giltig data
     * todo Se till att array är sorterad
     *
     * @param valorer            en int[] med valorer som kassan ska hantera.
     *
     */
    public Kassa(int[] valorer) {

        this.valorer = valorer; // Spara inkommande array som giltiga valörer.
    }


    /**
     * Räknar ut växel valörer och skriver ut dem.
     *
     * todo Se till att ingen skrivning till stdout görs här. Endast logik och sparande i den här klassen.
     *
     * @param vaxelsumma         en int med vaxelsumman att betala tillbaka
     *
     */
    public void geVaxel(int vaxelsumma) {

        for (int i = 0; i <= this.valorer.length - 1; i++) {

            if (vaxelsumma - this.valorer[i] >= 0) {    // Testa om valoren är passar.
                vaxelsumma = vaxelsumma - this.valorer[i];
                System.out.printf("%nKöparen får tillbaka: %s", this.valorer[i]);
                i--;        // får samma valör plats igen?
            }
        }
    }
}
