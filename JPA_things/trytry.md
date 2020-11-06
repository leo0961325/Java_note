# Service層

``` java
package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //跟他說這層是service層
public class BookService {

        @Autowired //連接接口
        public BookRepository bookRepository;


        /**
         * 查詢所有書單列表*/

        public List<Book> findAll(){
            return bookRepository.findAll();
        }
        /**
         * 新增一書單的信息*/
        public  Book save(Book book){
                return bookRepository.save(book);
        }

        public Book findOne(long id){

                return bookRepository.getOne(id);
        }

//        public void delete(int id ){
//                bookRepository.delete(id);
//
//        }
}
```
---
# Controller 層
``` java
package com.example.demo.web;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.request.BookRequest;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WebController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/post/{id}/{name}")
    public Object postOnes (@PathVariable("id") long id,
                           @PathVariable("name")String username){

        Map<String , Object> book = new HashMap<>();

        book.put("name" , "廖思婷");
        book.put("age" , "29");
        book.put("author","miko");
        book.put("username" , username);
        book.put("9527",id);



        return book;
    }
    @PostMapping(value = "/get")
    public Object getOne(@RequestParam("name") String name,
                         @RequestParam("age") String age){

        Map<String , Object> book = new HashMap<>();

        book.put("name" , name);
        book.put("age" , age);


        return  book;
    }


    /**
     *
     *  第一種
     *  2020.11.06 我把@Requestbody 拔掉就可以了
     *  然後 回傳值用database
     * **/
    @PostMapping(value = "/books_list")
    public Book postman(Book book){



        return bookService.save(book);
    }
    /***
     * 這是第二種
     * 晚上的時候Postman沒有轉換成json
     * */
    @PostMapping(value = "books/test")
    public Book postmann(@RequestBody BookRequest bookRequest){

        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setLevel(bookRequest.getLevel());
        book.setReview(bookRequest.getReview());
        book.setStatus(bookRequest.getStatus());


        return bookService.save(book);
    }

}

```
