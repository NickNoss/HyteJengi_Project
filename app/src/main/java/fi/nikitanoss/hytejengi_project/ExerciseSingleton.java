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
                "Inhale and return to the starting position.\n"));
        exercises.add(new Exercise("Body-weight squat", 15, "Stand with your hands on the back of your head and your feet shoulder-width apart with your feet turned out slightly to open the hip joint.\n" +
                "Lower your body until your thighs are parallel to the floor.\n" +
                "Pause, then return to the starting position.\n" +
                "Repeat."));
        exercises.add(new Exercise("Bicycle crunch", 25, "Lie on your back and bring your legs to a tabletop position. Bend your elbows, and put your hands behind your head.\n" +
                "Crunch up and bring your right elbow to your left knee, straightening your right leg.\n" +
                "Release the crunch slightly. Bend your right leg and straighten your left leg, then bring your left elbow to your right knee.\n" +
                "Repeat."));
        exercises.add(new Exercise("Burpee", 10, "Start by standing upright with your feet shoulder-width apart and your arms down at your sides.\n" +
                "With your hands out in front of you, start to squat down. When your hands reach the ground, pop your legs straight back into a pushup position.\n" +
                "Jump your feet up to your palms by hinging at the waist. Get your feet as close to your hands as you can get, landing them outside your hands if necessary.\n" +
                "Stand up straight, bringing your arms above your head, and jump.\n" +
                "This is one rep."));

        exercises.add(new Exercise("Standing quad stretch", 5, "Stand behind a chair with your legs about shoulder-width apart. Put one hand on the chair for balance.\n" +
                "On the opposite side, lift your foot behind you and grab it with your free hand, keeping your bent knee pointing straight to the floor.\n" +
                "Avoid bending forward, and try not to lock the knee of your standing leg. Pull gently on the leg until you feel the thigh stretch. Hold it for 10 to 30 seconds."));

        exercises.add(new Exercise("Cobra", 2, "Lie on your belly with your hands facing forward flat on the floor, directly under your shoulders.\n" +
                "Stretch your legs out behind you and point your toes. As you exhale, lift your chest up and push your hips into the floor.\n" +
                "Take care not to extend your arms so far that you lift your hips up. Hold the position for 15 to 30 seconds."));

        exercises.add(new Exercise("Butterfly Stretch", 1, "This one loosens up your inner thighs, groin, hips, and knees. Sit on the floor or a mat and bring your feet together so that your soles touch and your knees bend to opposite sides.\n" +
                "With a straight spine, grasp your feet, then lean slowly forward and gently push your thighs down with your elbows until you feel the stretch along your inner thighs. Hold for 15 to 30 seconds."));

        exercises.add(new Exercise("Stationary lunge", 30, "Split your stance with your right leg in front. Your right foot should be flat on the ground, and your left foot should be up on its toes.\n" +
                "Bend your knees and lunge, stopping when your right thigh is parallel to the ground. Push up through your right foot to return to the starting position. Repeat for desired number of reps, then switch legs."));

        exercises.add(new Exercise("Plank to Downward dog", 30, "Get into a high plank position, with your hands stacked underneath your shoulders and your feet close together.\n" +
                "Keeping your core engaged and your hands and feet stationary, pike your hips up and back into the Downward Dog pose. Your body should form a triangle with the ground. Keep your neck neutral. Your gaze should be directed toward your feet.\n" +
                "Hold here for a second, then return to the plank. Repeat."));

        exercises.add(new Exercise("Glute bridge", 10-15, "Lie on your back with your knees bent, feet flat on the floor hip-width apart, and arms at your sides. This is the starting position.\n" +
                "Squeeze your glutes and abs, and push through your heels to lift your hips a few inches off the floor until your body forms a straight line from your shoulders to your knees.\n" +
                "Hold for a second and then slowly lower your hips to return to the starting position. This is 1 rep."));

        exercises.add(new Exercise("Cat-Cow", 5-10, "Start on all fours with your shoulders over your wrists and hips over knees. Take a slow inhale and, on the exhale, round your spine and\n" +
                "drop your head toward the floor (this is the cat posture). Inhale and lift your head, chest, and tailbone toward the ceiling as you arch your back for cow. Continue this pattern for 5 to 10 breaths."));
    }

    public ArrayList<Exercise> getExercises(){ return this.exercises; }

    public int getListSize(){ return exercises.size(); }

    public Exercise getExercise(int i) { return exercises.get(i); }

}
