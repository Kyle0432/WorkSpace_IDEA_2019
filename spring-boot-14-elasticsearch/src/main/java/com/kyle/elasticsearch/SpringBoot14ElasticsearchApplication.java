package com.kyle.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * SpringBoot默认支持两种技术来和ES交互;
 * 1.Jest(默认是不生效的) 需要导入jest工具包 io.searchbox.client.JestClient
 * 2.SpringData Elasticsearch [ES版本可能会不合适]
 *   观察看看你的类库里面的ES是什么版本的,你的ES镜像就下载什么版本的
 *     1.Client 节点信息 clusterNodes、clusterName
 *     2.ElasticsearchTemplate 操作es
 *     3.编写一个 ElasticsearchRepository 的子接口来操作ES
 */
@SpringBootApplication
public class SpringBoot14ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot14ElasticsearchApplication.class, args);
    }

}
