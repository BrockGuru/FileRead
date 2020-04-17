package com.fileread.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileread.entity.FileRead;
@Repository
public interface FileRepository extends JpaRepository<FileRead,Long> {

}
