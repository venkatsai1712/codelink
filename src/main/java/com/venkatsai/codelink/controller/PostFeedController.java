package com.venkatsai.codelink.controller;

import com.venkatsai.codelink.model.Comment;
import com.venkatsai.codelink.model.Like;
import com.venkatsai.codelink.model.Post;
import com.venkatsai.codelink.service.PostFeedService;
import com.venkatsai.codelink.service.PostService;
import com.venkatsai.codelink.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/feed")
@CrossOrigin("*")
@Slf4j
public class PostFeedController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostFeedService postFeedService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts(@RequestHeader("user_id") Long user_id) {
        return ResponseEntity.ok().body(postFeedService.getPosts(user_id));
    }

}
