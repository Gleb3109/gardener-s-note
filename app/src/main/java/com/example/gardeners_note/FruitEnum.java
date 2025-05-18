package com.example.gardeners_note;

public enum FruitEnum {
    TREES("деревья"),
    SHRUBS("кустарники"),
    VEGETABLES("овощи"),
    BERRIES("ягоды"),
    GREENS("зелень");

    private String title;

    FruitEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
