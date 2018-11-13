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
 *  - Bättre än att returnera bool från kopkontroll vore att throw exception
 *      och låta den bubbla istället. Men det fungerar så här med.
 *
 */
public class Main {

    private static Kop kop = new Kop();
    private static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        while (!skapaKopsumma()) {
            System.out.printf("%nKöpsumma inte giltig. Försök igen.");
        }
        System.out.printf("%nKöp registrerat.");

        while (!skapaBetalsumma()) {
            System.out.printf("%nBetalsumma inte giltig. Försök igen.");
        }
        System.out.printf("%nKöp betalat.");

        if (kop.getVaxelsumma() > 0) {
            System.out.printf("%nVäxel (%d) finns at återbetala.", kop.getVaxelsumma());
            visaVaxelDetaljer();
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

    private static void visaVaxelDetaljer() {
        Kassa kassa = new Kassa(kop.getVaxelsumma());
        kassa.skriv();
    }
}
