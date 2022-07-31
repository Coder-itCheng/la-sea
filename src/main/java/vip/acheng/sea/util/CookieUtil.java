package vip.acheng.sea.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 清风徐来
 * @Date: 2021/8/26 11:12
 * @Description:
 */

public class CookieUtil {

    public static String getValue(HttpServletRequest request,String name){
        if(request==null||name==null){
            throw new IllegalArgumentException("参数为空！");
        }
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie e : cookies){
                if(e.getName().equals(name)){
                    return e.getValue();
                }
            }
        }
        return null;
    }
}
