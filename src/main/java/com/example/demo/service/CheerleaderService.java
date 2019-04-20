package com.example.demo.service;

import com.example.demo.mapper.CheerleaderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CheerleaderService {
    @Autowired
    private CheerleaderMapper cheerleadersMapper;

    public void insertCheer() {
        log.info("start to insert cheerleaders");

        cheerleadersMapper.insertCheerleader("telecommunication", 0, 1);

        cheerleadersMapper.insertCheerleader("computing", 0, 2);

        cheerleadersMapper.insertCheerleader("automation", 0, 3);

        cheerleadersMapper.insertCheerleader("advanced_manufacturing", 0, 4);

        cheerleadersMapper.insertCheerleader("photoelectricity", 0, 5);

        cheerleadersMapper.insertCheerleader("software", 0, 6);

        cheerleadersMapper.insertCheerleader("bioinformatics", 0, 7);

        cheerleadersMapper.insertCheerleader("science", 0, 8);

        cheerleadersMapper.insertCheerleader("economic_management", 0, 9);

        cheerleadersMapper.insertCheerleader("media_arts", 0, 10);

        cheerleadersMapper.insertCheerleader("foreign_languages", 0, 11);

        cheerleadersMapper.insertCheerleader("international", 0, 12);

        cheerleadersMapper.insertCheerleader("cyberspace_security", 0, 13);

    }

    public void addPolls(int id) {
        log.info("start to poll");
        int count = cheerleadersMapper.findPolls(id);
        if (id > 0 && id < 14) {
            count += 1;
            cheerleadersMapper.updateCheerleader(count, id);
        } else {
            log.error("get wrong param");
        }
    }
}
