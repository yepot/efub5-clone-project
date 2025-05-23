package efub.project.tweeter.tweet.global.exception.dto;

public enum ClientExceptionCode {
    // 전체
    INTERNAL_SERVER_ERROR,
    INVALID_PARAMETER,

    // User
    USER_NOT_FOUND,

    // Tweet
    TWEET_NOT_FOUND,
    TWEET_USER_MISMATCH,

    // Comment
    COMMENT_NOT_FOUND,

    // TweetLike
    LIKE_NOT_FOUND,
    LIKE_ALREADY_EXISTS,
}
