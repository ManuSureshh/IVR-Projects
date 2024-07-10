package com.vis.ivr.TechMDB2.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vis.ivr.TechMDB2.Model.TechM;

@Repository
public interface TechMRepo extends JpaRepository<TechM, Integer>{

}
