package fi.nikitanoss.hytejengi_project;

public class Exercise {
    private String name, instructions;
    private int reps;

    public Exercise(String name) { this.name = name; }

    public Exercise(String name, int reps, String instructions) {
        this.name = name;
        this.reps = reps;
        this.instructions = instructions;
    }

    public String toString() { return name + "\nReps: " + reps + "\nInfo: " + instructions; }

    public String getReps() { return Integer.toString(reps); }

    public String getInstructions() { return instructions; }


}
