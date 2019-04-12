public class Opdracht135 {
    public static void main(String[] args) {
        int waardeAuto = 21428;
        int bijtellingsPercentage = 14;
        float bijtelling;

        bijtelling = berekenBijtelling(waardeAuto, bijtellingsPercentage);
        System.out.println("Bijtelling per jaar: " + bijtelling);
        System.out.println("Bijtelling per maand: " + bijtelling / 12);

        bijtelling = berekenNettokosten(bijtelling);
        System.out.println("Nettokosten auto per jaar: " + bijtelling);
        System.out.println("Nettokosten auto per maand: " + bijtelling / 12);
    }

    private static float berekenBijtelling(int waardeAuto, int bijtellingsPercentage) {
        int bijTelling;
        bijTelling = waardeAuto * bijtellingsPercentage / 100;
        return bijTelling;
    }

    private static float berekenNettokosten(float bruttoKosten) {
        float berekenBelasting = bruttoKosten * 42 / 100;
        return berekenBelasting;
    }
}
