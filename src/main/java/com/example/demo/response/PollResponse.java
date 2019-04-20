package com.example.demo.response;

import com.example.demo.bean.Voter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PollResponse {
    private int status;
    private String info;
    private Voter voter;
}

