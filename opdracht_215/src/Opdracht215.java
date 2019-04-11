public class Opdracht215 {
    public static void main(String[] args) {
        int[] geboorteJaar = {1954, 1958, 1958, 1963, 1963, 1963, 1964, 1970, 1970, 1970};
        String[] geslacht = {"V", "M", "V", "m", "v", "V", "?", "v", "v", "m"};

        int aantalMannenTotaal = 0;
        int aantalVrouwenTotaal = 0;

        int loopTeller = 0;
        int maximumAantal = geboorteJaar.length;

        int hulpJaar;

        while (loopTeller < maximumAantal) {
            System.out.println("Het geboortejaar is: " + geboorteJaar[loopTeller]);
            hulpJaar = geboorteJaar[loopTeller];

            int aantalMannen = 0;
            int aantalVrouwen = 0;

            while (loopTeller < maximumAantal && geboorteJaar[loopTeller] == hulpJaar) {
                if (geslacht[loopTeller].equalsIgnoreCase("M")) {
                    aantalMannen++;
                    aantalMannenTotaal++;
                } else if (geslacht[loopTeller].equalsIgnoreCase("V")) {
                    aantalVrouwen++;
                    aantalVrouwenTotaal++;
                } else {
                    System.out.println("Onbekend geslacht: " + geslacht[loopTeller]);
                }

//                switch (geslacht[loopTeller]) {
//                    case "M": case "m": {
//                        aantalMannen++;
//                        aantalMannenTotaal++;
//                        break;
//                    }
//                    case "V": case "v": {
//                        aantalVrouwen++;
//                        aantalVrouwenTotaal++;
//                        break;
//                    }
//                    default:
//                        System.out.println("Onbekend geslacht: " + geslacht[loopTeller]);
//                }
                loopTeller++;
            }
            System.out.println("Aantal mannen: " + aantalMannen);
            System.out.println("Aantal vrouwen: " + aantalVrouwen);
        }
        System.out.println("--- Totalen ---");
        System.out.println("Aantal mannen totaal: " + aantalMannenTotaal);
        System.out.println("Aantal vrouwen totaal: " + aantalVrouwenTotaal);
    }
}
