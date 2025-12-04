package com.venkatsai.codelink.repositories;

import com.venkatsai.codelink.model.Like;
import com.venkatsai.codelink.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndPostId(Long userId, Long postId);
}
