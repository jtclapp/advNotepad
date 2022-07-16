package com.web.advNotepad.models;

public class GroupParameters
{
    String group_name;
    int num_of_fields;
    String name_of_fields;
    String description;

    public GroupParameters(String group_name, int num_of_fields, String name_of_fields, String description) {
        this.group_name = group_name;
        this.num_of_fields = num_of_fields;
        this.name_of_fields = name_of_fields;
        this.description = description;
    }

    public GroupParameters()
    {

    }
    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getNum_of_fields() {
        return num_of_fields;
    }

    public void setNum_of_fields(int num_of_fields) {
        this.num_of_fields = num_of_fields;
    }

    public String getName_of_fields() {
        return name_of_fields;
    }

    public void setName_of_fields(String name_of_fields) {
        this.name_of_fields = name_of_fields;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
