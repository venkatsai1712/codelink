package com.venkatsai.codelink.repositories;

import com.venkatsai.codelink.model.Post;
import com.venkatsai.codelink.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p WHERE p.user IN :users ORDER BY p.createdDate DESC")
    List<Post> getFeedPosts(List<User> users);

}
