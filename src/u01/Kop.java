package u01;

/**
 * Klassen Kop motsvarar ett köp och används för att registrera
 * köpsumma och betalningsumma för att göra kontroll om ett köp kan
 * genomföras. Betalningen kan vara för liten, eller kanske växel måste ges.
 *
 * @author  Kai Weeks
 * För D0019N - Assignment 1 - Uppgift 1.
 *
 * @version na
 * @since   na
 */
class Kop {
    private int kopsumma;   // Summan av det som ska köpas
    private int betalsumma; // Summan av det som betalas
    private int vaxelsumma; // Summan av växel när uträkningen har gjorts


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
        if (kopsumma > 0) { // Kassan ger inte ut pengar. Endast plussvärden giltiga.
            this.kopsumma = kopsumma;   // Spara värdet under instansen
            return true;    // Rapportera lyckat resultat
        }
        else
            return false;   // Eller, rapportera misslyckat resultat
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

        if (betalning > 0) {    // Är det en giltig betalning?

            if (betalning >= this.kopsumma) {   // Räcker betalningen?
                this.betalsumma = betalning;    // Jo, registrera betalningen
                this.vaxelsumma = this.betalsumma - this.kopsumma;  // Räkna ut växelsumman
                return true;    // Rapportera lyckat resultat
            }
            else
                return false;   // Eller, rapportera misslyckat resultat
        }
        else
            return false;   // Ogiltig betalning.
    }


    /**
     * Metod som returnerar växelsumman.
     *
     * @return this.vaxelumma     int för växelsumma
     *
     */
    public int getVaxelsumma() {

        return this.vaxelsumma; // Ge rapport om sparat värde.
    }

}
