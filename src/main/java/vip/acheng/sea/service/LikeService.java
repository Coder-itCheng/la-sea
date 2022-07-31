package vip.acheng.sea.service;

/**
 * @Author: 清风徐来
 * @Date: 2021/9/1 11:21
 * @Description:
 */


public interface LikeService {

    void like(int userId,int entityType,int entityId,int entityUserId);

    long findEntityLikeCount(int entityType,int entityId);

    int findEntityLikeStatus(int userId,int entityType,int entityId);

    int findUserLikeCount(int userId);

}
