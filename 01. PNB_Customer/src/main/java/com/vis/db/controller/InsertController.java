package com.vis.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vis.db.AllData.TableData;
import com.vis.db.service.ReportService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/tables")
public class InsertController {
    private static final Logger logger = LoggerFactory.getLogger(InsertController.class);
    private final ReportService reportservice;

    @Autowired
    public InsertController(ReportService reportservice) {
        this.reportservice = reportservice;
    }

    @PostMapping("/callback")
    public ResponseEntity<String> saveTable1Data(@RequestBody TableData tableData) {
        logger.info("Received request to save Table 1 data: {}", tableData);
        reportservice.saveTable1(tableData.getCallback());
        logger.info("Callback data saved successfully: {}", tableData.getCallback());
        return new ResponseEntity<>(" "+tableData.getCallback(), HttpStatus.OK);
    }

    @PostMapping("/chanpart")
    public ResponseEntity<String> saveTable2Data(@RequestBody TableData tableData) {
        logger.info("Received request to save Table 2 data: {}", tableData);
        reportservice.saveTable2(tableData.getChanpart());
        logger.info("Chanpart data saved successfully: {}", tableData.getChanpart());
        return new ResponseEntity<>(" " + tableData.getChanpart(), HttpStatus.OK);
    }

    @PostMapping("/jandk")
    public ResponseEntity<String> saveTable3Data(@RequestBody TableData tableData) {
        logger.info("Received request to save Table 3 data: {}", tableData);
        reportservice.saveTable3(tableData.getJandk());
        logger.info("Jandk data saved successfully: {}", tableData.getJandk());
        return new ResponseEntity<>(" " + tableData.getJandk(), HttpStatus.OK);
    }

    @PostMapping("/metlife")
    public ResponseEntity<String> saveTable4Data(@RequestBody TableData tableData) {
        logger.info("Received request to save Table 4 data: {}", tableData);
        reportservice.saveTable4(tableData.getMetlife());
        logger.info("Metlife data saved successfully: {}", tableData.getMetlife());
        return new ResponseEntity<>(" " + tableData.getMetlife(), HttpStatus.OK);
    }
}
