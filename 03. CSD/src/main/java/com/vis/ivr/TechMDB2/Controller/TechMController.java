package com.vis.ivr.TechMDB2.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vis.ivr.TechMDB2.Model.TechM;
import com.vis.ivr.TechMDB2.Service.TechMService;



@RestController
public class TechMController 
{
	private static final Logger logger = LoggerFactory.getLogger(TechMController.class);
	@Autowired
   private TechMService techMService;
//	public TechMController(TechMService techMService) {
//		super();
//		this.techMService = techMService;
//	}
//	
//	@PostMapping("/employee")
//    public ResponseEntity<String> saveTable1Data(@RequestBody TechM theTechM) {
//        logger.info("Received request to save Table 1 data: {}", theTechM);
//       techMService.saveTable1(theTechM);
//        logger.info("Callback data saved successfully: {}", theTechM);
//       return new ResponseEntity<>(" "+theTechM, HttpStatus.OK);
//   }
	
	@PostMapping("/save")
	public TechM saveReport(@RequestBody TechM entity) 
	{
		logger.info("Received request to save data: {}", entity);
		return techMService.setReport(entity);
		
		
	}
}