package com.folderlab.lab.controllers;

import com.folderlab.lab.models.Folder;
import com.folderlab.lab.models.User;
import com.folderlab.lab.repositories.FolderRepository;
import com.folderlab.lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        System.out.println(folderRepository.findAll());
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id) {

        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> addFolder(@RequestBody Folder folder) {

        return new ResponseEntity<>(folderRepository.save(folder), HttpStatus.CREATED);
    }

}
