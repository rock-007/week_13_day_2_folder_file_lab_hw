package com.folderlab.lab.repositories;

import com.folderlab.lab.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
