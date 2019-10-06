package com.kyle.elasticsearch.repositpry;

import com.kyle.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author: Kyle
 * @date: 2019/10/3 -  22:12
 */
public interface BookRepository  extends ElasticsearchRepository<Book,Integer> {

    //定义其他的方法可以参考 https://github.com/spring-projects/spring-data-elasticsearch

    //定义模糊查询
    public List<Book> findByBookNameLike(String bookName);

}
