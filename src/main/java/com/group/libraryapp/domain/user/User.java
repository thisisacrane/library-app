package com.group.libraryapp.domain.user;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String name;

    private Integer age;

    // User 1명은 여러개의 UserLoanHistory 들고 있을 수 있음.
    // OneToMany는 대응되는 칼럼을 찾지 않는 대신 상대 테이블에서 외래키 칼럼(대여건인 내가 어떤 유저의 대여건인)이 있어야함.
    // 관계의 주인이 UserLoanHistory의 user 필드임을 알려주기 위해 mappedBy를 사용함(mappedBy가 없으면 관계가 여러 쌍일때 분간하기 어려움).
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {}

    public User(String name, Integer age) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있습니다");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void loanBook(String bookName) {
        this.userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream().filter(history -> history.getBookName().equals(bookName)).findFirst().orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();
    }
}
