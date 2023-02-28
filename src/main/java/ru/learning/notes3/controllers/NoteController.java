package ru.learning.notes3.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.learning.notes3.models.Note;
import ru.learning.notes3.services.NoteServiceImpl;

import java.util.List;

@Controller
public class NoteController {
    private final NoteServiceImpl noteService;
    @Autowired
    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        List<Note> noteList = noteService.getAllNotes();
        model.addAttribute("noteList", noteList);
        model.addAttribute("noteListSize", noteList.size());
        return "index";
    }

    @PostMapping("/add")
    public String saveNote(@ModelAttribute Note note) {
        noteService.saveNote(note);
        return "redirect:/";
    }

    @RequestMapping("delete/{id}")
    public String deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return "redirect:/";
    }
}
