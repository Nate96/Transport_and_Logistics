package com.translog.workitem.repository;

import com.translog.workitem.entity.Harbor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HarborRepository extends JpaRepository<Harbor, String> {
    
}
