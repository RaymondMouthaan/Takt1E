import java.io.*;

public class Opdracht325 {
    public static void main(String[] args) throws IOException {

        // Open invoerbestand (persoon.txt)
        BufferedReader reader = new BufferedReader(new FileReader("opdracht_325/src/persoon.txt"));

        // Open uitvoerbestand (output.txt)
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        // Declareer variabelen, tellingen totaal op nul
        int aantalMannenTotaal = 0;
        int aantalVrouwenTotaal = 0;
        int aantalOnbekendTotaal = 0;

        // Initialiseer loopteller
        int loopTeller = 0;

        // Lees volgende regel
        String regel = reader.readLine();

        // Een hulp variable om het geboortejaar in op te slaan
        int hulpJaar;

        // C1 = loopTeller < maximumAantal
        while (regel != null) {

            // Split regel, bepaal jaar en geslacht
            int geboorteJaar = leesVeldGeboorteJaar(regel);
            String geslacht = leesVeldGeslacht(regel);

            // Schrijf geboortejaar
            System.out.println("Het geboortejaar is: " + geboorteJaar);
            // Schrijf geboortejaar naar bestand
            writer.write("Het geboortejaar is: " + geboorteJaar);
            writer.newLine();

            // Bewaar geboortejaar in hulpjaar
            hulpJaar = geboorteJaar;

            // Zet tellingen van dit jaar op nul
            int aantalMannen = 0;
            int aantalVrouwen = 0;
            int aantalOnbekend = 0;

            // C2 = loopTeller < maximumAantal && geboorteJaar == hulpJaar
            while (regel != null && geboorteJaar == hulpJaar) {

                // Geslacht man, vrouw of onbekend?
                switch (geslacht) {
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

                regel = reader.readLine();

                // C1 = loopTeller < maximumAantal
                // deze if kan ook vervangen worden door de controle in de while op te nemen, geboorteJaar vervangen door de methode
                if (regel != null) {
                    // Split regel, bepaal jaar en geslacht
                    geboorteJaar = leesVeldGeboorteJaar(regel);
                    geslacht = leesVeldGeslacht(regel);
                }
            }
            // Schrijf tellingen dit jaar
            System.out.println("Aantal mannen: " + aantalMannen);
            System.out.println("Aantal vrouwen: " + aantalVrouwen);
            System.out.println("Aantal onbekend: " + aantalOnbekend);

            // Schrijf tellingen dit jaar naar bestand
            writer.write("Aantal mannen: " + aantalMannen);
            writer.newLine();
            writer.write("Aantal vrouwen: " + aantalVrouwen);
            writer.newLine();
            writer.write("Aantal onbekend: " + aantalOnbekend);
            writer.newLine();
        }

        // Schrijf tellingen totaal
        System.out.println("--- Totalen ---");
        System.out.println("Aantal mannen totaal: " + aantalMannenTotaal);
        System.out.println("Aantal vrouwen totaal: " + aantalVrouwenTotaal);
        System.out.println("Aantal onbekend totaal: " + aantalOnbekendTotaal);

        // Schrijf tellingen totaal naar bestand
        writer.write("--- Totalen ---");
        writer.newLine();
        writer.write("Aantal mannen totaal: " + aantalMannenTotaal);
        writer.newLine();
        writer.write("Aantal vrouwen totaal: " + aantalVrouwenTotaal);
        writer.newLine();
        writer.write("Aantal onbekend totaal: " + aantalOnbekendTotaal);

        reader.close();
        writer.close();
    }

    /**
     * Methode om uit een array met persoonsgegevens het geboortejaar terug te geven
     *
     * @param persoonsgegevens de array van persoonsgegevens
     * @return het geboortejaar als integer
     */
    private static int leesVeldGeboorteJaar(String persoonsgegevens) {
        String strGeboorteJaar = persoonsgegevens.split(";")[0].substring(6);
        int intGeboorteJaar = Integer.parseInt(strGeboorteJaar);
        return intGeboorteJaar;
    }

    /**
     * Methode om uit een array met persoonsgegevens het geslacht terug te geven
     *
     * @param persoonsgegevens de array van persoonsgegevens
     * @return het geslacht als String
     */
    private static String leesVeldGeslacht(String persoonsgegevens) {
        String geslacht = persoonsgegevens.split(";")[1];
        return geslacht;
    }

}
