package com.example.demo.service;

import com.example.demo.repository.CommentRepository;
import com.example.demo.util.Ut;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public Comment getCommentById(int id) {
        return commentRepository.getCommentById(id);
    }

    public ResultData writeComment(int memnberId,String commentBody) {
        commentRepository.writeComment(commentBody);

        int id = commentRepository.getLastInsertId();

        return ResultData.from("S-1", com.example.demo.util.Ut.f("%d번 댓글이 등록되었습니다", id), "등록 된 댓글 id", id);
    }
    

    
}