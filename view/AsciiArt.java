package view;

import pojo.Pet;

public class AsciiArt {

    // Simple ANSI coloring (will be ignored on terminals that don't support it)
    private static final String R = "\u001B[31m"; // Red
    private static final String G = "\u001B[32m"; // Green
    private static final String B = "\u001B[34m"; // Blue
    private static final String Y = "\u001B[33m"; // Yellow
    private static final String X = "\u001B[0m";  // Reset

//    // — You can swap these out for larger arts if you want — //
//    private static final String FIRE =
//            R +
//                    "   (  )  \n" +
//                    "  ( ) )  \n" +
//                    " (  ) )  \n" +
//                    "  )  (  )  \n" +
//                    "( (    ) ( \n" +
//                    "   `--'   \n" + X;
//
//    private static final String WATER =
//            B +
//                    " ~~~~~~  \n" +
//                    "  ~~~~   \n" +
//                    " ~~~~~~  \n" +
//                    "  ~~~~   \n" +
//                    " ~~~~~~  \n" + X;
//
//    private static final String GRASS =
//            G +
//                    "   /\\    \n" +
//                    "  //\\\\   \n" +
//                    " ///\\\\\\  \n" +
//                    "   ||    \n" +
//                    "   ||    \n" + X;

    // Specific arts for certain enemies (by name or id)
    private static final String FIRE_DRAGON =
            """ 
                ⬜⬜⬜⬜🟥🟥🟥🟨🟨🟨🟨🟥⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
                ⬜⬜⬜⬜🟥🟥🟥🟨🟥🟨🟥⬜⬜⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜🟧⬜⬜⬜⬜⬜
                ⬜⬜⬜⬜⬜🟥🟥🟧🟥🟨🟨⬜⬛🟧🟧🟧⬛⬜⬜⬜⬜⬜⬜🟧⬜⬜⬜⬜⬜
                ⬜⬜⬜⬜⬜⬜🟧🟧⬜🟥⬜⬜⬜🟥⬜🟧⬛⬜⬜⬜⬜⬜⬜🟧🟧🟧⬜⬜⬜
                ⬜⬜⬜⬜🟧🟧🟧🟧⬜⬜🟥⬜⬛🟥🟥🟥🟧⬛⬜⬜⬜⬜⬜🟧🟧🟧🟧⬜⬜
                ⬜⬜⬜🟧🟧🟧🟧⬜⬜⬜⬜⬜⬜⬛🟥🟥🟧⬛⬛⬜⬜⬜⬜🟧🟦🟧🟧🟧⬜
                ⬜⬜⬜🟧🟧🟦🟧⬜⬜⬜⬜🏻🏻🏻🟥🟫🟧⬜⬛⬜⬜⬜🟧🟧🟦🟦🟦🟧⬜
                ⬜⬜🟧🟧🟦🟦🟧🟧⬜⬜⬜⬛🟪🏻🏻🟫🟧🟧🟧⬛⬜⬜🟧🟦🟦🟦🟦🟧🟧
                ⬜⬜🟧🟦🟦🟦🟧🟧⬜⬜⬛🟧⬛⬛⬛🟧🟧⬛🟧⬛⬜🟧🟧🟦🟦🟦🟦🟦🟧
                ⬜🟧🟧🟦🟦🟦🟧🟧⬜⬜⬜⬛🟧🟧🟧🟧⬛⬛🟧🟧⬛🟧🟧🟦🟦🟦🟥🟦🟧
                ⬜🟧🟦🟦🟦🟦🟧🟧⬜⬜⬜⬜⬛⬛⬛🟧⬛⬜⬛⬛⬛🟧🟦🟦🟥🟥🟦🟦🟧
                🟧🟧🟦🟦🟦🟦🟦🟧🟧⬜⬜⬜⬛🟧🟧🟧⬛⬜⬜⬜🟧🟧🟦🟦🟥🟨🟦🟦🟥
                🟧🟦🟦🟦🟦🟦🟦🟧🟧🟧⬜⬜⬛🟧🟧🟧⬛⬜⬜🟧🟧🟦🟦🟥🟥🟦🟥🟥🟥
                🟧🟦🟦🟦🟦🟦🟦🟦🟧🟧🟧⬜⬛🟧🟧🟧⬛⬜🟧🟧🟧🟦🟦🟥🟨🟥🟨🟥🟧
                🟧🟦🟦⬛⬜⬛🟦🟦🟦🟧🟧⬛🟧🟧🟧🟧⬛🟧🟧🟧🟦🟦🟦🟥🟨🟨🟥🟧🟥
                🟧🟦⬜⬜🟧⬜⬛🟦🟦🟧⬛🟧🟧🟧🟧🟧🟧⬛🟧🟧🟦🟦🟥🟨🟨🟨🟨🟥🟧
                🟧⬜⬜⬛🟧🟧⬛🟦🟦⬛🟧🟧🟧🟧🟧🟧🟧⬛🟧🟦⬜⬜⬛🟥🟧🟨🟨🟧🟥
                🟧⬜⬜⬜⬛🟧🟧⬛⬛🟧🟧🏻🏻🏻🏻🟧🟧🟧⬛🟦⬛🟧⬜🟥🟥🟧🟨🟨🟥
                ⬜⬜⬜⬜⬜⬛🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🟧🟧🟧⬛🟧🟧⬛🟦⬛🟧⬛🟥🟦
                ⬜⬜⬜⬜⬛⬛⬛⬛⬛🏻🏻🏻🏻🏻🏻🏻🟧⬛🟧🟧🟧⬛🟦⬜⬛🟧⬛⬜🟦
                ⬜⬜⬛⬛🟧🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧⬛⬛⬛🟦⬜⬛🟧🟧⬛⬜⬜
                ⬜⬛🟧🟧🟧🟧⬛⬛⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧⬛🟧🟧⬛⬛🟧🟧⬛⬜⬜⬜
                ⬜⬛🟧🟧🟧⬛🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧🟧⬛🟧🟧🟧🟧⬛⬜⬜⬜⬜
                ⬜⬛🟧🟧⬛🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🏻🟧🟧🟧⬛🟧🟧⬛⬜⬜⬜⬜⬜
                ⬜⬛🏻🟧⬛🟧🟧🟧🟧⬛🏻🏻🏻🏻🏻🏻🏻🟧🟧🟧🟧⬛⬛⬜⬜⬜⬜⬜⬜
                ⬜⬛🏻🏻🏻⬛🟧🟧🟧🟧⬛🏻🏻🏻🏻🏻⬛🟧🟧🟧🟧⬛⬜⬜⬜⬜⬜⬜⬜
                ⬜⬜⬛⬛⬛⬛🟧🟧🟧⬛🏻⬛⬛⬛⬛⬛🟧🟧🟧🟧⬛⬜⬜⬜⬜⬜⬜⬜⬜
                ⬜⬜⬛⬜🟧🟧🟧🟧⬛🏻🏻🏻⬛⬜⬜⬜⬛🟧🟧🟧🟧⬜⬜⬜⬜⬜⬜⬜⬜
                ⬜⬜⬜⬛⬜⬛⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬛⬜⬛⬜⬛⬜⬜⬜⬜⬜⬜⬜""";

    private static final String WATER_OTTER =
            """ 
               ⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬛🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬛🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬛🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬛🟦🟦⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜🟦🟦🟦🟦⬛⬛⬜⬜⬜🟦⬛⬜🟦⬛⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜🟦🟦🟦🟦🟦🟦⬛⬛⬛⬜🟦🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬛⬜⬜⬜⬜🟦🟦🟦🟦🟦🟦⬛⬛🟦🟦🟦🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜🟦🟦⬜⬜🟦🟦🟦🟦⬛⬛🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬛🟦⬛🟦🟦🟦🟦🟦⬛⬜⬜⬛🟦🟦🟦🟦⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬛⬜⬜⬛🟦🟦🟦🟦⬛⬛⬜⬜⬛🟦🟦🟦⬛⬛⬛⬛🟦⬜⬜⬜⬜⬜⬜⬜
               ⬜⬜⬜⬛⬜⬛⬛🟦🟦🟦🟦⬛⬜⬛⬜⬛🟦🟦🟦🟦🟦🟦⬜⬜⬛⬜⬜⬛⬛⬜⬜
               ⬜⬜⬜⬜⬛⬜⬛🟦🟦🟦🟦⬛⬛⬛⬜⬛🟦🟦🟦🟦🟦🟦⬛⬛⬜⬛⬛🏻🏻⬛⬜
               ⬜⬜⬜⬜⬛🟦⬛⬜🟦🟦🟦⬛🟦⬛⬜⬛🟦🟦🟦🟦⬛⬛⬜⬜⬛🏻🏻🏻🏻🏻⬛
               ⬜⬜🟦🟦⬛⬛⬜🟦🟦🟦🟦🟦⬛⬛⬜🟦🟦🟦🟦⬛⬛⬜⬜⬛🏻🏻🏻🟦🟦🟦⬛
               ⬜🟦⬜⬜⬜⬜🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦⬛⬛🏻🏻🟦🟦🏻🏻🏻⬛
               🟦⬜⬜⬜🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦⬛⬛⬛🟦🟦🟦🟦⬛🟦🏻🏻🏻🏻🏻⬛
               🟦⬜⬛⬛🟦🟦🟦🟦🟦⬛⬛🟦🟦🟦🟦🟦🟦⬛🟦⬛⬛⬛⬛🏻🏻🏻🏻🟦🟦⬛⬜
               ⬛⬜⬛⬛⬛🟦🟦🟦⬛🟦🟦🟦🟦🟦🟦⬛⬛🟦🟦🟦⬛🟦🏻🏻🟦🟦🟦🏻🏻⬛⬜
               ⬜⬛🟦⬛⬛🟦🟦⬛⬜⬛⬛⬛⬛⬛🟦🏻🏻🟦🟦🟦🟦⬛⬛⬛🏻🏻🏻⬛⬛⬜⬜
               ⬜⬜⬛🟦🟦⬛⬛⬜⬜⬜⬜⬜⬛⬜🏻🏻🏻🏻⬛🟦🟦🟦🟦⬛⬛⬛⬛⬜⬜⬜⬜
               ⬜⬜⬜⬛⬛⬜⬜⬜⬜⬜⬜⬜🟦⬜⬜🏻⬛⬛🏻🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛🏻🏻🏻🏻🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜🟦⬜🏻🏻⬛⬛⬛🟦🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🏻⬛🟦🟦🟦⬛🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜🟦🟦⬛🟦🟦🟦🟦🟦🟦⬛⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜🟦⬜⬜⬜🟦🟦🟦⬛🟦🟦🟦🟦🟦⬛⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜🟦⬜⬜⬜⬛🟦🟦🟦⬛🟦🟦🟦🟦🟦⬛⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬜⬜🟦⬛🟦🟦🟦⬛🟦🟦🟦🟦🟦⬛⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟦🟦🟦🟦⬛⬛⬛🟦🟦🟦🟦🟦🟦⬛⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟦🟦🟦🟦🟦🟦🟦🟦🟦⬛⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛🟦🟦🟦🟦🟦⬛⬛⬜⬜⬜⬜⬜
               ⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜""";

    private static final String GRASS_LIZARD =
            """ 
                    ⬜⬜⬜⬜⬜⬜⬛⬜⬜⬜⬜⬛⬜⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬛🟩⬛⬜⬛⬛🟩⬛⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬛🟩🟩⬛🟩🟩🟩⬛⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬛🏿🟩🟩⬛🟩🟩⬛⬜⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬛🏽⬛🟩🟩🟩⬛⬛⬛⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬛⬛🟩🟩⬛🏽🏽🏿⬛⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬛⬛🟩🟩🟩🟩⬛🏽🏽⬛⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬛🟩🟩🟩🟩🟩🟩🟩🟩⬛⬜⬜⬜⬜⬜⬜
                    ⬜⬛⬛🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩⬛⬜⬜⬜⬜⬜
                    ⬛🏾⬛🟨🟨🟩🟨🟩🟩🟩🟩🟩🟩🟩⬛⬜⬜⬜⬜
                    ⬛🏿🟨⬛🟨🟨🟨🟩🟨🟨🟩🟩🟩🟩⬛⬜⬜⬜⬜
                    ⬛🏾⬜⬛🟨🟨🏻🏻⬛🏻🟨🟩🟩🟫🏾⬛⬜⬜⬜
                    ⬜⬛⬜⬛🟧🟧🏻⬛⬛🏻🟨🟩🟩🟫🟫⬛⬜⬜⬜
                    ⬜⬛🏼🏼🟧🟧🏼⬛⬜🟨🟨🟩🟫🟫🟫⬛⬜⬜⬜
                    ⬜⬜⬛🏼🟧🟫🏼🏼🟨🟨🟩🟩🟫🟫⬛⬜⬜⬜⬜
                    ⬜⬜⬜⬛🟧🟧🟩🟩🟩🟩🟩⬛⬛⬛⬜⬜⬛⬛⬜
                    ⬜⬜⬜⬜⬛🏿⬛🟩🟩⬛⬛⬛⬜⬜⬜⬛🏿🟫⬛
                    ⬜⬜⬜⬜⬜⬛🟩🟩🟩🟩🟩🟩⬛⬜⬜⬛🟫🟫⬛
                    ⬜⬜⬜⬜⬛🟩🟩🟩🟩🟩🟩🟩🟩⬛⬛🟫🟫🟫⬛
                    ⬜⬜⬜⬛🟥🟧🟩🟩⬛🏼⬛🟩🟩⬛🟫🟫🟫⬛⬜
                    ⬜⬜⬜⬛🟧🟧⬛⬛🏼🏼⬛🟩⬛⬛⬛⬛⬛⬜⬜
                    ⬜⬜⬜⬜⬛⬛⬜⬛🟧🟫⬛⬛⬛⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜""";

    /** Print ASCII art for a pet. Prefer matching by name, else by attribute (if you enable that block). */
    public static void printForPet(Pet p) {
        if (p == null) return;

        String name = p.name == null ? "" : p.name;
        String attr = p.attribute == null ? "" : p.attribute;

        // 1) Name-specific (supports both English & Chinese to avoid breaking existing data)
        if (name.contains("Charmander")) {
            printBox("Enemy · Charmander", FIRE_DRAGON);
            return;
        }
        if (name.contains("Aqua Otter")) {
            printBox("Enemy · Aqua Otter", WATER_OTTER);
            return;
        }
        if (name.contains("Grass Lizard")) {
            printBox("Enemy · Grass Lizard", GRASS_LIZARD);
            return;
        }

//        // 2) Fallback by attribute (uncomment if you add the simple FIRE/WATER/GRASS arts above)
//        switch (attr) {
//            case "Fire":
//                printBox("Enemy · Fire", FIRE);  break;
//            case "Water":
//                printBox("Enemy · Water", WATER); break;
//            case "Grass":
//                printBox("Enemy · Grass", GRASS); break;
//            default:
//                printBox("Enemy", Y + "[No Art]" + X);
//        }
    }

    private static void printBox(String title, String art) {
        String line = "────────────────────────";
        System.out.println(line);
        System.out.println("  " + title);
        System.out.println(line);
        printStory(title);
        System.out.print(art);
        pause();
        pause();
        System.out.println("\n---------------------------------------------------------------");
    }

    /** Short flavor text shown before the art, based on the title key. */
    private static void printStory(String key) {
        String t = key == null ? "" : key.trim();
        String[] story;

        if (t.contains("Fire") || t.contains("Charmander") || t.contains("火")) {
            story = new String[]{
                    "An enemy fire-type creature appears!",
                    "It lets out a low growl...",
                    "The battle tension rises!"
            };
        } else if (t.contains("Water") || t.contains("Aqua") || t.contains("Ice") || t.contains("冰")) {
            story = new String[]{
                    "An enemy water-type creature emerges from the surface!",
                    "Its eyes burn with fighting spirit!",
                    "The air turns moist around you."
            };
        } else if (t.contains("Grass") || t.contains("草") || t.contains("Vine") || t.contains("藤") || t.contains("Flower") || t.contains("花")) {
            story = new String[]{
                    "An enemy grass-type creature leaps out of the bushes!",
                    "Its leaves sway softly in the wind...",
                    "The battle is about to begin!"
            };
        } else {
            story = new String[]{
                    "A mysterious creature appears...",
                    "Its presence sends a chill down your spine!",
                    "Battle start!"
            };
        }
        // Print story line by line with a short pause
        for (String line : story) {
            System.out.println(line);
            pause();
        }
    }

    public static void printWiner() {
        String winner =
                """ 
                    ⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬛⬛🟥🟥🟥🟥🟥🟥🟥⬛⬛⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬛🟥🟥🟥⬜⬜🟩⬜⬜🟥🟥🟥⬛⬜⬜⬜⬜
                    ⬜⬜⬜⬛🟥⬜⬜⬜🟩🟩🟩🟩🟩⬜⬜⬜🟥⬛⬜⬜⬜
                    ⬜⬜⬛🟥🟥⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜🟥🟥⬛⬜⬜
                    ⬜⬜⬛🟥🟥⬜⬛⬛🟥🟥🟥🟥🟥⬛⬛⬜🟥🟥⬛⬜⬜
                    ⬜⬜⬛🟥⬛⬛🟥🟥⬛⬛⬛⬛⬛🟥🟥⬛⬛🟥⬛⬜⬜
                    ⬜⬜⬛⬛🟥🟥⬛⬛⬛🟧⬛⬛🟧⬛⬛🟥🟥⬛⬛⬜⬜
                    ⬛⬛⬛⬛⬛⬛🟧⬜⬛🟧⬛⬛🟧⬜🟧⬛⬛⬛⬛⬛⬛
                    ⬜⬛⬛🟧⬛⬛🟧⬛🟧🟧⬛🟧🟧⬛🟧⬛⬛🟧⬛⬛⬜
                    ⬜⬜⬛🟧⬛🟧🟧⬛🟧🟧🟧🟧🟧⬛🟧🟧⬛🟧⬛⬜⬜
                    ⬜⬛⬛⬛⬛🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧⬛⬛⬛⬛⬜
                    ⬜⬜⬜⬜⬛⬛🟧🟧🟧⬛⬛⬛🟧🟧🟧⬛⬛⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜🏽⬛🟧🟧🟧🟧🟧🟧🟧⬛🏽⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜🏽⬜🏽⬜⬛🟧🟧🟧⬛⬜🏽⬜🏽⬜⬜⬜⬜
                    ⬜⬜⬜⬜🏽🏽⬛🟦🏽⬛⬛⬛🏽🟦⬛🏽🏽⬜⬜⬜⬜
                    ⬜⬜⬜⬛🟧🟧⬛🟦🟦⬛⬛⬛🟦🟦⬛🟧🟧⬛⬜⬜⬜
                    ⬜⬜⬜⬛🟧🟧⬛🟦🟦⬛⬛⬛🟦🟦⬛🟧🟧⬛⬜⬜⬜
                    ⬜⬜⬜⬛🟩🟩⬛🟨🟨🟨⬛🟨🟨🟨⬛🟩🟩⬛⬜⬜⬜
                    ⬜⬜⬜⬛🟩🟧🟥🟥🟦🟦🟦🟦🟦🟥🟥🟧🟩⬛⬜⬜⬜
                    ⬜⬜⬜⬜⬛🟧⬜⬜🟦⬛⬛⬛🟦⬜⬜🟧⬛⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬛⬛🟦🟦⬛⬜⬛🟦🟦⬛⬛⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬜⬛🟦🟦⬛⬜⬛🟦🟦⬛⬜⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬜⬛⬜⬜⬜⬛⬜⬛⬜⬜⬜⬛⬜⬜⬜⬜⬜
                    ⬜⬜⬜⬜⬛⬛⬜⬜🟦⬛⬜⬛🟦⬜⬜⬛⬛⬜⬜⬜⬜
                    ⬜⬜⬜⬛⬜⬜⬜🟦⬛⬛⬜⬛⬛🟦⬜⬜⬜⬛⬜⬜⬜
                    ⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜""";
        System.out.println(winner);
    }

    private static void pause() {
        try {
            Thread.sleep(1000); // Pause between lines
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}