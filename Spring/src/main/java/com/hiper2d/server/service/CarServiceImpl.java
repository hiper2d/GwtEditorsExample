package com.hiper2d.server.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public String sayBeep() {
        return "Beeeep!";
    }
}
