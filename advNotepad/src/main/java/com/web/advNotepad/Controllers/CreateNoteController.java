package com.web.advNotepad.Controllers;

import com.web.advNotepad.Services.GroupService;
import com.web.advNotepad.Services.NoteService;
import com.web.advNotepad.models.Group;
import com.web.advNotepad.models.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Controller
public class CreateNoteController
{
    GroupService groupService;
    NoteService noteService;
    Group selectedGroup;

    @GetMapping("/createNote")
    public String loadNotePage(Model model) throws ExecutionException, InterruptedException {
        groupService = new GroupService();
        model.addAttribute("userGroups",groupService.getAllUserGroups("admin"));
        model.addAttribute("selectedGroup",null);
        return "notes";
    }
    @GetMapping("/createNote/{id}")
    public String selectedGroup(@ModelAttribute Group capturedGroup, Model model) throws ExecutionException, InterruptedException {
        selectedGroup = groupService.getGroup(capturedGroup.getId(),"admin");
        System.out.println("Selected Group:" + selectedGroup.getGroup_name());
        model.addAttribute("createdNote",new Note());
        model.addAttribute("userGroups",groupService.getAllUserGroups("admin"));
        model.addAttribute("selectedGroup",selectedGroup);
        return "notes";
    }
    @PostMapping("/createdNoteSave")
    public String saveCreatedNote(@ModelAttribute("createdNote") Note capturedNote, Model model) throws ExecutionException, InterruptedException {
        noteService = new NoteService();
        capturedNote.setCreator("admin");
        capturedNote.setGroupID(selectedGroup.getId());
        capturedNote.setCreateDate(getCurrentDate());
        System.out.println("Group ID: " + capturedNote.getGroupID());
        System.out.println("Date: " + capturedNote.getCreateDate());
        System.out.println("Field 1 Name: " + capturedNote.getFieldName1());
        System.out.println("Field 2 Name: " + capturedNote.getFieldName2());
        noteService.createNote(capturedNote);
        return "redirect:/";
    }
    public String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
}
