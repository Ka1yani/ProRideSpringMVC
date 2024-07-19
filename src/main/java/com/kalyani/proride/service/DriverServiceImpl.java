package com.kalyani.proride.service;

import com.kalyani.proride.model.Driver;
import com.kalyani.proride.repository.DriverRepoImpl;
import com.kalyani.proride.service.interfaces.DriverService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepoImpl driverRepo;

    @Override
    @Transactional
    public void registerDriver(Driver driver ) {
        driver.setRegistrationDate(LocalDateTime.now());
        driver.setName("driver_"+driver.getPhoneNumber().substring(6,10));
        driverRepo.save(driver);
    }
}
