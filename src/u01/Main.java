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
 *  TODO Lista
 *  - Gardera mot felinmatad data med exception handling.
 *  - Bättre än att returnera bool från köpkontroll vore att throw exception
 *      och låta den bubbla istället. Men det fungerar så här med.
 *  - Implementera ArrayList för att hålla i köp (att föredra över LinkedList, p.g.a. LIFO operationer)
 *
 */
public class Main {

    private static Kop kop = new Kop();
    private static Scanner input = new Scanner(System.in);


    /**
     * main-metoden för klassen Main.
     *
     */
    public static void main(String[] args) {

        Kassa kassa = new Kassa();      // En kassa behövs för att ge växel

        while (!skapaKopsumma()) {      // Statisk metod kallas upprepat tills den returnerar sant
            System.out.printf("%nKöpsumma inte giltig. Försök igen."); // Om föregående falsk så skriv till stdout
        }
        System.out.printf("%nKöp registrerat.");    // Köpsumman var okej. Vi kan forsätta.

        while (!skapaBetalsumma()) {    // See beskrivning för förgående.
            System.out.printf("%nBetalsumma inte giltig. Försök igen.");
        }
        System.out.printf("%nKöp betalat.");

        int vaxel = kop.getVaxelsumma();

        if (vaxel > 0) {
            System.out.printf("%n%d växel finns att återbetala.", vaxel);
            kassa.geVaxel(vaxel);
        }

        System.out.printf("%n%nTack för köpet!");
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
        return kop.setKopsumma(input.nextInt());
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
        return kop.setBetalsumma(input.nextInt());
    }
}
