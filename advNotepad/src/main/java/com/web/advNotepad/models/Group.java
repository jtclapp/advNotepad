package com.web.advNotepad.models;

public class Group
{
    String id;
    String creator;
    String group_name;
    String description;
    String fieldName1;
    String fieldName2;
    String fieldName3;
    String fieldName4;
    String fieldName5;
    String fieldName6;
    String fieldName7;
    String fieldName8;
    String fieldName9;
    String fieldName10;

    public Group(String id, String group_name, String creator,String description, String fieldName1, String fieldName2, String fieldName3, String fieldName4, String fieldName5, String fieldName6, String fieldName7, String fieldName8, String fieldName9, String fieldName10) {
        this.id = id;
        this.group_name = group_name;
        this.description = description;
        this.creator = creator;
        this.fieldName1 = fieldName1;
        this.fieldName2 = fieldName2;
        this.fieldName3 = fieldName3;
        this.fieldName4 = fieldName4;
        this.fieldName5 = fieldName5;
        this.fieldName6 = fieldName6;
        this.fieldName7 = fieldName7;
        this.fieldName8 = fieldName8;
        this.fieldName9 = fieldName9;
        this.fieldName10 = fieldName10;
    }

    public Group() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldName1() {
        return fieldName1;
    }

    public void setFieldName1(String fieldName1) {
        this.fieldName1 = fieldName1;
    }

    public String getFieldName2() {
        return fieldName2;
    }

    public void setFieldName2(String fieldName2) {
        this.fieldName2 = fieldName2;
    }

    public String getFieldName3() {
        return fieldName3;
    }

    public void setFieldName3(String fieldName3) {
        this.fieldName3 = fieldName3;
    }

    public String getFieldName4() {
        return fieldName4;
    }

    public void setFieldName4(String fieldName4) {
        this.fieldName4 = fieldName4;
    }

    public String getFieldName5() {
        return fieldName5;
    }

    public void setFieldName5(String fieldName5) {
        this.fieldName5 = fieldName5;
    }

    public String getFieldName6() {
        return fieldName6;
    }

    public void setFieldName6(String fieldName6) {
        this.fieldName6 = fieldName6;
    }

    public String getFieldName7() {
        return fieldName7;
    }

    public void setFieldName7(String fieldName7) {
        this.fieldName7 = fieldName7;
    }

    public String getFieldName8() {
        return fieldName8;
    }

    public void setFieldName8(String fieldName8) {
        this.fieldName8 = fieldName8;
    }

    public String getFieldName9() {
        return fieldName9;
    }

    public void setFieldName9(String fieldName9) {
        this.fieldName9 = fieldName9;
    }

    public String getFieldName10() {
        return fieldName10;
    }

    public void setFieldName10(String fieldName10) {
        this.fieldName10 = fieldName10;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
