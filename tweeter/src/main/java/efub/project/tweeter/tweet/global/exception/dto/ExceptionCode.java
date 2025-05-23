package efub.project.tweeter.tweet.global.exception.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {
    // 400 Bad Request
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, ClientExceptionCode.INVALID_PARAMETER, "잘못된 인자입니다."),

    // 404 Not Found
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.USER_NOT_FOUND, "계정이 존재하지 않습니다."),
    TWEET_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.TWEET_NOT_FOUND, "포스트가 존재하지 않습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.COMMENT_NOT_FOUND, "댓글이 존재하지 않습니다."),

    // 409 Conflict
    LIKE_ALREADY_EXISTS(HttpStatus.CONFLICT, ClientExceptionCode.LIKE_ALREADY_EXISTS, "이미 좋아요를 누르셨습니다."),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ClientExceptionCode.INTERNAL_SERVER_ERROR, "예상치 못한 서버에러가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final ClientExceptionCode clientExceptionCode;
    private final String message;

    ExceptionCode(HttpStatus httpStatus, ClientExceptionCode clientExceptionCode, String message) {
        this.httpStatus = httpStatus;
        this.clientExceptionCode = clientExceptionCode;
        this.message = message;
    }
}
