package enums;

import java.util.Locale;
import java.util.Random;

public enum Nation {

    POLISH(new Locale("pl_PL")),
    UKRAINIAN(new Locale("uk_UA")),
    BELARUSSIAN(new Locale("be_BY")),
    SLOVAK(new Locale("sk_SK")),
    LITHUANIA(new Locale("lt_LT")),
    LATVIANA(new Locale("lv_LV")),
    BRITISH(new Locale("en")),
    INDIAN(new Locale("en_IN")),
    CHINESE(new Locale("zh_CN")),
    VIETNAMESE(new Locale("vi_VN"));

    private final Locale locale;
    private static Random random;

    static {
        random = new Random();
    }

    Nation(Locale locale) {
        this.locale = locale;
    }

    public static Nation getRandomNation() {
        Nation[] nations = Nation.values();
        int index = random.nextInt(nations.length);
        return nations[index];
    }

    public boolean equals(Nation n) {
        return this.locale.equals(n.getLocale());
    }

    public Locale getLocale() {
        return locale;
    }


}