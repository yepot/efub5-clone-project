package efub.project.tweeter.user.dto.response;

import efub.project.tweeter.user.domain.User;

import java.time.LocalDateTime;

public record UserResponseDto(
        Long userId,
        String username,
        String handle,
        LocalDateTime createdAt
) {
    public static UserResponseDto from(User user){
        return new UserResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getHandle(),
                user.getCreatedAt()
        );
    }
}
