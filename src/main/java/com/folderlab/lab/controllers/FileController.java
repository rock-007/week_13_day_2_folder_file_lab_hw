package com.folderlab.lab.controllers;

import com.folderlab.lab.repositories.FolderRepository;

import com.folderlab.lab.models.File;
import com.folderlab.lab.models.Folder;
import com.folderlab.lab.models.User;
import com.folderlab.lab.repositories.FileRepository;
import com.folderlab.lab.repositories.FolderRepository;
import com.folderlab.lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles() {
        System.out.println(fileRepository.findAll());
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id) {

        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> addFiles(@RequestBody File file) {
        Folder existingFolder =  folderRepository.getById(1L);
        System.out.println("existingFolder");
        existingFolder.addFiles(file);
        folderRepository.save(existingFolder);
        fileRepository.save(file);
        System.out.println("after existingFolder");

        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
