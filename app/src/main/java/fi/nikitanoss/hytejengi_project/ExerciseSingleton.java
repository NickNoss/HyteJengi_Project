package fi.nikitanoss.hytejengi_project;

import java.util.ArrayList;

public class ExerciseSingleton {
    private ArrayList<Exercise> exercises;
    private static final ExerciseSingleton ourInstance = new ExerciseSingleton();

    public static ExerciseSingleton getInstance() { return ourInstance; }

    private ExerciseSingleton() {
        this.exercises = new ArrayList<Exercise>();
        exercises.add(new Exercise("Push-up", 20, "Get down on all fours, placing your hands slightly wider than your shoulders.\n" +
                "Straighten your arms and legs.\n" +
                "Lower your body until your chest nearly touches the floor.\n" +
                "Pause, then push yourself back up.\n" +
                "Repeat."));
        exercises.add(new Exercise("Abdominal crunch", 15, "Lie down on your back. Plant your feet on the floor, hip-width apart. Bend your knees and place your arms across your chest. Contract your abs and inhale.\n" +
                "Exhale and lift your upper body, keeping your head and neck relaxed.\n" +
                "Inhale and return to the starting position.\n" +
                "26.9.2019"));
        exercises.add(new Exercise("Body-weight squat", 15, "Stand with your hands on the back of your head and your feet shoulder-width apart with your feet turned out slightly to open the hip joint.\n" +
                "Lower your body until your thighs are parallel to the floor.\n" +
                "Pause, then return to the starting position.\n" +
                "Repeat."));
        exercises.add(new Exercise("Bicycle crunch", 25, "Lie on your back and bring your legs to a tabletop position. Bend your elbows, and put your hands behind your head.\n" +
                "Crunch up and bring your right elbow to your left knee, straightening your right leg.\n" +
                "Release the crunch slightly. Bend your right leg and straighten your left leg, then bring your left elbow to your right knee.\n" +
                "Repeat for the desired number of reps."));
        exercises.add(new Exercise("Burpee", 10, "Start by standing upright with your feet shoulder-width apart and your arms down at your sides.\n" +
                "With your hands out in front of you, start to squat down. When your hands reach the ground, pop your legs straight back into a pushup position.\n" +
                "Jump your feet up to your palms by hinging at the waist. Get your feet as close to your hands as you can get, landing them outside your hands if necessary.\n" +
                "Stand up straight, bringing your arms above your head, and jump.\n" +
                "This is one rep. Complete 3 sets of 10 reps as a beginner."));
    }

    public ArrayList<Exercise> getExercises(){ return this.exercises; }

    public Exercise getExercise(int i) { return exercises.get(i); }

}
