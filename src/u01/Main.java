package u01;

import java.util.Scanner;

/**
 * Applied java for running educational material.
 *
 * main class for creating generative product and
 * provide interface for classes created for educational purposes.
 *
 *  @author  Kai Weeks
 *  För D0019N - Assignment 1 - Uppgift 1.
 *
 *  @version na
 *  @since   na
 *
 *  todo Gardera mot felinmatad data med exception handling
 *  todo Bättre än att returnera bool från köpkontroll vore att throw exception
 *  todo Implementera ArrayList för att hålla i köp (att föredra över LinkedList, p.g.a. LIFO operationer)
 *
 */
public class Main {
    private static Kop kop = new Kop(); // Programmet handlar om ett köp
    private static Scanner input = new Scanner(System.in);  // Programmet behöver indata


    /**
     * main-metoden för klassen Main.
     *
     */
    public static void main(String[] args) {

        Kassa kassa = new Kassa();  // En kassa behövs för att ge växel

        while (!skapaKopsumma()) {  // Statisk metod kallas upprepat tills den returnerar sant
            System.out.printf("%nKöpsumma inte giltig. Försök igen."); // Om föregående falsk så skriv till stdout
        }
        System.out.printf("%nKöp registrerat.");    // Köpsumman var okej. Vi kan forsätta

        while (!skapaBetalsumma()) {    // See beskrivning för förgående.
            System.out.printf("%nBetalsumma inte giltig. Försök igen."); // -||-
        }
        System.out.printf("%nKöp betalat.");    // Betalning har gjorts, lika med eller utöver Köpsumma

        int vaxel = kop.getVaxelsumma();    // Temporär variabel och deklareras för användning i metoden endast

        if (vaxel > 0) {     // Om det finns växel som måste återbetalas
            System.out.printf("%n%d växel finns att återbetala.", vaxel);
            kassa.geVaxel(vaxel);   // Kalla kassan för att räkna ut sedlar och mynt
        }

        System.out.printf("%n%nTack för köpet!");   // Allt lyckat
    }


    /**
     * Skriv ut till konsol ett meddelande och ta sedan stdin för resultat.
     * Kallar sedan setKopsumma på instans(Kop) och returnera resultat.
     *
     * @return boolean      lyckat eller inte för set-operationen
     *
     */
    private static boolean skapaKopsumma() {
        System.out.printf("%nAnge ett värde för köpsumma: ");

        return kop.setKopsumma(input.nextInt());    // Sätt stdin värde till köpinstansen, returnera rapport
    }


    /**
     * Skriv ut till konsol ett meddelande och ta sedan stdin för resultat.
     * Kallar sedan setKopsumma på instans(Kop) och returnera resultat.
     *
     * @return boolean      lyckat eller inte för set-operationen
     *
     */
    private static boolean skapaBetalsumma() {
        System.out.printf("%nAnge ett värde för betalsumma: ");

        return kop.setBetalsumma(input.nextInt());  // Sätt stdin värde till köpinstansen, returnera rapport
    }
}
