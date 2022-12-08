package fi.nikitanoss.hytejengi_project;

import java.util.List;

public class Model {
    List<data> data;

    public List<Model.data> getData() {
        return data;
    }

    public void setData(List<data> data) {
        this.data = data;
    }

    public static class data {
        String name;
        String type;
        String muscle;
        String equipment;
        String difficulty;
        String instructions;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMuscle() {
            return muscle;
        }

        public void setMuscle(String muscle) {
            this.muscle = muscle;
        }

        public String getEquipment() {
            return equipment;
        }

        public void setEquipment(String equipment) {
            this.equipment = equipment;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public String getInstructions() {
            return instructions;
        }

        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }
    }
}
