package com.kyle.elasticsearch;

import com.kyle.elasticsearch.bean.Book;
import com.kyle.elasticsearch.repositpry.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot14ElasticsearchApplicationTests {

    @Autowired
    BookRepository bookRepository;



    @Test
    public void test02(){
        //1.给ES中索引保存一个文档
//        Book book = new Book();
//        book.setId(1);
//        book.setBookName("haha");
//        book.setAuthor("Kyle");
//        bookRepository.index(book);

        //进行全文检索,查询的全部结果进行遍历输出
        List<Book> bookNameLike = bookRepository.findByBookNameLike("ha");
        for (Book book : bookNameLike) {
            System.out.println(book);
        }
    }
   /* @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        //1.给ES中索引保存一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("kyle");
        article.setContent("HelloWorld");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("kyle").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试全文检索
    @Test
    public void search(){
        String json = "{\n" +
                " \"query\": {\n" +
                  "\"match\":{\n" +
                   "\"content\":\"hello\"\n" +
                         "}\n"+
                             "}\n"+
                "}";
        //构建索引功能
        Search build = new Search.Builder(json).addIndex("kyle").addType("news").build();

        //执行
        try {
            SearchResult searchResult = jestClient.execute(build);
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
*/


}
