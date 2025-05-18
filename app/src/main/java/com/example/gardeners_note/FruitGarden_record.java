package com.example.gardeners_note;

public class FruitGarden_record {
    private int id;
    private String variety;
    private String fruit_name;
    private String fruit_note;
    private FruitEnum fruit_type;
    public FruitGarden_record(String fruit_name, String fruit_note, FruitEnum fruit_type,  String variety) {
        this.fruit_name = fruit_name;
        this.fruit_note = fruit_note;
        this.fruit_type = fruit_type;
        this.variety = variety;
    }
    public FruitGarden_record(int id, String fruit_name, String fruit_note, FruitEnum fruit_type,  String variety) {
        this.id=id;
        this.fruit_name = fruit_name;
        this.fruit_note = fruit_note;
        this.fruit_type = fruit_type;
        this.variety = variety;
    }
    public FruitGarden_record(int id, String fruit_name, String fruit_note, int fruit_type,  String variety) {
        this.id=id;
        this.fruit_name = fruit_name;
        this.fruit_note = fruit_note;
        this.variety = variety;
        this.fruit_type = FruitEnum.values()[fruit_type];
    }
    public FruitGarden_record() {
    }
    public String getFruit_name() {return fruit_name;}
    public String getVariety() {return variety;}
    public String getFruit_note() {return fruit_note;}
    public FruitEnum getFruit_type() {
        return fruit_type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFruit_note(String fruit_note) {
        this.fruit_note = fruit_note;
    }
    public void setVariety(String variety) {
        this.variety = variety;
    }
    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }
    public void setFruit_type(FruitEnum fruit_type) {
        this.fruit_type = fruit_type;
    }
}

