package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry getById(String id) {
        Optional<JournalEntry> entry = journalEntryRepository.findById(id);
        return entry.orElse(null);
    }

    public JournalEntry deleteById(String id) {
        Optional<JournalEntry> entry = journalEntryRepository.findById(id);

        if(entry.isPresent()) {
            journalEntryRepository.deleteById(id);
            return entry.get();
        }
        return null;
    }

    public JournalEntry updateById(String id, JournalEntry newEntry) {
        Optional<JournalEntry> old = journalEntryRepository.findById(id);

        if(old.isPresent()) {
            JournalEntry entry = old.get();
            entry.setTitle(newEntry.getTitle());
            entry.setContent(newEntry.getContent());
            entry.setDate(newEntry.getDate());

            journalEntryRepository.save(entry);
            return entry;
        }
        return null;
    }
}