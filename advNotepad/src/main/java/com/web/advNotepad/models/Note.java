package com.web.advNotepad.models;

public class Note
{
    String id;
    String creator;
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
    String groupID;
    String createDate;
    public Note(String id, String creator, String fieldName1, String fieldName2, String fieldName3, String fieldName4,
                String fieldName5, String fieldName6, String fieldName7, String fieldName8, String fieldName9, String fieldName10,
                String groupID, String createDate) {
        this.id = id;
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
        this.groupID = groupID;
        this.createDate = createDate;
    }
    public Note() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
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
    public String getGroupID() {
        return groupID;
    }
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
