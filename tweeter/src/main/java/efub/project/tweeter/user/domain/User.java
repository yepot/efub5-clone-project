package efub.project.tweeter.user.domain;

import efub.project.tweeter.tweet.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // 사용자 이름
    @Column(nullable = false, unique = true)
    private String username;
    
    // 사용자 핸들
    @Column(nullable = false, unique = true)
    private String handle;

    // 가입일
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    // 사용자 비밀번호
    @Column(nullable = false)
    private String password;

    @Builder
    public User(String username, String handle, String password){
        this.username=username;
        this.handle=handle;
        this.password=password;
    }
}
