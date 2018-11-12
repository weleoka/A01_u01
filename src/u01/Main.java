package u01;

import java.util.Scanner;

public class Main {

    private static Kop kop = new Kop();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        skapaKopsumma();
        skapaBetalsumma();

        while (!kop.getStatus()) {
            System.out.println("Köp inte betalat. Försök igen.");
            skapaBetalsumma();
        }

        System.out.println("Köp betalat.");
        if (kop.getVaxelSumma() > 0) {
            System.out.println("Växel finns at återbetala.");
            visaVaxelDetaljer();
        }
        else kop.slutfor();
    }

    private static void skapaKopsumma() {
        System.out.println("Ange ett värde för köpsumma: ");
        kop.setKopSumma(input.nextInt());
        System.out.println("Nytt köp registrerat.");
    }
    private static void skapaBetalsumma() {
        System.out.println("Ange ett värde för betalsumma: ");
        kop.setBetalsumma(input.nextInt());
    }
    private static void visaVaxelDetaljer() {
        Kassa kassa = new Kassa(kop.getVaxelSumma());
        kassa.skriv();
    }

}
