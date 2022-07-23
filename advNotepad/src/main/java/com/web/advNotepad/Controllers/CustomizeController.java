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
    @PostMapping("/NotepadGroupContinue")
    public String continueWithCreatedGroup(@ModelAttribute("createdGroup") GroupParameters capturedGroup, Model model) {
        groups = new Group();
        groups.setGroup_name(capturedGroup.getGroup_name());
        groups.setDescription(capturedGroup.getDescription());
        groups.setCreator("admin");

        model.addAttribute("numOfFieldNames",Integer.parseInt(capturedGroup.getNum_of_fields()));
        model.addAttribute("groupNames",new Group());
        return "customize";
    }
    @PostMapping("/NotepadGroupSave")
    public String saveCreatedGroup(@ModelAttribute("createdGroup") Group groupNames, Model model) throws ExecutionException, InterruptedException {
        groupService = new GroupService();
        groups.setFieldName1(groupNames.getFieldName1());
        groups.setFieldName2(groupNames.getFieldName2());
        groups.setFieldName3(groupNames.getFieldName3());
        groups.setFieldName4(groupNames.getFieldName4());
        groups.setFieldName5(groupNames.getFieldName5());
        groups.setFieldName6(groupNames.getFieldName6());
        groups.setFieldName7(groupNames.getFieldName7());
        groups.setFieldName8(groupNames.getFieldName8());
        groups.setFieldName9(groupNames.getFieldName9());
        groups.setFieldName10(groupNames.getFieldName10());
        groupService.createGroup(groups);
        return "redirect:/";
    }
}
