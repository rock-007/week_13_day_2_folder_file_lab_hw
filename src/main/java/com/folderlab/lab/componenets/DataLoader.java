package com.folderlab.lab.componenets;

import com.folderlab.lab.repositories.*;
import com.folderlab.lab.models.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    FileRepository fileRepository;

    public void run(ApplicationArguments args) {

        User user = new User("Umair", "Ashraf");
        userRepository.save(user);
        User user2 = new User("Uzair", "Aslam");
        userRepository.save(user2);
        File file = new File("pic-4", ".jpg", 4);
        fileRepository.save(file);
        Folder folder = new Folder("personal", user);
        folder.addFiles(file);
        folderRepository.save(folder);


    }
}
