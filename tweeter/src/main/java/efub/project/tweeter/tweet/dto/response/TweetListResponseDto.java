package efub.project.tweeter.tweet.dto.response;

import efub.project.tweeter.tweet.domain.Tweet;
import efub.project.tweeter.tweet.dto.summary.TweetSummary;

import java.util.List;

public record TweetListResponseDto(
        List<TweetResponseDto> tweets
) {
    public static TweetListResponseDto from(List<Tweet> tweets) {
        List<TweetResponseDto> responseDtos = tweets.stream()
                .map(TweetResponseDto::from)
                .toList();
        return new TweetListResponseDto(responseDtos);
    }
}
