package util;

import java.util.Calendar;

public class Datas {
    public static int getAnoSistema() {
        Calendar calendario = Calendar.getInstance();
        return calendario.get(Calendar.YEAR);
    }
}
