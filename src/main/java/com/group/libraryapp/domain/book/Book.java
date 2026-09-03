package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false) // 어차피 name으로 같고 255자 제한도 같으므로 명시하지 않아도 됨
    private String name;

    protected Book() {

    }

    public Book(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.",name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
