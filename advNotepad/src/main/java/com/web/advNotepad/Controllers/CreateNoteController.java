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
public class CreateNoteController
{
    GroupService groupService;

    @GetMapping("/createNote")
    public String loadNotePage(Model model) throws ExecutionException, InterruptedException {
        groupService = new GroupService();
        model.addAttribute("userGroups",groupService.getAllUserGroups("admin"));
        model.addAttribute("selectedGroup",null);
        return "notes";
    }
    @GetMapping("/createNote/{id}")
    public String saveCreatedThread(@ModelAttribute Group capturedGroup, Model model) throws ExecutionException, InterruptedException {
        Group selectedGroup = groupService.getGroup(capturedGroup.getId(),"admin");
        System.out.println("Selected Group:" + selectedGroup.getGroup_name());
        model.addAttribute("userGroups",groupService.getAllUserGroups("admin"));
        model.addAttribute("selectedGroup",selectedGroup);
        return "notes";
    }
}
