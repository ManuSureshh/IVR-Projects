package com.vis.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vis.db.modal.*;




	@Repository
	public interface ChanPartRepository extends JpaRepository<ChanPart_IVR_Report ,Long> {
}
