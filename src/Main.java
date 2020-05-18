import java.util.Scanner;

public class Main {
    static public Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scanner.nextLine();
        String[] glas = {"а", "и", "о", "у", "ы", "э"};
        String[] glas2 = {"a", "i", "o", "u", "y", "e"};
        String[] soglas = {"б", "в", "г", "д", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х"};
        String[] soglas2 = {"b", "v", "g", "d", "z", "ĵ", "k", "l", "m", "n", "p", "r", "s", "t", "f", "h"};
        String[] yotir = {"е", "ё", "ю", "я"};
        String[] yotir2 = {"e", "o", "u", "a"};
        String[] ship = {"ж", "ц", "ч", "ш", "щ"};
        String[] ship2 = {"ž", "c", "ć", "š", "ś"};
        str = str.toLowerCase();
        for (int i = 0; i < yotir.length; i++) {
            str = chg(str, "ь" + yotir[i], "ĵ" + yotir2[i]);
            str = chg(str, "ъ" + yotir[i], "ĵ" + yotir2[i]);
        }
        for (int i = 0; i < yotir.length; i++) {
            str = chg(str, " " + yotir[i], " ĵ" + yotir2[i]);
            for (int j = 0; j < yotir.length; j++) {
                str = chg(str, yotir[i] + yotir[j], yotir[i] + "ĵ" + yotir2[j]);
            }
        }
        for (int i = 0; i < glas.length; i++) {
            for (int j = 0; j < yotir.length; j++) {
                str = chg(str, glas[i] + yotir[j], glas[i] + "ĵ" + yotir2[j]);
            }
            for (int j = 0; j < soglas.length; j++) {
                str = chg(str, soglas[j] + glas[i], soglas2[j] + glas2[i]);
            }
            for (int j = 0; j < ship.length; j++) {
                str = chg(str, ship[j] + glas[i], ship2[j] + glas2[i]);
            }
            str = chg(str, glas[i], glas2[i]);
        }
        for (int i = 0; i < soglas.length; i++) {
            for (int j = 0; j < yotir.length; j++) {
                str = chg(str, soglas[i] + yotir[j], soglas2[i] + "j" + yotir2[j]);
            }
            str = chg(str, soglas[i], soglas2[i]);
        }
        for (int i = 0; i < ship.length; i++) {
            str = chg(str, ship[i], ship2[i]);
        }
        str = chg(str, "ь", "j");
        str = chg(str, "ъ", "j");
        System.out.println(str);
    }

    static public String chg(String sStr, String x, String y) {
        StringBuilder str = new StringBuilder(sStr);
        if (x.length() == 1)
            for (int i = 0; i < str.length(); i++) {
                String zap = str.substring(i, i + 1);
                if (zap.equals(x))
                    str.replace(i, i + 1, y);
            }
        else
            for (int i = 1; i < str.length(); i++) {
                String zap = str.substring(i - 1, i + 1);
                if (zap.equals(x))
                    str.replace(i-1, i + 1, y);
            }
        return new String(str);
    }
}