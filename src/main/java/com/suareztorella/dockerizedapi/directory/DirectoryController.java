package com.suareztorella.dockerizedapi.directory;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/directories")
public class DirectoryController {

    @Autowired
    private DirectoryRepository directoryRepository;

    @GetMapping
    public List<Directory> getAllDirectories() {
        return directoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Directory getDirectoryById(@PathVariable Long id) {
        try {
            return directoryRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @PostMapping
    public Directory createDirectory(@RequestBody Directory directory) {
        return directoryRepository.save(directory);
    }

    @PutMapping(path = "/{id}")
    public Directory modifyDirectory(@PathVariable("id") Long id, @RequestBody Directory directory) {

        // Declare the new modified directory
        Directory moded_directory = new Directory();
        moded_directory.setId(id);
        moded_directory.setName(directory.getName());
        moded_directory.setEmails(directory.getEmails());

        return directoryRepository.save(moded_directory);
    }

    @PatchMapping(path = "/{id}")
    public Directory modifyPartiallyDirectory(@PathVariable("id") Long id, @RequestBody Directory directory) {

        // Declare the new modified directory
        Directory moded_directory = new Directory();
        moded_directory.setId(id);
        moded_directory.setName(directory.getName());
        moded_directory.setEmails(directory.getEmails());

        return directoryRepository.save(moded_directory);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDirectoryById(@PathVariable("id") Long id) {

        this.directoryRepository.deleteById(id);

        return "eliminated " + id;
        /*
         * if (this.extractedDataService.obtainDataById(id).isPresent()) {
         * this.extractedDataService.deleteDataById(id);
         * return "Deleted data with id " + id;
         * } else {
         * return "Could not delete data with id " + id +
         * " (probably id does not exist)";
         * }
         */
    }
}
