package efub.project.tweeter.tweet.controller;

import efub.project.tweeter.tweet.dto.request.TweetCreateRequestDto;
import efub.project.tweeter.tweet.dto.response.TweetListResponseDto;
import efub.project.tweeter.tweet.dto.response.TweetResponseDto;
import efub.project.tweeter.tweet.service.TweetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService tweetService;

    // 트윗 생성
    @PostMapping
    public ResponseEntity<TweetResponseDto> createTweet(@Valid @RequestBody TweetCreateRequestDto requestDto) {
        TweetResponseDto response = tweetService.createTweet(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 트윗 목록 조회
    @GetMapping
    public ResponseEntity<TweetListResponseDto> getAllTweet(){
        return ResponseEntity.ok(tweetService.getAllTweets());
    }

    // 개별 트윗 조회
    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetResponseDto> getTweet(@PathVariable("tweetId") Long tweetId){
        return ResponseEntity.ok(tweetService.getTweet(tweetId));
    }

    // 트윗 삭제
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<String> deleteTweet(@PathVariable("tweetId") Long tweetId,
                                              @RequestHeader("Auth-Id") Long userId,
                                              @RequestHeader("Auth-Password") String password){
        tweetService.deleteTweet(tweetId, userId, password);
        return ResponseEntity.ok("트윗이 성공적으로 삭제되었습니다.");
    }
}
