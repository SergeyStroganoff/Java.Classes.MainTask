package com.stroganov;

public enum Facultet {

    PHILOLOGY("Философия"), LINGUISTICS("Лингвистика"), MATHEMATICS("Математика"), LOGISTICS("Логистика");

    private String title;

    Facultet(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Факультет: " + title;
    }

    public String getTitle() {
        return title;
    }
}
