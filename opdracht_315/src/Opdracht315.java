public class Opdracht315 {

    public static void main(String[] args) {
        System.out.println(filter("Hallo dit is een test text", "t"));
    }

    /**
     * Deze methode verwijderd een karakter uit een gegeven string
     * @param strIn de string waaruit het karakter wordt verwijderd
     * @param strDelKar de te verwijderen karakter
     * @return de resultaat string
     */
    private static String filter(String strIn, String strDelKar)
    {
        int i; // counter
        int intLen; // lengte van de input string
        String strKar; // karakter uit de input string die bewaard moet blijven
        String strOut; // resultaat string

        strOut = "";
        intLen = strIn.length();
        i = 0;

        while (i < intLen)
        {
            strKar = String.valueOf(strIn.charAt(i));

            if (!strKar.equals(strDelKar))
            {
                strOut = strOut + strKar;
            }

            i = i + 1;
        }
        return strOut;
    }

}
