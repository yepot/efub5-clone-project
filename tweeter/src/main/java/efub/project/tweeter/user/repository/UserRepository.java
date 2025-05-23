package efub.project.tweeter.user.repository;

import efub.project.tweeter.tweet.domain.Tweet;
import efub.project.tweeter.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    // 사용자 ID로 조회
    Optional<User> findByUserId(Long userId);
}
