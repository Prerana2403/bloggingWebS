//package com.vinsys.bloggingServer.controller;
//
//import com.vinsys.bloggingServer.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/")
//@CrossOrigin
//public class CommentController {
//
//    @Autowired
//    private CommentService commentService;
//
//    @PostMapping("comments/create")
//    public ResponseEntity<?> createComment(@RequestParam Long postId,
//                                           @RequestParam String postedBy,
//                                           @RequestBody String content) {
//        try {
//
//            return ResponseEntity.ok(commentService.createComment(postId, postedBy, content));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
//        }
//    }
//}
//
//@GetMapping("comments/{postId}")
//public ResponseEntity<?> getCommentsPostId(@PathVariable Long postId){
//    try{
//        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
//    }catch (Exception e){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
//
//    }
//}

package com.vinsys.bloggingServer.controller;

import com.vinsys.bloggingServer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Endpoint to create a comment
    @PostMapping("comments/create")
    public ResponseEntity<?> createComment(@RequestParam Long postId,
                                           @RequestParam String postedBy,
                                           @RequestBody String content) {
        try {
            // Call the service method to create a comment
            return ResponseEntity.ok(commentService.createComment(postId, postedBy, content));
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    // Endpoint to get comments by post ID
    @GetMapping("comments/{postId}")
    public ResponseEntity<?> getCommentsByPostId(@PathVariable Long postId) {
        try {
            // Call the service method to retrieve comments for a given post
            return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
