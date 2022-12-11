package fi.nikitanoss.hytejengi_project;

import java.util.ArrayList;

public class ExerciseSingleton {
    private ArrayList<Exercise> exercises;
    private static final ExerciseSingleton ourInstance = new ExerciseSingleton();

    public static ExerciseSingleton getInstance() { return ourInstance; }

    private ExerciseSingleton() {
        this.exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Push-ups", 20, "Get down on all fours, placing your hands slightly wider than your shoulders.\n" +
                "Straighten your arms and legs.\n" +
                "Lower your body until your chest nearly touches the floor.\n" +
                "Pause, then push yourself back up.\n" +
                "Repeat."));
    }

    public ArrayList<Exercise> getExercises(){ return this.exercises; }

    public Exercise getExercise(int i) { return exercises.get(i); }

}
