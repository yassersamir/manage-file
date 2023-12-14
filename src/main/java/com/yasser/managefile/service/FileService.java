package com.yasser.managefile.service;

import com.yasser.managefile.model.File;
import com.yasser.managefile.repository.FileRepository;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File createFile(File file) {
        return fileRepository.save(file);
    }

}
