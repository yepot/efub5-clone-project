package efub.project.tweeter.tweet.dto.request;

import efub.project.tweeter.tweet.domain.Tweet;
import efub.project.tweeter.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetCreateRequestDto(
        @NotNull Long userId,
        @NotBlank(message = "내용을 입력하세요.") String content

        ) {
    public Tweet toEntity(User user){
        return Tweet.builder()
                .user(user)
                .content(content)
                .build();
    }
}
