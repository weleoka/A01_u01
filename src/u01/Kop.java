package u01;

/**
 * Klassen Kop motsvarar ett köp och används för att registrera
 * köpsumma och betalningsumma för att göra kontroll om ett köp kan
 * genomföras, om betalningen är för liten, eller kanske om växel krävs.
 * Ett köp kan vara i status betald eller obetald.
 *
 * @author  Kai Weeks
 * @version 1.0
 * @since   2018-11-20
 */
public class Kop {
    private int summa;      // värdet för köpsumman.
    private int betalSumma;
    private int vaxelSumma;
    private boolean betald = false;


    /**
     * Registrerar en ny summa för ett köp.
     *
     * @param kopsumma            en int med betalsumman att registrera
     *
     */
    public void setKopSumma(int kopsumma) {
        this.summa = kopsumma;
    }


    /**
     * Registrera en ny betalning för ett köp. Testa betalningen
     * för att kontrollera att den räcker, och om det blir växel över.
     *
     * Variabeln betald blir sann om betalningen är för stor eller
     * precis rätt, men kvarstår falskt om betalningen är för liten.
     *
     *
     * @param betalning             en int med betalsumman att registrera
     *
     */
    public void setBetalsumma(int betalning) {
        this.betalSumma = betalning;                // Registrera betalningen.
        this.vaxelSumma = betalning - this.summa;   // Räkna ut växelsumman.

        if (this.vaxelSumma < 0) {                  // Betalningen är för liten.
            this.betald = false;
        }
        else       // Betalningen räcker. Den kan vara för stor eller exakt rätt.
            this.betald = true;
    }


    /**
     * Kontrollera status på ett köp och återge textbeskrivning av den.
     *
     * @return this.betald          en boolean för betalningsstatus
     *
     */
    public boolean getStatus() {
        return this.betald;
    }


    /**
     * Get metod för att kontrollera växelsumma.
     *
     * @return this.betaldSumma     int för växelsumma
     *
     */
    public int getVaxelSumma() {
        return this.vaxelSumma;
    }


    /**
     * Ett köp är slutfört när betalning har gjorts och eventuell växel returnerats.
     * Den här metoden skriver ut tack när köpet genomförts.
     *
     */
    public void slutfor() {
        if (!this.betald) {
            this.betald = true;
            System.out.println("Tack för köpet!");
        }
        else
            System.out.println("Köpet är redan slutfört!");
    }
}
