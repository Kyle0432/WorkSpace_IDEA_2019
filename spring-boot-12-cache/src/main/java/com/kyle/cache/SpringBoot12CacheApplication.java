package com.kyle.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 *  1.导入数据库文件 创建出department和employee表
 *  2.创建javaBean封装数据
 *  3.整合Mybatis操作数据库
 *    3.1配置数据源信息
 *    3.2使用注解版的mybatis
 *       3.2.1使用@MapperScan指定需要扫描的mapper接口所在的包
 * 二、快速体验缓存
 *      步骤:
 *          1.开启基于注解的缓存  @EnableCaching
 *          2.标注缓存注解即可
 *            2.1 @Cacheable:主要针对方法配置，能够根据方法的请求参数对其返回的结果进行缓存
 *            2.2 @CacheEvict:清空缓存
 *            2.3 @CachePut:保证方法一定被调用,也就是缓存会不断更新
 * 三、整合Redis作为缓存
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 *     1.安装Redis,使用docker
 *     2.引入redis的starter
 *     3.配置redis
 *     4.测试缓存
 *        原理:CacheManager创建出Cache组件来实际给缓存中存取数据
 *        1.引入redis的starter,容器中保存的是RedisCacheManager;
 *        2.RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件; RedisCache通过操作redis缓存数据
 *        3.默认保存数据 k-v都是 Object,利用序列化保存;如何保存为json
 *            1.引入redis的starter、cacaheManager变为RedisCacheManager;
 */
@MapperScan("com.kyle.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot12CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot12CacheApplication.class, args);
    }

}
