package vip.acheng.sea.service;

import vip.acheng.sea.entity.Comment;

import java.util.List;

/**
 * @Author: 清风徐来
 * @Date: 2021/8/28 19:45
 * @Description:
 */

public interface CommentService {

    List<Comment> findCommentsByEntity(int entityType, int entityId, int offset, int limit);

    int findCommentCount(int entityType, int entityId);

    int addComment(Comment comment);

    Comment findCommentById(int id);

}
