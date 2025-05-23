package efub.project.tweeter.tweet.dto.summary;

import efub.project.tweeter.tweet.domain.Tweet;

public record TweetSummary(Long tweetId) {
    public static TweetSummary from(Tweet tweet){
        return new TweetSummary(
                tweet.getTweetId()
        );
    }
}
