package com.web.advNotepad.Controllers;

import com.web.advNotepad.Services.GroupService;
import com.web.advNotepad.models.Group;
import com.web.advNotepad.models.GroupParameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ExecutionException;

@Controller
public class CustomizeController
{
    GroupParameters groupParameters;
    GroupService groupService;
    Group groups;
    @GetMapping("/customize")
    public String loadCustomizePage(Model model) {
        model.addAttribute("createdGroup",new GroupParameters());
        return "customize";
    }
    @PostMapping("/NotepadGroupSave")
    public String saveCreatedGroup(@ModelAttribute("createdGroup") GroupParameters capturedGroup, Model model) throws ExecutionException, InterruptedException {
        groups = new Group();
        groupParameters = new GroupParameters();
        groupService = new GroupService();
        groupParameters.setGroup_name(capturedGroup.getGroup_name());
        groupParameters.setDescription(capturedGroup.getDescription());
        groupParameters.setName_of_fields(capturedGroup.getName_of_fields());
        groupParameters.setNum_of_fields(capturedGroup.getNum_of_fields());

        System.out.println("Group Name: " + groupParameters.getGroup_name());
        groups.setGroup_name(groupParameters.getGroup_name());
        System.out.println("Group Field Names: " + groupParameters.getName_of_fields());
        System.out.println("Group Number of Fields: " + capturedGroup.getNum_of_fields());
        System.out.println("Group Description: " + groupParameters.getDescription() + "\n");
        groups.setDescription(groupParameters.getDescription());
        groups.setCreator("admin");

        String[] fieldNames = groupParameters.getName_of_fields().split(",");
        for (int i = 0; i < fieldNames.length; i++) {
            String fieldName = fieldNames[i];

            if (i == 0) {
                groups.setFieldName1(fieldName);
            } else if (i == 1) {
                groups.setFieldName2(fieldName);
            } else if (i == 2) {
                groups.setFieldName3(fieldName);
            } else if (i==3) {
                groups.setFieldName4(fieldName);
            } else if (i ==4) {
                groups.setFieldName5(fieldName);
            } else if (i==5) {
                groups.setFieldName6(fieldName);
            } else if (i==6) {
                groups.setFieldName7(fieldName);
            } else if (i==7) {
                groups.setFieldName8(fieldName);
            } else if (i==8) {
                groups.setFieldName9(fieldName);
            } else if (i==9) {
                groups.setFieldName10(fieldName);
            }
        }
        groupService.createGroup(groups);
        return "redirect:/";
    }
}
