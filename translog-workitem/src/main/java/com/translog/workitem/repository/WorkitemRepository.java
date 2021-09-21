package com.translog.workitem.repository;

import java.util.List;

import com.translog.workitem.entity.Workitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkitemRepository extends JpaRepository<Workitem, String> {
    public List<Workitem> findBySourceCountry(String sourceCountry);
    public List<Workitem> findBySelectedHarborLocation(String selectedHarborLocation);
 }
