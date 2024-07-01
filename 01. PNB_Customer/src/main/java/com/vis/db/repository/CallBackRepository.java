package com.vis.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vis.db.modal.PNBMetlife_CallBack_Report;





	@Repository
	public interface CallBackRepository extends JpaRepository<PNBMetlife_CallBack_Report ,Long> {
}
