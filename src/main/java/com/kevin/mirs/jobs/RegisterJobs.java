package com.kevin.mirs.jobs;


import com.kevin.mirs.dao.RegisterSessionDao;
import com.kevin.mirs.enums.RegisterSessionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@Component
@EnableAsync
@EnableScheduling
public class RegisterJobs {

    private static final char STATUS = '1';
    private static final int LIMIT = 1;
    private static final String ORDER_BY = "expire_time";

    // 5分钟
    public static final long RST  = 5 * 60 * 1000;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    RegisterSessionDao registerSessionDao;

    @Async
    @Scheduled(fixedRate = RST)
    // 每隔5分钟定时执行
    public void fixRegisterSession() {
        logger.info("--------------------开始定时任务：规整数据库的注册信息------------------------");

        int offset = 0;
        int total = 0;
        Timestamp expireTime = null;
        while (null != (expireTime = registerSessionDao.getExpireTimeByStatus(STATUS, ORDER_BY, LIMIT, offset))) {
            offset++;
            // 如果超时,则更新状态
            if (expireTime.getTime() < new Date().getTime()) {
                total += registerSessionDao.updateStatusByExpireTime(
                        expireTime,
                        RegisterSessionEnum.REG_EXPIRED.getStatus());
            }
        }

        logger.info("--------------------完成定时任务：规整数据库的注册信息------------------------");
        logger.info("--------------------共更新了" + total + "条信息");
    }

}
