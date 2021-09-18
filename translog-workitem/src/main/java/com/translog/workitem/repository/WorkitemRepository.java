package com.translog.workitem.repository;

import com.translog.workitem.entity.Workitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkitemRepository extends JpaRepository<Workitem, String> { }
