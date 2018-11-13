package u01;

/**
 * Klassen Kop motsvarar ett köp och används för att registrera
 * köpsumma och betalningsumma för att göra kontroll om ett köp kan
 * genomföras. Betalningen kan vara för liten, eller kanske växel måste ges.
 * Ett köp kan vara i status betald eller obetald.
 *
 * @author  Kai Weeks
 * För D0019N - Assignment 1 - Uppgift 1.
 *
 * @version na
 * @since   na
 */
class Kop {
    private int kopsumma;
    private int betalsumma;
    private int vaxelsumma;
    private boolean betald = false;


    /**
     * Registrerar en ny summa för ett köp.
     * Testar om kopsumman är giltig, Mer än noll
     *
     * @param kopsumma            en int med betalsumman att registrera
     *
     * @return boolean            sant om köpsumman är giltig; mer än 0
     *
     */
    public boolean setKopsumma(int kopsumma) {
        if (kopsumma > 0) {
            this.kopsumma = kopsumma;
            return true;
        }
        else
            return false;
    }

    /**
     * Registrera en ny betalning för ett köp.
     * Testa betalningen för att kontrollera att den räcker.
     *
     * @param betalning             en int med betalsumman att registrera
     *
     * @return boolean              sant om betalsumma är giltig.
     *
     */
    public boolean setBetalsumma(int betalning) {
        if (betalning > 0) {
            if (betalning >= this.kopsumma) {
                this.betalsumma = betalning;                            // Registrera betalningen.
                this.vaxelsumma = this.betalsumma - this.kopsumma;      // Räkna ut växelsumman.
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Metod som returnerar växelsumman.
     *
     * @return this.vaxelumma     int för växelsumma
     *
     */
    public int getVaxelsumma() {
        return this.vaxelsumma;
    }

}
