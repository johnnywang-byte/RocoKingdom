package config;

import pojo.Pet;
import pojo.Skill;

/*
 * ##############################
 * NOTE:
 * - All elements are stored in random order!
 * - getPlayerPets() must return AT LEAST 6 pets; otherwise, a NullPointerException may occur.
 * ##############################
 */

public class AllPets {

    /**
     * Returns the player's pet pool (used by Data.initPlayerPets()).
     */
    public static Pet[] getPlayerPets() {
        // ---------- 1) Skill Pool ----------
        Skill tackle = s(1, "Tackle", 0.95, 20);   // Common skill

        // Fire-type skills
        Skill blaze = s(101, "Ember", 0.90, 23);
        Skill flameBurst = s(102, "Flame Burst", 0.85, 30);
        Skill fireSpin = s(103, "Fire Spin", 0.70, 45);

        // Water-type skills
        Skill aquaJet = s(201, "Aqua Jet", 0.88, 27);
        Skill bubbleBeam = s(202, "Bubble Beam", 0.83, 33);
        Skill waterPulse = s(203, "Water Pulse", 0.75, 44);

        // Grass-type skills
        Skill vineWhip = s(301, "Vine Whip", 0.95, 26);
        Skill leafBlade = s(302, "Leaf Blade", 0.90, 32);
        Skill razorLeaf = s(303, "Razor Leaf", 0.80, 40);

        Data.skills = new Skill[]{
                tackle,
                blaze, flameBurst, fireSpin,
                aquaJet, bubbleBeam, waterPulse,
                vineWhip, leafBlade, razorLeaf
        };

        // ---------- 2) Pet Pool (3 pets per type) ----------

        // 🔥 Fire-type pets
        Pet fireFox = p(101, "Fire Fox", "Fire", 100, 25, 15, 20,
                new Skill[]{tackle, blaze, flameBurst, fireSpin});

        Pet flameTiger = p(102, "Flame Tiger", "Fire", 120, 30, 18, 17,
                new Skill[]{tackle, blaze, flameBurst, fireSpin});

        Pet lavaDragon = p(103, "Lava Dragon", "Fire", 140, 35, 20, 15,
                new Skill[]{tackle, blaze, flameBurst, fireSpin});

        // 💧 Water-type pets
        Pet aquaOtter = p(201, "Aqua Otter", "Water", 105, 22, 18, 18,
                new Skill[]{tackle, aquaJet, bubbleBeam, waterPulse});

        Pet frostTurtle = p(202, "Frost Turtle", "Water", 130, 25, 25, 12,
                new Skill[]{tackle, aquaJet, bubbleBeam, waterPulse});

        Pet tideShark = p(203, "Tide Shark", "Water", 110, 28, 15, 24,
                new Skill[]{tackle, aquaJet, bubbleBeam, waterPulse});

        // 🌿 Grass-type pets
        Pet grassLizard = p(301, "Grass Lizard", "Grass", 95, 24, 17, 22,
                new Skill[]{tackle, vineWhip, razorLeaf, leafBlade});

        Pet flowerDeer = p(302, "Flower Deer", "Grass", 120, 27, 19, 20,
                new Skill[]{tackle, vineWhip, razorLeaf, leafBlade});

        Pet vineApe = p(303, "Vine Ape", "Grass", 115, 30, 18, 19,
                new Skill[]{tackle, vineWhip, razorLeaf, leafBlade});

        // ---------- 3) Return the player’s pet pool ----------
        return new Pet[]{
                fireFox, flameTiger, lavaDragon,
                aquaOtter, frostTurtle, tideShark,
                grassLizard, flowerDeer, vineApe
        };
    }

    /**
     * Returns the enemy's pet pool (used by Data.initEnemyPets()).
     */
    public static Pet[] getEnemyPets() {
        // ---------- 1) Skill Pool ----------
        Skill tackle = s(1, "Tackle", 0.95, 40);   // Common skill

        // Fire-type skills
        Skill blaze = s(101, "Ember", 0.95, 45);
        Skill flameBurst = s(102, "Flame Burst", 0.90, 60);
        Skill fireSpin = s(103, "Fire Spin", 0.85, 70);

        // Water-type skills
        Skill aquaJet = s(201, "Aqua Jet", 0.95, 45);
        Skill bubbleBeam = s(202, "Bubble Beam", 0.92, 60);
        Skill waterPulse = s(203, "Water Pulse", 0.90, 70);

        // Grass-type skills
        Skill vineWhip = s(301, "Vine Whip", 0.95, 45);
        Skill leafBlade = s(302, "Leaf Blade", 0.92, 65);
        Skill razorLeaf = s(303, "Razor Leaf", 0.90, 55);

        Data.skills = new Skill[]{
                tackle,
                blaze, flameBurst, fireSpin,
                aquaJet, bubbleBeam, waterPulse,
                vineWhip, leafBlade, razorLeaf
        };

        // ---------- 2) Enemy Pet Pool ----------
        Pet fireDragonE = p(1, "Charmander", "Fire", 100, 25, 15, 20,
                new Skill[]{tackle, blaze, flameBurst, fireSpin});

        Pet waterOtterE = p(2, "Aqua Otter", "Water", 105, 22, 18, 18,
                new Skill[]{tackle, aquaJet, bubbleBeam, waterPulse});

        Pet grassLizardE = p(3, "Grass Lizard", "Grass", 95, 24, 17, 22,
                new Skill[]{tackle, vineWhip, razorLeaf, leafBlade});

        return new Pet[]{fireDragonE, waterOtterE, grassLizardE};
    }

    // ---------- Utility Methods ----------

    /** Creates a skill object. */
    private static Skill s(int id, String name, double acc, int power) {
        Skill sk = new Skill();
        sk.id = id;
        sk.name = name;
        sk.accuracy = acc;
        sk.power = power;
        return sk;
    }

    /** Creates a pet and fills in its attributes and 4 skills, with full HP. */
    private static Pet p(int id, String name, String attr, int hpMax, int atk, int def, int spd, Skill[] skills4) {
        Pet pet = new Pet();
        pet.id = id;
        pet.name = name;
        pet.attribute = attr;
        pet.hpMax = hpMax;
        pet.hp = hpMax; // Start with full HP
        pet.atk = atk;
        pet.def = def;
        pet.spd = spd;

        // Ensure exactly 4 skills are set
        pet.petSkills[0] = skills4.length > 0 ? skills4[0] : null;
        pet.petSkills[1] = skills4.length > 1 ? skills4[1] : null;
        pet.petSkills[2] = skills4.length > 2 ? skills4[2] : null;
        pet.petSkills[3] = skills4.length > 3 ? skills4[3] : null;

        return pet;
    }
}