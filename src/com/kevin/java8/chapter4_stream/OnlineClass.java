package com.kevin.java8.chapter4_stream;

import com.kevin.java8.chapter5_optional.Progress;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

//    public Progress getProgress() {
//        return progress;
//    }

    //Optional 은 여러곳에서 다 사용가능하지만 return 타입으로만 사용하는것이 권장사항.
    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
        //.of() = 안의 객체가 null일수 없다.
        //.ofNullable() = 안의 객체가 null일수 있다.
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
