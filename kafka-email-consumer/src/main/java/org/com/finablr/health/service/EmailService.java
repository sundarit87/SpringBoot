package org.com.finablr.health.service;

import org.com.finablr.health.entity.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendSimpleMessage(UserDto input);
}
