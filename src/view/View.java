package view;

import config.Data;
import pojo.Pet;
import service.MusicManager;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    public static void startView(){
        System.out.println("""
        \033[5;32m
         ▄▄▄▄▄▄                                            ▄▄   ▄▄▄     ██                               ▄▄
         ██▀▀▀▀██                                          ██  ██▀      ▀▀                               ██
         ██    ██   ▄████▄    ▄█████▄   ▄████▄             ██▄██      ████     ██▄████▄   ▄███▄██   ▄███▄██   ▄████▄   ████▄██▄
         ███████   ██▀  ▀██  ██▀    ▀  ██▀  ▀██            █████        ██     ██▀   ██  ██▀  ▀██  ██▀  ▀██  ██▀  ▀██  ██ ██ ██
         ██  ▀██▄  ██    ██  ██        ██    ██            ██  ██▄      ██     ██    ██  ██    ██  ██    ██  ██    ██  ██ ██ ██
         ██    ██  ▀██▄▄██▀  ▀██▄▄▄▄█  ▀██▄▄██▀            ██   ██▄  ▄▄▄██▄▄▄  ██    ██  ▀██▄▄███  ▀██▄▄███  ▀██▄▄██▀  ██ ██ ██
         ▀▀    ▀▀▀   ▀▀▀▀      ▀▀▀▀▀     ▀▀▀▀              ▀▀    ▀▀  ▀▀▀▀▀▀▀▀  ▀▀    ▀▀   ▄▀▀▀ ██    ▀▀▀ ▀▀    ▀▀▀▀    ▀▀ ▀▀ ▀▀
                                                                                          ▀████▀▀     \033[0m   """);
    }

    /**
     * Loop:
     * 1) Show options:
     *    1. Start Game
     *    2. Exit
     * 2) Read user input (1 or 2)
     * 3) If 1 -> Service.initGame(), then enemySelectView()
     */
    public static void menuView() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Start Game");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    MusicManager.startBgm("bgm.wav"); // file path
                    Service.initGame();
                    enemySelectView();
                } else if (choice == 2) {
                    MusicManager.stopBgm();
                    MusicManager.stopBattle();
                    System.out.println("\033[32mThanks for playing. Goodbye!\033[0m");
                    System.exit(0);
                } else {
                    System.out.println("\033[31mPlease enter 1 or 2!\033[0m\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\033[31mPlease enter a valid numeric option!\033[0m\n");
                scanner.nextLine();  // clear invalid input
            }
        }
    }

    /**
     * Loop:
     * - Data.getEnemy() -> get 3 enemy pets, show them, ask player to choose 1..3
     * - Set Data.enemy to chosen one (with attribute variation), then battleView()
     */
    public static void enemySelectView() {
        while(true) {
            Pet[] pets = Data.getEnemy();
            Pet enemyA = pets[0];
            Pet enemyB = pets[1];
            Pet enemyC = pets[2];
            System.out.println("\t\t\tEnemy A\t\t\tEnemy B\t\t\tEnemy C");
            System.out.println("---------------------------------------------------------------");
            System.out.println("No.\t\t\t1\t\t\t\t2\t\t\t\t3\t\t\t");
            // System.out.println("id\t\t\t" + enemyA.id + "\t\t\t" + enemyB.id + "\t\t\t" + enemyC.id);
            System.out.println("name\t\t" + enemyA.name + "\t\t" + enemyB.name + "\t\t" + enemyC.name);
            System.out.println("attribute\t" + enemyA.attribute + "\t\t\t" + enemyB.attribute + "\t\t\t" + enemyC.attribute);
            System.out.printf("hp\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n",  enemyA.hp,    enemyB.hp,    enemyC.hp);
            System.out.printf("hpMax\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n", enemyA.hpMax, enemyB.hpMax, enemyC.hpMax);
            System.out.printf("atk\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n",  enemyA.atk,   enemyB.atk,   enemyC.atk);
            System.out.printf("def\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n",  enemyA.def,   enemyB.def,   enemyC.def);
            System.out.printf("spd\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n",  enemyA.spd,   enemyB.spd,   enemyC.spd);
            System.out.println("skill1\t\t" + enemyA.petSkills[0].name + "\t\t\t" + enemyB.petSkills[0].name + "\t\t\t" + enemyC.petSkills[0].name);
            System.out.println("skill2\t\t" + enemyA.petSkills[1].name + "\t\t\t" + enemyB.petSkills[1].name + "\t\t"   + enemyC.petSkills[1].name);
            System.out.println("skill3\t\t" + enemyA.petSkills[2].name + "\t\t"   + enemyB.petSkills[2].name + "\t\t"   + enemyC.petSkills[2].name);
            System.out.println("skill4\t\t" + enemyA.petSkills[3].name + "\t\t"   + enemyB.petSkills[3].name + "\t\t"   + enemyC.petSkills[3].name);
            System.out.println("---------------------------------------------------------------");
            System.out.println("Choose your opponent (1~3):");
            Scanner scan = new Scanner(System.in);
            String option = scan.nextLine();
            switch (option) {
                case "1":
                    Data.enemyPetEcType = enemyA;
                    Data.enemy = Data.changePetAttribute(enemyA);
                    break;
                case "2":
                    Data.enemyPetEcType = enemyB;
                    Data.enemy = Data.changePetAttribute(enemyB);
                    break;
                case "3":
                    Data.enemyPetEcType = enemyC;
                    Data.enemy = Data.changePetAttribute(enemyC);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    enemySelectView();
            }
            MusicManager.switchToBattle("battle.wav");
            AsciiArt.printForPet(Data.enemy);
            battleView();
            // remain in loop if needed
        }
    }

    /**
     * Battle view:
     * - Print both sides' info
     * - Determine turn order by Service.isFirstPlayer()
     * - While(true):
     *   If flag==1: enemy attacks -> check death -> if party wiped -> loseView(); else changePetView(); then flag++
     *   If flag==2: show action menu (1.Skill 2.Run)
     *       - 1: choose skill -> causeDamage() -> if enemy dead -> winView(); break
     *       - 2: run check by speed & RNG -> success -> back to menu; else fail -> flag--
     *   After each round, print petInfoView()
     */
    public static void battleView() {
        petInfoView();

        boolean turn = Service.isFirstPlayer();
        int flag = turn ? 2 : 1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (flag == 1) {
                Service.enemyDamage();
                Pet currentPet = Data.petBag[Data.index];
                if (currentPet.hp <= 0) {
                    boolean hasAlivePet = false;
                    for (int i = 0; i < Data.petBag.length; i++) {
                        Pet pet = Data.petBag[i];
                        if (pet != null && pet.hp > 0) {
                            hasAlivePet = true;
                            break;
                        }
                    }
                    if (!hasAlivePet) {
                        loseView();
                        break;
                    } else {
                        changePetView();
                    }
                }
                flag++;
            } else if (flag == 2) {
                System.out.println("1. Use Skill");
                System.out.println("2. Run Away");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();

                System.out.println("---------------------------------------------------------------");
                if (choice == 1) {
                    Pet currentPet = Data.petBag[Data.index];
                    for (int i = 0; i < currentPet.petSkills.length; i++) {
                        System.out.println((i + 1) + ". " + currentPet.petSkills[i].name);
                    }
                    System.out.print("Choose a skill: ");
                    int skillChoice = scanner.nextInt();
                    if (skillChoice >= 1 && skillChoice <= currentPet.petSkills.length) {
                        Service.causeDamage(currentPet.petSkills[skillChoice - 1]);
                        if (Data.enemy.hp <= 0) {
                            winView();
                            break;
                        }
                    }

                    flag--;
                } else if (choice == 2) {
                    Pet currentPet = Data.petBag[Data.index];
                    if (currentPet.spd > Data.enemy.spd) {
                        System.out.println("Escaped successfully!");
                        MusicManager.switchToBgm("bgm.wav");
                        menuView();
                        return;
                    } else if (Data.enemy.spd >= currentPet.spd) {
                        if (Math.random() < 0.5) {
                            System.out.println("Escaped successfully!");
                            MusicManager.switchToBgm("bgm.wav");
                            menuView();
                            return;
                        } else {
                            System.out.println("Escape failed!");
                        }
                    }
                    flag--;
                }
                else{
                    System.out.print("Invalid choice, please try again!");
                }
            }

            // Print both sides' info after each turn
            petInfoView();
        }

    }

    /**
     * Change active pet:
     * - Called after a defeat to replace dead pet with a reserve from the player's list
     * - If no pets left, end the game
     */
    public static void changePetView() {
        // Update player pets (remove dead one from bag and refill from reserve list)
        Data.updatePlayerPet();
        if (Data.petBag.length <= 0) {
            System.out.println("Unfortunately, you have no available pets left... Game Over.");
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < Data.petBag.length; i++) {
            Pet pet = Data.petBag[i];
            if (pet != null && pet.hp > 0) {
                System.out.println(i + ". " + pet.name + " " + pet.hp);
            }
        }
        System.out.println("Choose your next active pet:");
        try {
            int index = scanner.nextInt();
            if (index >= 0 && index < Data.petBag.length &&
                    Data.petBag[index] != null && Data.petBag[index].hp > 0) {
                Data.index = index;
                System.out.println("Switched to pet: " + Data.petBag[Data.index].name);
            } else {
                System.out.println("Please enter a valid number.");
                changePetView();
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            scanner.nextLine();
            changePetView();
        }
    }

    /**
     * Lose screen:
     * - Show enemy info
     * - Options: 1. Continue (switch pet)  2. Exit
     */
    public static void loseView() {
        MusicManager.switchToBgm("bgm.wav");
        System.out.println("You lost the battle!");
        System.out.println("Enemy Info:");
        System.out.println("Name: " + Data.enemy.name);
        System.out.println("HP: " + Data.enemy.hp + "/" + Data.enemy.hpMax);
        System.out.println("ATK: " + Data.enemy.atk);
        System.out.println("DEF: " + Data.enemy.def);
        System.out.println("SPD: " + Data.enemy.spd);
        System.out.println("Type: " + Data.enemy.attribute);

        while (true) {
            System.out.println("1. Continue");
            System.out.println("2. Exit");
            System.out.print("Choose: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                changePetView();
                break;
            } else if (choice == 2) {
                MusicManager.stopBgm();
                MusicManager.stopBattle();
                System.exit(0);
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    /**
     * Win screen:
     * - Update enemy list (transfer defeated enemy to player's list)
     * - Options: 1. Continue  2. Exit
     */
    public static void winView() {
        MusicManager.switchToBgm("bgm.wav");
        System.out.println(
                        "\033[31;1m░██    ░██ ░██              ░██                                   ░██\033[0m\n" +
                        "\033[33;1m░██    ░██                  ░██                                   ░██\033[0m\n" +
                        "\033[32;1m░██    ░██ ░██ ░███████  ░████████ ░█████░███ ░██░████ ░██    ░██ ░██ \033[0m\n" +
                        "\033[36;1m░██    ░██ ░██░██    ░██    ░██    ░██    ░██ ░███     ░██    ░██ ░██\033[0m\n" +
                        "\033[34;1m ░██  ░██  ░██░██           ░██    ░██    ░██ ░██      ░██    ░██ ░██\033[0m\n" +
                        "\033[35;1m  ░██░██   ░██░██    ░██    ░██    ░██    ░██ ░██      ░██   ░███    \033[0m\n" +
                        "\033[95;1m   ░███    ░██ ░███████      ░████  ░█████░██ ░██       ░█████░██ ░██\033[0m\n" +
                        "\033[94;1m                                                              ░██    \033[0m\n" +
                        "\033[96;1m                                                        ░███████     \033[0m\n" +
                        "\033[37;1m                                                                  \033[0m"
        );
        // On victory, move defeated enemy to player's storage and remove from enemy list
        Data.updateEnemyPets();

        System.out.println("Victory! What next? 1. Continue  2. Exit");
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        while (true) {
            if (choice == 2) {
                MusicManager.stopBgm();
                MusicManager.stopBattle();
                System.exit(0);
                break;
            } else if (choice == 1) {
                changePetView();
                break;
            } else {
                System.out.println("Invalid input, please try again!");
            }
            choice = scanner.nextInt();
        }
    }

    /**
     * Print both sides' current info
     */
    public static void petInfoView() {
        Pet enemyPet = Data.enemy;
        Pet myPet = Data.petBag[Data.index];
        System.out.println("\t\t\tMy Pet\t\t\tEnemy Pet");
        // System.out.println("id\t\t\t" + myPet.id + "\t\t\t" + enemyPet.id);
        System.out.println("name\t\t" + myPet.name + "\t\t" + enemyPet.name);
        System.out.println("attribute\t" + myPet.attribute + "\t\t\t" + enemyPet.attribute);
        System.out.printf("hp\t\t\t%.2f\t\t\t%.2f\n",    myPet.hp,   enemyPet.hp);
        System.out.printf("hpMax\t\t%.2f\t\t\t%.2f\n", myPet.hpMax, enemyPet.hpMax);
        System.out.printf("atk\t\t\t%.2f\t\t\t%.2f\n",  myPet.atk,  enemyPet.atk);
        System.out.printf("def\t\t\t%.2f\t\t\t%.2f\n",  myPet.def,  enemyPet.def);
        System.out.printf("spd\t\t\t%.2f\t\t\t%.2f\n",  myPet.spd,  enemyPet.spd);
        System.out.println("skill1\t\t" + myPet.petSkills[0].name + "\t\t\t" + enemyPet.petSkills[0].name );
        System.out.println("skill2\t\t" + myPet.petSkills[1].name + "\t\t\t" + enemyPet.petSkills[1].name);
        System.out.println("skill3\t\t" + myPet.petSkills[2].name + "\t\t"   + enemyPet.petSkills[2].name);
        System.out.println("skill4\t\t" + myPet.petSkills[3].name + "\t\t"   + enemyPet.petSkills[3].name);
        System.out.println("---------------------------------------------------------------");
    }
}