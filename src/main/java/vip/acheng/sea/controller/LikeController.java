package vip.acheng.sea.controller;


import vip.acheng.sea.entity.Event;
import vip.acheng.sea.entity.User;
import vip.acheng.sea.event.EventProducer;
import vip.acheng.sea.service.LikeService;
import vip.acheng.sea.util.CommunityConstant;
import vip.acheng.sea.util.CommunityUtil;
import vip.acheng.sea.util.HostHolder;
import vip.acheng.sea.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 清风徐来
 * @Date: 2021/9/1 11:53
 * @Description:
 */

@Controller
public class LikeController implements CommunityConstant {

    @Autowired
    private LikeService likeService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/like")
    @ResponseBody
    public String like(int entityType,int entityId,int entityUserId,int postId){
        User user = hostHolder.getUser();  //TODO 这里暂时不判断user是否登录，之后统一拦截

        //点赞
        likeService.like(user.getId(),entityType,entityId,entityUserId);

        //数量
        long entityLikeCount = likeService.findEntityLikeCount(entityType, entityId);
        //状态
        int entityLikeStatus = likeService.findEntityLikeStatus(user.getId(), entityType, entityId);
        //返回的结果
        Map<String,Object> map = new HashMap<>();
        map.put("likeCount",entityLikeCount);
        map.put("likeStatus",entityLikeStatus);

        //触发点赞事件
        if(entityLikeStatus==1){
            Event event = new Event()
                    .setTopic(TOPIC_LIKE)
                    .setUserId(hostHolder.getUser().getId())
                    .setEntityType(entityType)
                    .setEntityId(entityId)
                    .setEntityUserId(entityUserId)
                    .setData("postId",postId);
            eventProducer.pushEvent(event);
        }

        if(entityType == ENTITY_TYPE_POST) {
            // 计算帖子分数
            String redisKey = RedisKeyUtil.getPostScoreKey();
            redisTemplate.opsForSet().add(redisKey, postId);
        }

        return CommunityUtil.getJSONString(0,null,map);
    }
}
