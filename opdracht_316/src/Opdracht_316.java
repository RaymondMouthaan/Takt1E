public class Opdracht_316 {
    public static void main(String[] args) {
        // Vul tabel met persoonsgegevens
        // <geboortedag>-<geboortemaand>-<geboortejaar>;<geslacht>;<achternaam>;<voornaam>
        String[] persoon = {
                "24-08-1954;V; Dijk, van;Maria",
                "02-03-1958;M; Groot, de;Jacob",
                "17-06-1958;V; Winters;Felicia",
                "12-01-1963;m; Swinkels;Mark",
                "31-07-1963;v; Deutekom, van ;Lilian",
                "05-11-1963;V; Jacht, van der ;Jolanda",
                "19-08-1964;?; Puffelen,van;",
                "22-05-1970;v; Dietvorst;Wilma",
                "01-06-1970;v; Boogerts,den;Ester",
                "19-09-1970;m; Konincks;Sven"
        };

        // Declareer variabelen, tellingen totaal op nul
        int aantalMannenTotaal = 0;
        int aantalVrouwenTotaal = 0;
        int aantalOnbekendTotaal = 0;

        // Initialiseer loopteller
        int loopTeller = 0;

        // Het maximum aantal keer dat geloopt moet worden
        int maximumAantal = persoon.length;

        // Een hulp variable om het geboortejaar in op te slaan
        int hulpJaar;

        // C1 = loopTeller < maximumAantal
        while (loopTeller < maximumAantal) {

            // Split regel, bepaal jaar en geslacht
            int geboorteJaar = leesVeldGeboorteJaar(persoon, loopTeller);

            // Schrijf geboortejaar
            System.out.println("Het geboortejaar is: " + geboorteJaar);

            // Bewaar geboortejaar in hulpjaar
            hulpJaar = geboorteJaar;

            // Zet tellingen van dit jaar op nul
            int aantalMannen = 0;
            int aantalVrouwen = 0;
            int aantalOnbekend = 0;

            // C2 = loopTeller < maximumAantal && geboorteJaar == hulpJaar
            while (loopTeller < maximumAantal && geboorteJaar == hulpJaar) {

                // Geslacht man, vrouw of onbekend?
                switch (leesVeldGeslacht(persoon, loopTeller)) {
                    case "M":
                    case "m": {
                        aantalMannen++; // Tel mannen dit jaar
                        aantalMannenTotaal++; // Tel mannen totaal
                        break;
                    }
                    case "V":
                    case "v": {
                        aantalVrouwen++; // Tel vrouwen dit jaar
                        aantalVrouwenTotaal++; // Tel vrouwen totaal
                        break;
                    }
                    default:
                        aantalOnbekend++; // Tel onbekend/rest dit jaar
                        aantalOnbekendTotaal++; // Tel onbekend/rest totaal
                }
                // Verhoog teller
                loopTeller++;

                // C1 = loopTeller < maximumAantal
                // deze if kan ook vervangen worden door de controle in de while op te nemen, geboorteJaar vervangen door de methode
                if (loopTeller < maximumAantal) {
                    // Split regel, bepaal jaar en geslacht
                    geboorteJaar = leesVeldGeboorteJaar(persoon, loopTeller);
                }
            }
            // Schrijf tellingen dit jaar
            System.out.println("Aantal mannen: " + aantalMannen);
            System.out.println("Aantal vrouwen: " + aantalVrouwen);
            System.out.println("Aantal onbekend: " + aantalOnbekend);
        }

        // Schrijf tellingen totaal
        System.out.println("--- Totalen ---");
        System.out.println("Aantal mannen totaal: " + aantalMannenTotaal);
        System.out.println("Aantal vrouwen totaal: " + aantalVrouwenTotaal);
        System.out.println("Aantal onbekend totaal: " + aantalOnbekendTotaal);
    }

    /**
     * Methode om uit een array met persoonsgegevens het geboortejaar terug te geven
     *
     * @param persoonsgegevens de array van persoonsgegevens
     * @param index de index van de persoon waarvan het geboortejaar terug gegeven moet worden
     * @return het geboortejaar als integer
     */
    private static int leesVeldGeboorteJaar(String[] persoonsgegevens, int index) {
        String persoon = persoonsgegevens[index];
        String strGeboorteJaar = persoon.split(";")[0].substring(6);
        int intGeboorteJaar = Integer.parseInt(strGeboorteJaar);
        return intGeboorteJaar;
    }

    /**
     * Methode om uit een array met persoonsgegevens het geslacht terug te geven
     *
     * @param persoonsgegevens de array van persoonsgegevens
     * @param index de index van de persoon waarvan het geslacht terug gegeven moet worden
     * @return het geslacht als String
     */
    private static String leesVeldGeslacht(String[] persoonsgegevens, int index) {
        String persoon = persoonsgegevens[index];
        String geslacht = persoon.split(";")[1];
        return geslacht;
    }

    // Advanced
    // deze methode combineert de functionaliteit van leesVeldGeboorteJaar en leesVeldGeslacht
    private static String leesVeld(String[] persoonsgegevens, int index, int veld) {
        String persoon = persoonsgegevens[index];

        // split1: de persoon splitsen obv ";"
        String[] split1 = persoon.split(";");
        // split2: de geboortedatum splitsen obv "-"
        String[] split2 = split1[0].split("-");

        // nieuwe array, om de persoonsgegevens samen te voegen
        String[] result = new String[6];

        // kopieer geboortedag, geboortemaand en geboortejaar naar de nieuwe array
        System.arraycopy(split2, 0, result, 0, split2.length);
        // kopieer geslacht, achternaam en voornaam (indien aanwezig) naar de nieuwe array
        System.arraycopy(split1, 1, result, 3, split1.length - 1);

        // geeft het gewenste veld terug
        return result[veld];
    }
}
