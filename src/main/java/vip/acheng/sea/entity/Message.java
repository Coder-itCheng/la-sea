package vip.acheng.sea.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 清风徐来
 * @Date: 2021/8/29 17:04
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;

}
