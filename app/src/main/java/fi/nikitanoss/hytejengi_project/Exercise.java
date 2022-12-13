package fi.nikitanoss.hytejengi_project;

/**
 * Object class for exercises.
 *
 * @author
 * @version 1.0.0 12/2022
 */

public class Exercise {
    private String name, instructions;
    private int reps;

    public Exercise(String name) { this.name = name; }

    /**
     * Constructor for Exercise class
     */

    public Exercise(String name, int reps, String instructions) {
        this.name = name;
        this.reps = reps;
        this.instructions = instructions;
    }
    /**
     * Getter methods for exercise class
     */
    public String getName() { return "Name: " + name; }

    public String toString() { return name + "\nReps: " + reps; }

    public String getReps() { return "Reps: " + Integer.toString(reps); }

    public String getInstructions() { return instructions; }


}
