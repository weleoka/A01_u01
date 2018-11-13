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


    public static void main(String[] args) {

        Kassa kassa = new Kassa();

        while (!skapaKopsumma()) {
            System.out.printf("%nKöpsumma inte giltig. Försök igen.");
        }
        System.out.printf("%nKöp registrerat.");

        while (!skapaBetalsumma()) {
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


    private static boolean skapaKopsumma() {
        System.out.printf("%nAnge ett värde för köpsumma: ");
        return kop.setKopsumma(input.nextInt());
    }


    private static boolean skapaBetalsumma() {
        System.out.printf("%nAnge ett värde för betalsumma: ");
        return kop.setBetalsumma(input.nextInt());
    }
}
