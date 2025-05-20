package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Comment;
@Mapper
public interface CommentRepository {
    public Comment getCommentById(int id);

    public int writeComment(String commentBody);

    public int getLastInsertId();
}