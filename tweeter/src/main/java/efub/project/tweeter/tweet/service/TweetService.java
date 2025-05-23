package efub.project.tweeter.tweet.service;

import efub.project.tweeter.tweet.domain.Tweet;
import efub.project.tweeter.tweet.dto.request.TweetCreateRequestDto;
import efub.project.tweeter.tweet.dto.response.TweetListResponseDto;
import efub.project.tweeter.tweet.dto.response.TweetResponseDto;
import efub.project.tweeter.tweet.dto.summary.TweetSummary;
import efub.project.tweeter.tweet.repository.TweetRepository;
import efub.project.tweeter.user.domain.User;
import efub.project.tweeter.user.dto.response.UserResponseDto;
import efub.project.tweeter.user.repository.UserRepository;
import efub.project.tweeter.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final UserService userService;
    private final TweetRepository tweetRepository;

    // 트윗 생성
    @Transactional
    public TweetResponseDto createTweet(TweetCreateRequestDto requestDto){
        Long userId = requestDto.userId();
        User user = userService.findByUserId(userId);

        Tweet tweet = requestDto.toEntity(user);
        tweetRepository.save(tweet);

        return TweetResponseDto.from(tweet);
    }

    // 모든 트윗 조회
    @Transactional(readOnly = true)
    public TweetListResponseDto getAllTweets(){
        List<Tweet> tweetList = tweetRepository.findByOrderByCreatedDateDesc();
        return TweetListResponseDto.from(tweetList);
    }

}
