package com.folderlab.lab;

import com.folderlab.lab.models.File;
import com.folderlab.lab.models.Folder;
import com.folderlab.lab.models.User;
import com.folderlab.lab.repositories.FileRepository;
import com.folderlab.lab.repositories.FolderRepository;
import com.folderlab.lab.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabApplicationTests {

        @Autowired
        UserRepository userRepository;
        @Autowired
        FolderRepository folderRepository;
        @Autowired
        FileRepository fileRepository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void FoldersToUser() {
        User user = new User("Umair", "Ashraf");
        userRepository.save(user);
        File file = new File("pic-4", ".jpg", 4);
        fileRepository.save(file);
        Folder folder = new Folder("personal", user);
        folder.addFiles(file);
        folderRepository.save(folder);
    }


}
