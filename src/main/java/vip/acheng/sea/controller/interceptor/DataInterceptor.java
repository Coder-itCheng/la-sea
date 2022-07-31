package vip.acheng.sea.controller.interceptor;

import vip.acheng.sea.entity.User;
import vip.acheng.sea.service.DataService;
import vip.acheng.sea.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 清风徐来
 * @Date: 2021/9/18 14:59
 * @Description:
 */
//用于网站数据统计
@Component
public class DataInterceptor implements HandlerInterceptor {

    @Autowired
    private DataService dataService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //存入统计UV
        String ip = request.getRemoteHost();
        dataService.recordUV(ip);

        //存入统计DAU
        User user = hostHolder.getUser();
        if(user!=null){
            dataService.recordDAU(user.getId());
        }
        return true;
    }

}
