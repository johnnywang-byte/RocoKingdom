package config;

import pojo.Pet;
import pojo.Skill;

import java.util.*;

import static view.AsciiArt.printWiner;

/**
 * Central game state holder.
 *
 * - skills:     All skills available in the game.
 * - petBag:     The player's active party (array).
 * - index:      The index in petBag of the currently active pet.
 * - enemy:      The currently selected enemy pet for battle.
 * - enemyPetEcType: A snapshot (copy reference) of the enemy pet BEFORE battle.
 *                   After victory we add this snapshot (with full HP) to the player's storage.
 *                   We must NOT add Data.enemy itself because it may have HP=0 (fainted).
 *                   This field is set in enemySelectView after the player chooses an enemy.
 * - playerPetsList: Player’s reserve/storage (beyond the active petBag).
 * - enemyPetsList:  Enemy’s reserve/storage.
 */
public class Data {

    // All skills (e.g., ~10 per attribute/type)
    public static Skill[] skills;

    // Player's active party (bag)
    public static Pet[] petBag;

    // Current active pet index in petBag
    public static int index;

    // Current enemy in battle
    public static Pet enemy;

    // Enemy snapshot used to award a full-HP copy on victory
    public static Pet enemyPetEcType;

    // Player storage (beyond the active bag)
    public static LinkedList<Pet> playerPetsList = new LinkedList<>();

    // Enemy storage
    public static LinkedList<Pet> enemyPetsList = new LinkedList<>();


    /** Initialize the player's pets: fill petBag with the first 6, store the rest in playerPetsList. */
    public static void initPlayerPets() {
        Pet[] playerPets = AllPets.getPlayerPets();

        // Bag: take the first 6 pets
        petBag = new Pet[6];
        for (int i = 0; i < 6; i++) {
            petBag[i] = playerPets[i];
            int id = petBag[i].id; // (kept as-is; no-op except perhaps for debugging)
        }

        // Put remaining pets into player storage
        for (int i = 6; i < playerPets.length; i++) {
            playerPetsList.add(playerPets[i]);
        }
    }

    /** Initialize the enemy storage from AllPets. */
    public static void initEnemyPets() {
        Pet[] enemyPets = AllPets.getEnemyPets();
        enemyPetsList.clear();                       // Clear first to avoid duplicates across runs
        enemyPetsList.addAll(Arrays.asList(enemyPets));
    }

    /**
     * Update player's bag after a pet faints:
     * - Remove the fainted active pet from the bag
     * - Pull the next pet from player storage (if any) into the same index
     * - Write back the list into the petBag array
     * - If the bag becomes empty, set petBag to an empty array and end-game will be handled elsewhere
     */
    public static void updatePlayerPet() {
        List<Pet> petList = new LinkedList<>(Arrays.asList(petBag));

        // If the active pet has fainted, remove it
        if (petBag[index].hp <= 0) {
            petList.remove(petBag[index]);

            // Refill from storage if available
            if (!playerPetsList.isEmpty()) {
                petList.add(index, playerPetsList.get(0));
                playerPetsList.remove(0);
            }

            // Write back to the array (preserve order and null checks)
            for (int i = 0; i < petList.size(); i++) {
                Pet obj = petList.get(i);
                if (obj != null) {
                    petBag[i] = obj;
                }
            }

            // If nothing left, empty the bag
            if (petList.isEmpty()) {
                petBag = new Pet[0];
            }
        }
    }

    /**
     * Update enemy storage after the enemy is defeated:
     * - Add the pre-battle snapshot (full-HP version) to the player storage
     * - Remove the defeated enemy (by object equality) from the enemy storage
     * - If the enemy storage is empty, print the win banner and exit
     */
    public static void updateEnemyPets() {
        // Add a copy reference that represents the pre-battle enemy (intended as “full HP” award)
        playerPetsList.add(Data.enemyPetEcType);

        // Remove the defeated enemy from storage
        enemyPetsList.remove(Data.enemy);

        // If no enemies remain, the player has cleared the game
        if (enemyPetsList.isEmpty()) {
            // If you have a banner printer elsewhere, call it here (kept as-is if present in your project):
            printWiner();
            System.out.println("You have defeated all wild creatures — congratulations, you cleared the game!");
            System.exit(0);
        }
    }

    /**
     * Returns up to three enemies to display for selection.
     * If there are fewer than three in storage, fills the remaining slots with empty placeholder pets.
     */
    public static Pet[] getEnemy() {
        Pet[] enemyPets = new Pet[3];

        // Only 1 enemy left
        if (enemyPetsList.size() == 1) {
            enemyPets[0] = enemyPetsList.getFirst();
            enemyPets[1] = createEmptyPet();
            enemyPets[2] = createEmptyPet();
            return enemyPets; // Early return to avoid overwrite below
        }

        // Only 2 enemies left
        if (enemyPetsList.size() == 2) {
            enemyPets[0] = enemyPetsList.get(0);
            enemyPets[1] = enemyPetsList.get(1);
            enemyPets[2] = createEmptyPet();
            return enemyPets; // Early return to avoid overwrite below
        }

        // 3 or more enemies: take the first 3
        int count = 0;
        for (Pet pet : enemyPetsList) {
            enemyPets[count++] = pet;
            if (count >= 3) break;
        }
        return enemyPets;
    }

    /**
     * Randomly tweak a pet's stats by a factor in [0.9, 1.1], resetting HP to the new max.
     */
    public static Pet changePetAttribute(Pet p) {
        Random random = new Random();
        double factor = 0.9 + random.nextDouble() * 0.2;
        p.hpMax = Math.max(1, (int) Math.round(p.hpMax * factor));
        p.hp    = p.hpMax;
        p.atk   = Math.max(1, (int) Math.round(p.atk * factor));
        p.def   = Math.max(1, (int) Math.round(p.def * factor));
        p.spd   = Math.max(1, (int) Math.round(p.spd * factor));
        return p;
    }

    /**
     * Create an “empty slot” pet placeholder for UI alignment when fewer than 3 enemies exist.
     */
    public static Pet createEmptyPet() {
        Skill[] skis = new Skill[4];
        skis[0] = new Skill(0, "", 0, 0);
        skis[1] = new Skill(0, "", 0, 0);
        skis[2] = new Skill(0, "", 0, 0);
        skis[3] = new Skill(0, "", 0, 0);
        return new Pet(0, "", "", 0, 0, 0, 0, 0, skis);
    }
}