package com.example.gardeners_note;

public enum GardenEnum {
    TREES("деревья"),
    SHRUBS("кустарники"),
    CONIFERS("хвойные растения"),
    VINES("лианы"),
    PERENNIALS("многолетние растения"),
    ANNUALS("однолетние растения");

    private String title;

    GardenEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
