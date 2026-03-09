package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/_journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;


    // GET all journal entries
    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }


    // CREATE new journal entry
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;
    }


    // GET journal entry by ID
    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable String myId) {
        return journalEntryService.getById(myId);
    }


    // DELETE journal entry by ID
    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable String myId) {
        return journalEntryService.deleteById(myId);
    }


    // UPDATE journal entry
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable String id, @RequestBody JournalEntry myEntry) {
        return journalEntryService.updateById(id, myEntry);
    }
}