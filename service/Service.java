package service;

import config.Data;
import pojo.Pet;
import pojo.Skill;

import java.util.Random;

public class Service {

    /**
     * Initialize the game:
     * - Initialize player's pet pool and pet bag
     * - Initialize enemy pet pool
     */
    public static void initGame() {
        Data.initPlayerPets(); // Initialize player's pets
        Data.initEnemyPets();  // Initialize enemy pets
    }

    /**
     * Determine who attacks first.
     * Compare speed — the faster one goes first.
     * @return true if the player moves first, false if the enemy does
     */
    public static boolean isFirstPlayer() {
        Pet playerPet = Data.petBag[Data.index];
        Pet enemyPet = Data.enemy;
        return playerPet.spd > enemyPet.spd;
    }

    /**
     * Enemy attacks the player.
     *
     * Steps:
     * 1. Randomly pick one of the 4 skills.
     * 2. Roll 1–10; if greater than accuracy*10, the attack misses.
     * 3. Base damage = enemy.atk * skill.power / player.def
     * 4. Apply type effectiveness:
     *    • Advantage (×1.25): Fire > Grass, Grass > Water, Water > Fire
     *    • Disadvantage (×0.75): Fire < Water, Grass < Fire, Water < Grass
     * 5. Update player’s HP.
     */
    public static void enemyDamage() {
        Pet playerPet = Data.petBag[Data.index];

        int skillIndex = new Random().nextInt(4);
        Skill selectedSkill = Data.enemy.petSkills[skillIndex];
        int hitRoll = new Random().nextInt(10) + 1;

        // Accuracy check
        if (hitRoll > (selectedSkill.accuracy * 10)) {
            System.out.println("Lucky! " + Data.enemy.name + "'s " + selectedSkill.name + " missed!");
            return;
        }

        // Base damage
        double baseDamage = (Data.enemy.atk * selectedSkill.power) / (double) playerPet.def;

        // Type effectiveness
        if ((Data.enemy.attribute.equals("Fire") && playerPet.attribute.equals("Grass")) ||
                (Data.enemy.attribute.equals("Grass") && playerPet.attribute.equals("Water")) ||
                (Data.enemy.attribute.equals("Water") && playerPet.attribute.equals("Fire"))) {
            baseDamage *= 1.25; // Advantage
        } else if ((Data.enemy.attribute.equals("Fire") && playerPet.attribute.equals("Water")) ||
                (Data.enemy.attribute.equals("Water") && playerPet.attribute.equals("Grass")) ||
                (Data.enemy.attribute.equals("Grass") && playerPet.attribute.equals("Fire"))) {
            baseDamage *= 0.75; // Disadvantage
        }

        int finalDamage = (int) Math.round(baseDamage);
        playerPet.hp = Math.max(playerPet.hp - finalDamage, 0);

        System.out.println(Data.enemy.name + " used " + selectedSkill.name +
                " on " + playerPet.name +
                " and dealt " + finalDamage + " damage!");
        if (playerPet.hp <= 0) {
            System.out.println("Your active pet has fainted!");
        }
    }

    /**
     * Player attacks the enemy.
     *
     * Steps:
     * 1. Roll 1–10; if greater than accuracy*10, the attack misses.
     * 2. Base damage = player.atk * skill.power / enemy.def
     * 3. Apply type effectiveness (same rules as above).
     * 4. Update enemy’s HP.
     *
     * @param skill The skill used by the player's active pet
     * @return The damage dealt (before rounding)
     */
    public static double causeDamage(Skill skill) {
        Pet currentPet = Data.petBag[Data.index];
        Random rand = new Random();
        int roll = rand.nextInt(10) + 1;
        double damage = 0;
        double multiplier = 1.0;

        // Accuracy check
        if (roll > skill.accuracy * 10) {
            System.out.println("Oops! The attack missed!");
            return 0;
        }

        // Type effectiveness
        if ((currentPet.attribute.equals("Fire") && Data.enemy.attribute.equals("Grass")) ||
                (currentPet.attribute.equals("Grass") && Data.enemy.attribute.equals("Water")) ||
                (currentPet.attribute.equals("Water") && Data.enemy.attribute.equals("Fire"))) {
            multiplier = 1.25;
        } else if ((currentPet.attribute.equals("Fire") && Data.enemy.attribute.equals("Water")) ||
                (currentPet.attribute.equals("Grass") && Data.enemy.attribute.equals("Fire")) ||
                (currentPet.attribute.equals("Water") && Data.enemy.attribute.equals("Grass"))) {
            multiplier = 0.75;
        }

        damage = (skill.power * currentPet.atk / Data.enemy.def) * multiplier;
        Data.enemy.hp = Math.max(Data.enemy.hp - (int) damage, 0);

        // Display attack summary
        System.out.printf("%s used %s and dealt %.2f damage to %s!\n" +
                        "%s's remaining HP: %.0f\n",
                currentPet.name, skill.name, damage,
                Data.enemy.name, Data.enemy.name, Data.enemy.hp);

        return damage;
    }
}