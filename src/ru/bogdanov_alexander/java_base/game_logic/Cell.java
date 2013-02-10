package ru.bogdanov_alexander.java_base.game_logic;

public class Cell {

    private Boat boatOfCell;
    private boolean boatIsSet = false;
    private boolean cellIsVerified = false;

    public boolean isCellIsVerified() {
        return cellIsVerified;
    }

    public Boat getBoatOfCell() {
        return boatOfCell;
    }

    public void setBoatOfCell(Boat boatOfCell) {
        this.boatOfCell = boatOfCell;
    }

    public boolean isBoatIsSet() {
        return boatIsSet;
    }

    public void setBoatIsSet() {
        this.boatIsSet = true;
    }
}
