package com.yasser.managefile.repository;

import com.yasser.managefile.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
