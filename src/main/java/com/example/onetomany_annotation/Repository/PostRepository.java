package com.example.onetomany_annotation.Repository;

import com.example.onetomany_annotation.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
