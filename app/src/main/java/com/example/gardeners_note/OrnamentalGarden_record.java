package com.example.gardeners_note;

public class OrnamentalGarden_record {
    private int id;
    private String ornamental_name;
    private String ornamental_note;
    private GardenEnum ornamental_type;
    public OrnamentalGarden_record(String ornamental_name, String ornamental_note, GardenEnum ornamental_type) {
        this.ornamental_name = ornamental_name;
        this.ornamental_note = ornamental_note;
        this.ornamental_type = ornamental_type;
    }
    public OrnamentalGarden_record(int id, String ornamental_name, String ornamental_note, GardenEnum ornamental_type) {
        this.id=id;
        this.ornamental_name = ornamental_name;
        this.ornamental_note = ornamental_note;
        this.ornamental_type = ornamental_type;
    }
    public OrnamentalGarden_record(int id, String ornamental_name, String ornamental_note, int ornamental_type) {
        this.id=id;
        this.ornamental_name = ornamental_name;
        this.ornamental_note = ornamental_note;
        this.ornamental_type = GardenEnum.values()[ornamental_type];
    }
    public OrnamentalGarden_record() {
    }
    public String getOrnamental_name() {
        return ornamental_name;
    }
    public String getOrnamental_note() {
        return ornamental_note;
    }
    public GardenEnum getOrnamental_type() {
        return ornamental_type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setOrnamental_note(String ornamental_note) {
        this.ornamental_note = ornamental_note;
    }
    public void setOrnamental_name(String ornamental_name) {
        this.ornamental_name = ornamental_name;
    }
    public void setOrnamental_type(GardenEnum ornamental_type) {
        this.ornamental_type = ornamental_type;
    }
}

