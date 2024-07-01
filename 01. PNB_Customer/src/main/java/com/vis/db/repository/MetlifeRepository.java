package com.vis.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vis.db.modal.PNBMetlife_IVR_Report;



@Repository
public interface MetlifeRepository extends JpaRepository<PNBMetlife_IVR_Report ,Long> {

}
