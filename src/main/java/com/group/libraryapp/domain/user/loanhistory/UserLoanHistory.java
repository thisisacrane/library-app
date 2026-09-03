package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import jakarta.persistence.*;

@Entity // 데이터베이스의 테이블과 직접 매핑되는 자바 클래스
public class UserLoanHistory {

    @Id // 이 컬럼이 id입니다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 이 id 값은 내가 안 채울 테니 DB가 알아서 만들어줘
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne // bigint userId를 user라는 객체에 매핑 못 함. -> 한 학생이 여러 개의 UserLoanHistory를 가질 수 있으므로 ManyToOne
    private User user;

    private String bookName;

    public String getBookName() {
        return bookName;
    }

    private boolean isReturn;

    protected UserLoanHistory() {}

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
        this.isReturn = true;
    }


}
