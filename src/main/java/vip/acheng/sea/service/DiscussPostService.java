package vip.acheng.sea.service;

import vip.acheng.sea.entity.DiscussPost;

import java.util.List;

/**
 * @Author: 清风徐来
 * @Date: 2021/8/21 12:18
 * @Description:
 */

public interface DiscussPostService {

    List<DiscussPost> findDiscussPosts(int userId,int offset,int limit,int orderMode);

    int findDiscussPostRows(int userId);

    int addDiscussPost(DiscussPost discussPost);

    DiscussPost findDiscussPostById(int id);

    int updateCommentCount(int id,int commentCount);

    int updateType(int id,int type);

    int updateStatus(int id,int status);

    int updateScore(int id,double score);

}
