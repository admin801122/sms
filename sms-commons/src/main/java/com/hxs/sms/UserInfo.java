package com.hxs.sms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 登录id
     */
    private String loginId;

}
