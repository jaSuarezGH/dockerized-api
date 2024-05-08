package com.suareztorella.dockerizedapi.directory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Map;

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
    public Object getDirectoryById(@PathVariable Long id) {
        try {
            return directoryRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return "No se encontro directorio con id " + id;
        }
    }

    @PostMapping
    public Directory createDirectory(@RequestBody Directory directory) {
        return directoryRepository.save(directory);
    }

    @PutMapping(path = "/{id}")
    public Object modifyDirectory(@PathVariable("id") Long id, @RequestBody Directory directory) {

        try {
            directoryRepository.findById(id).get();

            // Declare the new modified directory
            Directory moded_directory = new Directory();
            moded_directory.setId(id);
            moded_directory.setName(directory.getName());
            moded_directory.setEmails(directory.getEmails());

            return directoryRepository.save(moded_directory);
        } catch (NoSuchElementException e) {
            return "No se encontro directorio con id " + id;
        }

    }

    @SuppressWarnings("unchecked")
    @PatchMapping(path = "/{id}")
    public Object modifyPartiallyDirectory(@PathVariable("id") Long id, @RequestBody Map<String, Object> jsonData) {
        try {
            Directory directory = directoryRepository.findById(id).get();

            // Actualizar los datos del directorio con los valores del JSON
            if (jsonData.containsKey("name")) {
                directory.setName((String) jsonData.get("name"));
            }
            if (jsonData.containsKey("emails")) {
                directory.setEmails((List<String>) jsonData.get("emails"));
            }

            return directoryRepository.save(directory);
        } catch (NoSuchElementException e) {
            return "No se encontró directorio con id " + id;
        }
    }

    @DeleteMapping(path = "/{id}")
    public Object deleteDirectoryById(@PathVariable("id") Long id) {

        try {
            directoryRepository.findById(id).get();
            this.directoryRepository.deleteById(id);

            return "Eliminado directorio con id " + id;
        } catch (NoSuchElementException e) {
            return "No se encontro directorio con id " + id;
        }
    }
}