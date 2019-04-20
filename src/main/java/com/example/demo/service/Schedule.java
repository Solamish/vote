package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Schedule {

    @Autowired
    private UserMapper userMapper;

    @Scheduled(cron = "0 0 0 * * ? 2019")
    public void refreshVoter() {
        log.info("start to refresh polls");
        userMapper.refreshPoll();
    }

}
