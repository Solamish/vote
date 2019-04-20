package com.example.demo.controller;

import com.example.demo.exception.MyException;
import com.example.demo.response.PollResponse;
import com.example.demo.service.AddPollService;
import com.example.demo.service.CheerleaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddPollController {
    @Autowired
    private AddPollService addPollService;
    private CheerleaderService cheerleaderService;

    @GetMapping("/cheering_vote/addpoll")
    public PollResponse addPoll(int uid, String nickname, int id) throws MyException {
        if (nickname.equals("")) {
            log.error("nickname is null");
            throw new MyException("failed");
        } else {
            cheerleaderService.insertCheer();
            PollResponse pollResponse = addPollService.addPoll(uid, nickname, id);
            return pollResponse;
        }
    }

}
