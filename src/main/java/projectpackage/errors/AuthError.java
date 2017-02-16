package projectpackage.errors;

/**
 * Created by Lenovo on 16.02.2017.
 */
public enum AuthError {NoError, IncorrectCredentials;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
