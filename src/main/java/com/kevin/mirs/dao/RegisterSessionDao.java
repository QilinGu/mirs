package com.kevin.mirs.dao;


import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface RegisterSessionDao {

    /**
     * 添加一条注册信息
     * @param createTime 注册信息创建时间
     * @param email 注册邮箱
     * @param clientIp 注册ip
     * @param expireTime 注册信息失效时间
     * @return 1：成功；0：失败
     */
    int add(@Param("createTime") Timestamp createTime,
            @Param("email") String email,
            @Param("clientIp") String clientIp,
            @Param("expireTime") Timestamp expireTime);


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
