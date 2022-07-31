package vip.acheng.sea.dao.elasticsearch;

import vip.acheng.sea.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: 清风徐来
 * @Date: 2021/9/14 15:31
 * @Description:
 */
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {

}
