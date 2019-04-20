package com.example.demo.service;

import com.example.demo.bean.Voter;
import com.example.demo.exception.MyException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.response.PollResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddPollService {
    private CheerleaderService cheerleaderService;
    @Autowired
    private UserMapper userMapper;

    public PollResponse addPoll(int uid, String nickname, int id) throws MyException {
        if (uid == 0) {
            throw new MyException("failed to get id");
        }

        int poll = 0;
        Voter voter = userMapper.findByUid(uid);
        if (voter == null) {
            userMapper.insertUser(uid, nickname, 5, null);
        } else {
            poll = voter.getVotes();
        }

        if (poll < 0 || poll > 5) {
            throw new MyException("run out of polls");
        }
        if (poll < 5) {
            userMapper.insertUser(uid, nickname, poll - 1, "");
            cheerleaderService.addPolls(id);
        }

        voter = userMapper.findByUid(uid);
        poll = voter.getVotes();

        return new PollResponse(200,"success",new Voter(uid, poll, nickname));

    }

}
