package com.group.libraryapp.dto.book.request;

public class BookReturnRequest {
    private String userName;
    private String bookName;

    // request는 유저로부터 값을 받아오는 것이므로 일단 생성자만.
    public String getUserName(){
        return userName;
    }

    public String getBookName(){
        return bookName;
    }

}
