package fi.nikitanoss.hytejengi_project;

/**
 * Object class for exercises.
 *
 * @author Elmo Erla
 * @version 1.0.0 12/2022
 */

public class Exercise {
    private String name, instructions;
    private int reps;

    /**
     * Constructor for Exercise class
     * @param name
     */
    public Exercise(String name) { this.name = name; }

    /**
     * Constructor for Exercise class
     * @param name
     * @param reps
     * @param instructions
     */
    public Exercise(String name, int reps, String instructions) {
        this.name = name;
        this.reps = reps;
        this.instructions = instructions;
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName() { return "Name: " + name; }

    /**
     * ToString method.
     * @return name and number of reps
     */
    public String toString() { return name + "\nReps: " + reps; }

    /**
     * Getter for reps.
     * @return int reps
     */
    public String getReps() { return "Reps: " + Integer.toString(reps); }

    /**
     * Getter for instructions.
     * @return String instructions
     */
    public String getInstructions() { return instructions; }

}
