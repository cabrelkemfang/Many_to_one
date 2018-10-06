package com.example.onetomany_annotation.Controller;

import com.example.onetomany_annotation.Model.Comment;
import com.example.onetomany_annotation.Repository.CommentRepository;
import com.example.onetomany_annotation.Repository.PostRepository;
import com.example.onetomany_annotation.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommentController {
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @RequestMapping(value = "/posts/{postId}/comments",method = RequestMethod.GET)
  public Page<Comment> getAllCommentByPostId(@PathVariable Long postId, Pageable pageable){
    return this.commentRepository.findByPostId(postId,pageable);

  }

  @RequestMapping(value = "/posts/{postId}/comments",method = RequestMethod.POST)
  public Comment createComment(@PathVariable Long postId, @Valid @RequestBody Comment comment){
    return postRepository.findById( postId ).map( post -> {
      comment.setPost( post );
      return commentRepository.save( comment );
    } ).orElseThrow(() ->new ResourceNotFoundException("PostId "+postId+ " Not found"  ) );

  }

  @RequestMapping(value = "/posts/comments",method = RequestMethod.GET)
  public Page<Comment> getAllComments(Pageable pageable){
    return commentRepository.findAll( pageable );
  }





}
