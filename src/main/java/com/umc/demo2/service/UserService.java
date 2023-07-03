package com.umc.demo2.service;

import com.umc.demo2.domain.User;
import com.umc.demo2.dto.UserReq;
import com.umc.demo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User update(Long userId, UserReq.UpdateNickname request){
        User user = userRepository.findById(userId).get();
        user.update(request.getNickname());
        return user;

    }


}
