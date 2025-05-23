package efub.project.tweeter.tweet.dto.response;

import efub.project.tweeter.tweet.domain.Tweet;

import java.time.LocalDateTime;

public record TweetResponseDto(
        Long tweetId,
        String username,
        String handle,
        String content,
        LocalDateTime createdDate,
        LocalDateTime modifiedDate
) {
    public static TweetResponseDto from(Tweet tweet){
        return new TweetResponseDto(
                tweet.getTweetId(),
                tweet.getUser().getUsername(),
                tweet.getUser().getHandle(),
                tweet.getContent(),
                tweet.getCreatedDate(),
                tweet.getModifiedDate()
        );
    }
}
