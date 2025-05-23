package efub.project.tweeter.tweet.global.exception.dto;

import org.springframework.http.HttpStatusCode;

public class TweetException extends RuntimeException {

    private final ExceptionCode exceptionCode;

    public TweetException(ExceptionCode exceptionCode){
        this.exceptionCode = exceptionCode;
    }

    public HttpStatusCode getHttpStatusCode(){
        return exceptionCode.getHttpStatus();
    }

    public String getClientExceptionCodeName(){
        return exceptionCode.getClientExceptionCode().name();
    }


}
