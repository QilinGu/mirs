package com.kevin.mirs.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface EmailVerifyDao {


    /**
     * 添加一条邮件验证记录
     * @param email 邮件
     * @param createTime 创建时间
     * @param expireTime 过期时间
     * @param channel 验证渠道
     * @param verifyCode 验证码
     * @param verifyType 验证类型
     * @param requestIp 请求IP
     * return 1:添加成功；0：添加失败
     */
    int add(@Param("email") String email,
            @Param("createTime") Timestamp createTime,
            @Param("expireTime") Timestamp expireTime,
            @Param("channel") Character channel,
            @Param("verifyCode") String verifyCode,
            @Param("verifyType") Character verifyType,
            @Param("requestIp") String requestIp);

    /**
     *  通过email更新注册状态
     * @param email 邮箱
     * @param status 状态
     * @return 1：更新成功；0：更新失败
     */
    int updateStatusByEmail(@Param("email") String email,
                            @Param("status") Character status);

    /**
     * 根据时间戳批量更新信息
     * @param expireTime 注册信息过期时间
     * @param status 状态
     * @return 更新的条数
     */
    int updateStatusByExpireTime(@Param("expireTime")Timestamp expireTime,
                                 @Param("status") Character status);

    /**
     * 根据邮箱获取最近的一条注册信息
     * @param email 邮箱
     * @return 该注册邮箱的失效时间
     */
    Timestamp getExpireTimeByEmail(@Param("email") String email);


    /**
     * 通过注册状态获取注册过期时间
     * @param status 注册状态
     * @param orderBy 排序方式
     * @param limit 限制条数
     * @param offset 偏移量
     * @return 时间戳 或者 null
     */
    Timestamp getExpireTimeByStatus(@Param("status") Character status,
                                    @Param("orderBy") String orderBy,
                                    @Param("limit") int limit,
                                    @Param("offset") int offset);
}
