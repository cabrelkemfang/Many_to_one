package com.example.onetomany_annotation.Controller;

import com.example.onetomany_annotation.Model.Post;
import com.example.onetomany_annotation.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

  @Autowired
  PostRepository postRepository;

  @RequestMapping(value="/posts",method = RequestMethod.GET)
  public Page<Post> getAllPosts(Pageable pageable){
    return postRepository.findAll(pageable);
  }

  @RequestMapping(value = "/posts",method = RequestMethod.POST)
  public Post createPost(@RequestBody Post post){
    return postRepository.save( post );
  }

  @RequestMapping(value = "/posts/{postId}" ,method = RequestMethod.PUT)
  public void createdPost(@PathVariable Long postId ,@RequestBody Post postRequest){
    if(!postRepository.existsById(postId)){
      //throw new
    }else{
      postRepository.save( postRequest );
    }
  }

@RequestMapping(value = "/posts/{postId}",method = RequestMethod.DELETE)
  public void deletePost(@PathVariable Long postId){
   if(!postRepository.existsById( postId )){
     this.postRepository.deleteById( postId );
   }
}


}
