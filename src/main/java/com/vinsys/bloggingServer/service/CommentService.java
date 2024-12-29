package com.vinsys.bloggingServer.service;

import com.vinsys.bloggingServer.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Long postId, String postedBy, String content);
    List<Comment> getCommentsByPostId(Long postId);
}
