package com.venkatsai.codelink.service;

import com.venkatsai.codelink.dto.PostDetailsResponseDTO;
import com.venkatsai.codelink.model.Post;
import com.venkatsai.codelink.model.User;
import com.venkatsai.codelink.repositories.PostRepository;
import com.venkatsai.codelink.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostFeedService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public List<PostDetailsResponseDTO> getPosts(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            List<PostDetailsResponseDTO> posts = new ArrayList<>();
            List<Post> p = postRepository.getFeedPosts(user.get().getFollowings());
            for(Post post : p){
                posts.add(PostDetailsResponseDTO.builder()
                        .id(post.getId())
                        .content(post.getContent())
                        .photo(post.getPhoto())
                        .firstName(post.getUser().getFirstName())
                        .lastName(post.getUser().getLastName())
                        .username(post.getUser().getUsername())
                        .profilePicture(post.getUser().getProfilePicture())
                        .likes(post.getLikes())
                        .comments(post.getComments())
                        .userId(post.getUser().getId())
                        .createdDate(post.getCreatedDate())
                        .build());
            }
            return posts;
        }
        return null;
    }
}
