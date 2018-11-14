package u01;

import java.util.HashMap;   // För att skapa pekare till returnerade hm
import java.util.Scanner;   // För att ta input från användaren
import static java.lang.System.*;   // För utskrifter och input för användaren

/**
 *  Kontrollklass för exekvering.
 *
 *  Programmet inefattar 2 till klasser:
 *      - Kop (Köp) som representerar ett köp, med köpsumma och betalsumma
 *      - Kassa som representerar återbatalning av växel
 *
 *  Alla programmutskrifter och hantering av användarinput görs i Main.
 *
 *  Varning för import av java.lang.System.* som kan förorena namespace, men
 *  i det här fallet gör koden renare.
 *
 *
 *  @author  Kai Weeks
 *  För D0019N - Assignment 1 - Uppgift 1.
 *
 *  @version na
 *  @since   na
 *
 *  todo Gardera mot felinmatad data med exception handling
 *  todo Bättre än att returnera bool från köpkontroll vore att throw exception
 *  todo Spara köp under Kassa och se till att Kassa returnerar växel för senaste köpet i listan.
 *  todo Consider using the singleton pattern for Kassa
 *
 */
public class Main {
    private static Kop kop = new Kop(); // Programmet handlar om ett köp
    private static Scanner input = new Scanner(in);  // Programmet behöver indata


    /**
     * main-metoden för klassen Main.
     *
     */
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm;   // Hashmap referens på returnerat värde från Kassa
        Kassa kassa = new Kassa();  // En kassa behövs för att ge växel

        while (!skapaKopsumma()) {  // Statisk metod kallas upprepat tills den returnerar sant
            out.printf("%nKöpsumma inte giltig. Försök igen."); // Om föregående falsk så skriv till stdout
        }
        out.printf("%nKöp registrerat.");    // Köpsumman var okej. Vi kan forsätta

        while (!skapaBetalsumma()) {    // See beskrivning för förgående
            out.printf("%nBetalsumma inte giltig. Försök igen."); // -||-
        }
        out.printf("%nKöp betalat.");    // Betalning har gjorts, lika med eller utöver Köpsumma

        int vaxel = kop.getVaxelsumma();    // Temporär variabel och deklareras för användning i metoden endast

        if (vaxel > 0) {     // Om det finns växel som måste återbetalas
            out.printf("%n%d växel finns att återbetala.", vaxel);
            hm = kassa.geVaxel(vaxel);   // Invokera geVaxel metoden för kassan för att räkna ut sedlar och mynt
            hm.forEach((Integer k, Integer v) ->    // Gå igenom alla key-value par som finns i hashmap och kör en lambda med dem
                out.printf("%n%skr = %sst", k, v)
            );
        }
        out.printf("%n%nTack för köpet!");   // Allt lyckat
    }


    /**
     * Skriv ut till konsol ett meddelande och ta sedan stdin för resultat.
     * Kallar sedan setKopsumma på instans(Kop) och returnerar resultat.
     *
     * @return boolean      lyckat eller inte för set-operationen
     *
     */
    private static boolean skapaKopsumma() {
        out.printf("%nAnge ett värde för köpsumma: ");

        return kop.setKopsumma(input.nextInt());    // Sätt stdin värde till köpinstansen, returnera rapport
    }


    /**
     * Skriv ut till konsol ett meddelande och ta sedan stdin för resultat.
     * Kallar sedan setBetalsumma på instans(Kop) och returnerar resultat.
     *
     * @return boolean      lyckat eller inte för set-operationen
     *
     */
    private static boolean skapaBetalsumma() {
        out.printf("%nAnge ett värde för betalsumma: ");

        return kop.setBetalsumma(input.nextInt());  // Sätt stdin värde till köpinstansen, returnera rapport
    }
}
