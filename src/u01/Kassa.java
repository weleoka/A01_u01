package u01;

import java.util.HashMap;

/**
 * Klassen Kassa räknar fram växel beroende på olika valörer.
 *
 * Valörer har ett defaultvärde eller kan sättas manuellt genom att
 * anropa konstruktorn med en array.
 *
 * todo Gör klassen till ett singleton.
 * todo Implementera ArrayList för att hålla i köp (att föredra över LinkedList, p.g.a. LIFO operationer)
 *
 * @author  Kai Weeks
 * För D0019N - Assignment 1 - Uppgift 1.
 *
 * @version na
 * @since   na
 *
 */
public class Kassa {
    private int[] valorer = {1000, 5000, 200, 100, 50, 20, 2 ,1};   // Defaultvärden för valorer
    private HashMap<Integer, Integer> hm = new HashMap<>();   // hm för att lagra växeldetaljer


    /**
     * Class constructor.
     * Låter kassan instantieras med deafultvärden för valörer.
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
     * @param valorer            en int[] med valorer som kassan ska hantera
     *
     */
    public Kassa(int[] valorer) {

        this.valorer = valorer; // Spara inkommande array som giltiga valörer
    }


    /**
     * Räknar ut växel valörer och sparar dem i en hashmap.
     *
     * @param vaxelsumma        en int med vaxelsumman att betala tillbaka
     *
     * @return hm               en hashmap med valorer och antal som motsvarar växel
     *
     */
    public HashMap<Integer, Integer> geVaxel(int vaxelsumma) {
        int i;  // inkremator
        int key = 0;   // Nyckel, alltså valör
        int value = 0; // Räknaren

        for (i = 0; i <= this.valorer.length - 1; i++) {    // Börja på index noll och fortsätt tills arreylängden är nådd
            key = this.valorer[i];  // Sätt pågående valör som nyckel
            value = 0; // Nollställ räknaren


            while (vaxelsumma - key >= 0) {    // Testa om valoren kan användas
                value++;    // Spara en förekomst av valör
                vaxelsumma -= key;  // Ränka ut resterande växelsumma (-= är en compound assignement operator)
            }

            if (value > 0) {    // Om valören förekommer som växel spara i hashmap
                hm.put(key, value);
            }
        }

        return hm;
    }
}
