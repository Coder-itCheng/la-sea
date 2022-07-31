package vip.acheng.sea.service;

import java.util.Date;

/**
 * @Author: 清风徐来
 * @Date: 2021/9/17 16:04
 * @Description:
 */
//网站数据统计
public interface DataService {

    void recordUV(String ip);

    long calculateUV(Date start,Date end);

    void recordDAU(int userId);

    long calculateDAU(Date start,Date end);

}
