package com.vis.ivr.TechMDB2.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vis.ivr.TechMDB2.Dao.TechMRepo;
import com.vis.ivr.TechMDB2.Model.TechM;


@Service
public class TechMService {
	 private static final Logger logger = LoggerFactory.getLogger(TechMService.class);
	 @Autowired
     private TechMRepo techMRepo;
    private List<String> failedDataList;
	public TechMService(TechMRepo techMRepo, List<String> failedDataList) {
		super();
		this.techMRepo = techMRepo;
		}
	
	
   
//	 public void saveTable1(TechM theTechM) {
//	        logger.info("going to save data for callback: {}", theTechM);
//	        if (theTechM!= null) {
//	            try {
//	                techMRepo.save(theTechM);
//	                
//	            } catch (Exception e) {
//	                logger.error("Failed to save data for callback: {}", theTechM, e);
//	                failedDataList.add("callback: " + theTechM.toString());
//	            }
//	        } else {
//	            logger.warn("Null data provided for callback");
//	            // Handle or log the null data case as per your requirements
//	        }
//	 }
//


	public TechM setReport(TechM entity) {
		
		return techMRepo.save(entity);
	}
}
