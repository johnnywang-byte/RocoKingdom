package pojo;

/**
 * Represents a skill/ability a pet can use in battle.
 */
public class Skill {

    // Unique skill identifier (index/key)
    public int id;

    // Skill name
    public String name;

    // Hit chance (0.0 ~ 1.0)
    public double accuracy;

    // Damage factor (simplified power coefficient)
    public int power;

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    // Constructors
    public Skill() {}

    public Skill(int id, String name, double accuracy, int power) {
        this.id = id;
        this.name = name;
        this.accuracy = accuracy;
        this.power = power;
    }
}