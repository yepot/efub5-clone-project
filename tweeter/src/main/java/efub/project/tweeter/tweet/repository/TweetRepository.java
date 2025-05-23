package efub.project.tweeter.tweet.repository;

import efub.project.tweeter.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    // tweetId로 tweet 찾기
    Optional<Tweet> findByTweetId(Long tweetId);

    // 최신순으로 모든 게시글 불러오기
    List<Tweet> findByOrderByCreatedDateDesc();

}
