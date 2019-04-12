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

        int maximumAantal = persoon.length;

        int hulpJaar;

        // C1 = loopTeller < maximumAantal
        while (loopTeller < maximumAantal) {

            // Split regel, bepaal jaar en geslacht
            int geboorteJaar = Integer.parseInt(leesVeld(persoon, loopTeller, 2));

            // Schrijf geboortejaar
            System.out.println("Het geboortejaar is: " + geboorteJaar);

            // bewaar geboortejaar in hulpjaar
            hulpJaar = geboorteJaar;

            // zet tellingen van dit jaar op nul
            int aantalMannen = 0;
            int aantalVrouwen = 0;
            int aantalOnbekend = 0;

            // C2 = loopTeller < maximumAantal && geboorteJaar == hulpJaar
            while (loopTeller < maximumAantal && geboorteJaar == hulpJaar) {

                // Geslacht man, vrouw of onbekend?
                switch (leesVeld(persoon, loopTeller, 3)) {
                    case "M":
                    case "m": {
                        // Tel mannen dit jaar
                        aantalMannen++;
                        // Tel mannen totaal
                        aantalMannenTotaal++;
                        break;
                    }
                    case "V":
                    case "v": {
                        // Tel vrouwen dit jaar
                        aantalVrouwen++;
                        // Tel vrouwen totaal
                        aantalVrouwenTotaal++;
                        break;
                    }
                    default:
                        // Tel onbekend/rest dit jaar
                        aantalOnbekend++;
                        // Tel onbekend/rest totaal
                        aantalOnbekendTotaal++;
                }
                // Verhoog teller
                loopTeller++;

                // C1 = loopTeller < maximumAantal
                if (loopTeller < maximumAantal) {
                    // Split regel, bepaal jaar en geslacht
                    geboorteJaar = Integer.parseInt(leesVeld(persoon, loopTeller, 2));
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

    private static String leesVeld(String[] persoonsgegevens, int index, int veld) {
        String persoon = persoonsgegevens[index];

        // split
        String[] split1 = persoon.split(";");
        String[] split2 = split1[0].split("-");

        String[] array = new String[6];

        System.arraycopy(split2, 0, array, 0, split2.length);
        System.arraycopy(split1, 1, array, 3, split1.length - 1);

        return array[veld];
    }

}
