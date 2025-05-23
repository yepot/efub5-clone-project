package efub.project.tweeter.user.service;

import efub.project.tweeter.tweet.global.exception.dto.ExceptionCode;
import efub.project.tweeter.tweet.global.exception.dto.TweetException;
import efub.project.tweeter.user.domain.User;
import efub.project.tweeter.user.dto.response.UserResponseDto;
import efub.project.tweeter.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 사용자 프로필 조회
    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId){
        User user = userRepository.findByUserId(userId)
                .orElseThrow(()->new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
        return UserResponseDto.from(user);
    }

    // 사용지 ID 찾기
    @Transactional(readOnly = true)
    public User findByUserId(Long userId){
        return userRepository.findByUserId(userId)
                .orElseThrow(()->new TweetException(ExceptionCode.USER_NOT_FOUND));
    }


}
