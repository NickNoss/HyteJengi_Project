package fi.nikitanoss.hytejengi_project;

import java.util.ArrayList;

public class GlobalSettings {
    private ArrayList<Settings> settings;
    private static final GlobalSettings ourInstance = new GlobalSettings();

    public static GlobalSettings getInstance() {
        return ourInstance;
    }

    private GlobalSettings() {
        this.settings = new ArrayList<Settings>();
        /*settings.add(new Settings("My Profile", "));*/
        settings.add(new Settings("Main Page"));
        settings.add(new Settings("Exercises"));
        settings.add(new Settings("Logout"));
    }

    public ArrayList<Settings> getSettings() {
        return this.settings;
    }

    public Settings getSetting(int i) {
        return settings.get(i);
    }
}
