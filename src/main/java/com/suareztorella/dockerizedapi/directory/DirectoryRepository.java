package com.suareztorella.dockerizedapi.directory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

}
