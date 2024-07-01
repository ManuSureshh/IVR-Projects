package com.vis.db.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.vis.db.modal.ChanPart_IVR_Report;
import com.vis.db.modal.JK_IVR_Report;
import com.vis.db.modal.PNBMetlife_CallBack_Report;
import com.vis.db.modal.PNBMetlife_IVR_Report;
import com.vis.db.repository.CallBackRepository;
import com.vis.db.repository.ChanPartRepository;
import com.vis.db.repository.JandKRepository;
import com.vis.db.repository.MetlifeRepository;
import com.vis.db.utils.*;

@Service
public class ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);
    private final CallBackRepository callbackrepository;
    private final ChanPartRepository chanpartrepository;
    private final JandKRepository jandkrepository;
    private final MetlifeRepository metliferepository;
    private final String dumpFolderPath = "dumpfailed";

    private List<String> failedDataList;

    @Autowired
    public ReportService(CallBackRepository callbackrepository, ChanPartRepository chanpartrepository,
            JandKRepository jandkrepository, MetlifeRepository metliferepository,
            @Value("${dump.folder.path}") String dumpFolderPath) {
        this.callbackrepository = callbackrepository;
        this.chanpartrepository = chanpartrepository;
        this.jandkrepository = jandkrepository;
        this.metliferepository = metliferepository;
        this.failedDataList = new ArrayList<>();
    }

    public void saveTable1(PNBMetlife_CallBack_Report callback) {
        logger.info("going to save data for callback: {}", callback);
        if (callback != null) {
            try {
                callbackrepository.save(callback);
                
            } catch (Exception e) {
                logger.error("Failed to save data for callback: {}", callback, e);
                failedDataList.add("callback: " + callback.toString());
            }
        } else {
            logger.warn("Null data provided for callback");
            // Handle or log the null data case as per your requirements
        }
    }

    public void saveTable2(ChanPart_IVR_Report chanpart) {
        logger.info("Saving data for chanpart: {}", chanpart);
        if (chanpart != null) {
            try {
                chanpartrepository.save(chanpart);
            } catch (Exception e) {
                logger.error("Failed to save data for chanpart: {}", chanpart, e);
                failedDataList.add("chanpart: " + chanpart.toString());
            }
        } else {
            logger.warn("Null data provided for chanpart");
        }
    }

    public void saveTable3(JK_IVR_Report jandk) {
        logger.info("Saving data for jandk: {}", jandk);
        if (jandk != null) {
            try {
                jandkrepository.save(jandk);
            } catch (Exception e) {
                logger.error("Failed to save data for jandk: {}", jandk, e);
                failedDataList.add("jandk: " + jandk.toString());
            }
        } else {
            logger.warn("Null data provided for jandk");
        }
    }

    public void saveTable4(PNBMetlife_IVR_Report metlife) {
        logger.info("Saving data for metlife: {}", metlife);
        if (metlife != null) {
            try {
                metliferepository.save(metlife);
            } catch (Exception e) {
                logger.error("Failed to save data for metlife: {}", metlife, e);
                failedDataList.add("metlife: " + metlife.toString());
            }
        } else {
            logger.warn("Null data provided for metlife");
        }
    }

    @Scheduled(fixedDelay = 900000) // Run every 15 minutes
    private void dumpFailedData() {
        if (!failedDataList.isEmpty()) {
            logger.info("Dumping failed data...");
            StringBuilder dataToDump = new StringBuilder();

            for (String failedData : failedDataList) {
                dataToDump.append(failedData).append(System.lineSeparator());
            }

            DateTimeUtils.storeFailedData("FailedData", dataToDump.toString(), dumpFolderPath);
            failedDataList.clear();

            logger.info("Failed data dump complete.");
        }
    }
}
