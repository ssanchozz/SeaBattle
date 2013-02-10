package ru.bogdanov_alexander.java_base.game_logic;

public class Boat {
    private char boat_type = ' ';         // There are 5 types of boats
    private String start_coordinates = "0"; // Coordinate of the 1st cell of the boat
    private boolean alignment = true;         // True = vertical ; false = horizontal
    private int length = 0;                // Length of the boat in cells

    public Boat(char boat_type, String start_coordinates, boolean alignment, byte length){
        this.boat_type = boat_type;
        this.start_coordinates = start_coordinates;
        this.start_coordinates = start_coordinates;
        this.alignment = alignment;
        this.length = length;
    }

    public char get_boat_type(){
        return boat_type;
    }

    public String get_start_coordinates(){
        return start_coordinates;
    }

    public boolean get_alignment(){
        return alignment;
    }

    public int get_length(){
        return length;
    }

    public void setLength(byte length) {
        this.length = length;
    }
}
