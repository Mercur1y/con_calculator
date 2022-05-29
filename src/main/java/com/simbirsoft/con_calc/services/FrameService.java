package com.simbirsoft.con_calc.services;

import com.simbirsoft.con_calc.entity.Frame;
import com.simbirsoft.con_calc.view.FrameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrameService {

    @Autowired
    FrameRepo frameRepo;

    public Frame findFrameById(Long id) {
        Optional<Frame> frame = frameRepo.findById(id);
        return frame.orElse(new Frame());
    }
}
