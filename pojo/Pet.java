package pojo;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a pet/creature with stats and four available skills.
 */
public class Pet {

    public int id;              // Pet ID
    public String name;         // Pet name
    public String attribute;    // Pet type/element: Fire / Water / Grass

    public double hp;           // Current HP
    public double hpMax;        // Maximum HP

    public double atk;          // Attack
    public double def;          // Defense
    public double spd;          // Speed

    /**
     * Array of skills — each pet has exactly four.
     */
    public Skill[] petSkills = new Skill[4];

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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getSpd() {
        return spd;
    }

    public void setSpd(double spd) {
        this.spd = spd;
    }

    public Skill[] getPetSkills() {
        return petSkills;
    }

    public void setPetSkills(Skill[] petSkills) {
        this.petSkills = petSkills;
    }

    // Equality and hashing
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id
                && hp == pet.hp
                && hpMax == pet.hpMax
                && Double.compare(atk, pet.atk) == 0
                && Double.compare(def, pet.def) == 0
                && Double.compare(spd, pet.spd) == 0
                && Objects.equals(name, pet.name)
                && Objects.equals(attribute, pet.attribute)
                && Objects.deepEquals(petSkills, pet.petSkills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attribute, hp, hpMax, atk, def, spd, Arrays.hashCode(petSkills));
    }

    // Constructors
    public Pet() {}

    public Pet(int id, String name, String attribute, int hp, int hpMax,
               double atk, double def, double spd, Skill[] petSkills) {
        this.id = id;
        this.name = name;
        this.attribute = attribute;
        this.hp = hp;
        this.hpMax = hpMax;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.petSkills = petSkills;
    }
}