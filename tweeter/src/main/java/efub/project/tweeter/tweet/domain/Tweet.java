package efub.project.tweeter.tweet.domain;

import efub.project.tweeter.tweet.global.domain.BaseEntity;
import efub.project.tweeter.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    // 사용자(글쓴이)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // 트윗 내용
    private String content;
    
    // 생성일, 수정일은 BaseEntity에

    @Builder
    public Tweet(User user, String content){
        this.user=user;
        this.content=content;
    }

}
