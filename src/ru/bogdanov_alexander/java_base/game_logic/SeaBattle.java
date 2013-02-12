package ru.bogdanov_alexander.java_base.game_logic;

import java.io.*;
import ru.bogdanov_alexander.java_base.game_graphics.*;


// TODO: Сделать соответственно с принципами ООП. Вывести поле на консоль



public class SeaBattle {
    // Boat's count & length
    public static final byte BATTLESHIP_COUNT = 1;
    public static final byte BATTLESHIP_LENGTH = 4;

    public static final byte CRUISER_COUNT = 2;
    public static final byte CRUISER_LENGTH = 3;

    public static final byte DESTROYER_COUNT = 3;
    public static final byte DESTROYER_LENGTH = 2;

    public static final byte SUBMARINE_COUNT = 4;
    public static final byte SUBMARINE_LENGTH = 1;

    public static final byte TOTAL_BOAT_COUNT = 10;

    public static void main(String[] args) {
        //создаем новый генератор псевдослучайных чисел
        java.util.Random generator = new java.util.Random(new java.util.Date().getTime());

        makeGreeting();

        // New concept of program  ------------------------------------------------
        Boat[] friendlyBoat = new Boat[BATTLESHIP_COUNT +
                CRUISER_COUNT +
                DESTROYER_COUNT +
                SUBMARINE_COUNT];

        Field myField = new Field("player");
        generateBoats(friendlyBoat);
        placeBoats(myField, friendlyBoat);
        drawFieldInConsole(myField);

        System.out.println(' ');

        Boat[] enemyBoat = new Boat[BATTLESHIP_COUNT +
                CRUISER_COUNT +
                DESTROYER_COUNT +
                SUBMARINE_COUNT];

        Field computerField = new Field("computer");
        generateBoats(enemyBoat);
        placeBoats(computerField, enemyBoat);
        drawFieldInConsole(computerField);

        Gui seaBattleGui = new Gui(myField, computerField);
        // --------------------------------------------------------------------------

        // Who win?
        System.out.println("Winner is " + getWinner(generator) + "!!!");
    }

    // Dummy
    static String getWinner(java.util.Random generator){
        String winner;

        if (generator.nextBoolean())
            winner = "friend";
        else
            winner = "enemy";

        return winner;
    }

    static void placeBoats (Field field, Boat[] playerBoats){
   //     field = new Field(whoseField);
        int[] currentCoordinates = new int[2];
        currentCoordinates = generateCoordinates();
        field.createCells();

        for (int boatCounter = 0; boatCounter < (BATTLESHIP_COUNT + CRUISER_COUNT + DESTROYER_COUNT + SUBMARINE_COUNT); boatCounter++){
            // Checking for occupation of the cell
            currentCoordinates = generateCoordinates();
            while(!makeBoatLegitimacyCheck(playerBoats[boatCounter], currentCoordinates, field)){
                currentCoordinates = generateCoordinates();
            }
            for (int counter = 0; counter < playerBoats[boatCounter].get_length(); counter++){
                field.setCellOfField(playerBoats[boatCounter], currentCoordinates);
                if (playerBoats[boatCounter].get_alignment()){
                    currentCoordinates[1]++;
                }
                if (!playerBoats[boatCounter].get_alignment()){
                    currentCoordinates[0]++;
                }
            }
        }

    }


    static int[] generateCoordinates (){
        java.util.Random generator = new java.util.Random();

        int[] coordinates = new int[2];
        coordinates[0] = generator.nextInt(10);
        coordinates[1] = generator.nextInt(10);

        return coordinates;
    }

    static void drawFieldInConsole (Field field){
        for(int cellCounterCol = 0; cellCounterCol < field.MAP_WIDTH; cellCounterCol++){
            for(int cellCounterRow = 0; cellCounterRow < field.MAP_HEIGHT; cellCounterRow++){
                if (!field.getCellsOfField()[cellCounterCol][cellCounterRow].isBoatIsSet()){
                System.out.print("- ");
                }
                if (field.getCellsOfField()[cellCounterCol][cellCounterRow].isBoatIsSet()){
                    System.out.print("+ ");
                }
            }
            System.out.println(" ");
        }


    }

    public static void generateBoats(Boat[] boats){
        for (int boatCounter = 0; boatCounter < BATTLESHIP_COUNT +
                CRUISER_COUNT +
                DESTROYER_COUNT +
                SUBMARINE_COUNT; boatCounter++){

            char whatTypeOfBoatNowCreating =' ';
            if (boatCounter == 0){
                whatTypeOfBoatNowCreating = 'b';
            }
            if (boatCounter == 1 || boatCounter == 2){
                whatTypeOfBoatNowCreating = 'c';
            }
            if (boatCounter == 3 || boatCounter == 4 || boatCounter == 5){
                whatTypeOfBoatNowCreating = 'd';
            }
            if (boatCounter == 6 || boatCounter == 7 || boatCounter == 8 || boatCounter == 9){
                whatTypeOfBoatNowCreating = 's';
            }

            // Boat's variables
            char boatType = 'b';
            String start_coordinates = "0";
            boolean alignment = true;
            java.util.Random generator = new java.util.Random();

            switch (whatTypeOfBoatNowCreating){
                case 'b':   alignment = generator.nextBoolean();
                            boats[boatCounter] = new Boat(whatTypeOfBoatNowCreating, start_coordinates, alignment, BATTLESHIP_LENGTH);
                            boats[boatCounter].setLength(BATTLESHIP_LENGTH);
                            break;
                case 'c':   alignment = generator.nextBoolean();
                            boats[boatCounter] = new Boat(whatTypeOfBoatNowCreating, start_coordinates, alignment, CRUISER_LENGTH);
                            boats[boatCounter].setLength(CRUISER_LENGTH);
                            break;
                case 'd':   alignment = generator.nextBoolean();
                            boats[boatCounter] = new Boat(whatTypeOfBoatNowCreating, start_coordinates, alignment, DESTROYER_LENGTH);
                            boats[boatCounter].setLength(DESTROYER_LENGTH);
                            break;
                case 's':   alignment = generator.nextBoolean();
                            boats[boatCounter] = new Boat(whatTypeOfBoatNowCreating, start_coordinates, alignment, SUBMARINE_LENGTH);
                            boats[boatCounter].setLength(SUBMARINE_LENGTH);
                            break;
                default:    System.out.println("Error!!!");
                            break;
            }
        }

    }

    static public boolean makeBoatLegitimacyCheck(Boat boat, int[] coordinates, Field field) {

        int xCoord, yCoord = 0;
        int[] startCoord = new int[2];
        int[] endCoord = new int[2];

        if(boat.get_alignment()) {
            if(coordinates[0] > 0) {
                startCoord[0] = coordinates[0] - 1;
                if(coordinates[0] == 9) endCoord[0] = 9;
            }
            if(coordinates[1] > 0) {
                startCoord[1] = coordinates[1] - 1;
                if(coordinates[1] + boat.get_length() - 1 == 9) endCoord[1] = 9;
            }

            if(coordinates[0] < 9) {
                endCoord[0] = coordinates[0] + 1;
                if(coordinates[0] == 0) startCoord[0] = 0;
            }
            if(coordinates[1] + boat.get_length() - 1 < 9) {
                endCoord[1] = coordinates[1] + boat.get_length();
                if(coordinates[1] == 0) startCoord[1] = 0;
            }
            if(coordinates[1] + boat.get_length() - 1 > 9) return false;
        } else {
            if(coordinates[0] > 0) {
                startCoord[0] = coordinates[0] - 1;
                if(coordinates[0] + boat.get_length() - 1 == 9) endCoord[0] = 9;
            }
            if(coordinates[1] > 0) {
                startCoord[1] = coordinates[1] - 1;
                if(coordinates[1] == 9) endCoord[1] = 9;
            }

            if(coordinates[1] < 9) {
                endCoord[1] = coordinates[1] + 1;
                if(coordinates[1] == 0) startCoord[1] = 0;
            }
            if(coordinates[0] + boat.get_length() - 1 < 9) {
                endCoord[0] = coordinates[0] + boat.get_length();
                if(coordinates[0] == 0) startCoord[0] = 0;
            }
            if(coordinates[0] + boat.get_length() - 1 > 9) return false;
        }

        if(boat.get_alignment()) {
            for (xCoord = startCoord[0]; xCoord < (endCoord[0] + 1); xCoord++) {
                for (yCoord = startCoord[1]; yCoord < (endCoord[1] + 1); yCoord++) {
                    if (coordinates[0] >= 0 && coordinates[0] < Field.MAP_WIDTH && coordinates[1] >= 0 && (coordinates[1] + boat.get_length() - 1) < Field.MAP_HEIGHT) {
                        if (field.getCellsOfField()[xCoord][yCoord].isBoatIsSet()) {
                            return false;
                        }
                    } else return false;
                }
            }
            return true;
        } else {
            for (yCoord = startCoord[1]; yCoord < (endCoord[1] + 1); yCoord++) {
                for (xCoord = startCoord[0]; xCoord < (endCoord[0] + 1); xCoord++) {
                    if (coordinates[0] >= 0 && (coordinates[0] + boat.get_length() - 1) < Field.MAP_WIDTH && coordinates[1] >= 0 && coordinates[1] < Field.MAP_HEIGHT) {
                        if (field.getCellsOfField()[xCoord][yCoord].isBoatIsSet()) {
                            return false;
                        }
                    } else return false;
                }
            }
            return true;
        }
    }

    static public void makeGreeting(){
        // Login
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        String player_name = "Sanchoz";
        System.out.println("Enter your name, please:\n");

        try {
            player_name = data.readLine();
        }
        catch (Exception e) {
            System.out.println("IO exception!!!\n");
        }

        // Greeting
        System.out.println("Hello, " + player_name + "!\n");
    }

}

