package projectpackage.i18n;

/**
 * Created by Lenovo on 17.02.2017.
 */
public enum WebLocale { en, ru;
    private String locale;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
