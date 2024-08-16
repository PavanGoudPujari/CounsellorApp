package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.model.Counsellor;
import com.ashokit.repo.CounsellorRepo;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private CounsellorRepo counsellorRepo;

    @GetMapping("/test-connection")
    public List<Counsellor> testConnection() {
        return counsellorRepo.findAll();
    }
}

