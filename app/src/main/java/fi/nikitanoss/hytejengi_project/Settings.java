package fi.nikitanoss.hytejengi_project;

public class Settings {
    private String name;
    private Class activity;


    public Settings (String name) {
        this.name = name;
    }

    public Settings (String name, Class activity) {
        this.name = name;
        this.activity = activity;
    }

    public String toString() {
        return this.name;
    }

    public Class getActivity() {
        return this.activity;
    }
}

