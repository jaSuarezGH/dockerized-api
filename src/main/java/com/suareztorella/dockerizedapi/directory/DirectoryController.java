package com.suareztorella.dockerizedapi.directory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return directoryRepository.findById(id).get();
    }

    @PostMapping
    public Directory createDirectory(@RequestBody Directory user) {
        return directoryRepository.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDirectoryById(@PathVariable("id") Long id) {

        this.directoryRepository.deleteById(id);

        return "eliminated " + id;
        /* if (this.extractedDataService.obtainDataById(id).isPresent()) {
            this.extractedDataService.deleteDataById(id);
            return "Deleted data with id " + id;
        } else {
            return "Could not delete data with id " + id + " (probably id does not exist)";
        } */
    }
}
