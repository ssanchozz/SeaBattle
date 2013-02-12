package ru.bogdanov_alexander.java_base.game_logic;

public class Field {
    // Map characteristics
    public static final byte MAP_HEIGHT = 10;
    public static final byte MAP_WIDTH = 10;

    private Cell[][] cellsOfField = new Cell[MAP_WIDTH][MAP_HEIGHT];
    private String whoseField;

    public Field(String playerOrComputer){
        whoseField = playerOrComputer;
    }

    public Cell[][] getCellsOfField() {
        return cellsOfField;
    }

    public String getWhoseField() {
        return whoseField;
    }

    public void setCellOfField(Boat boatForCell, int[] coordinatesColRow) {
        this.cellsOfField[coordinatesColRow[0]][coordinatesColRow[1]].setBoatOfCell(boatForCell);
        this.cellsOfField[coordinatesColRow[0]][coordinatesColRow[1]].setBoatIsSet();
    }

    public void createCells() {
        for (int column = 0; column < 10; column++){
            for (int row = 0; row < 10; row++){
                cellsOfField[column][row] = new Cell();
            }
        }
    }
}
