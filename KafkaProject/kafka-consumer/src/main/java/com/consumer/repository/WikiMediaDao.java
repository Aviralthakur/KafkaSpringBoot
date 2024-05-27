package com.consumer.repository;

import com.consumer.entity.WikiMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaDao extends JpaRepository<WikiMedia,Long> {
}
