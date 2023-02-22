package me.whiteship.java8to11.optional;

import java.util.Optional;

public class OnlineClass {

    private Integer id;
    private String title;
    private boolean closed;
    private Progress progress;

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

    /**
     * 자바 8 이전에는 null 이 있으면 exception 을 던짐
     * 에러가 발생하면 자바는 에러 이전까지의 정보를 담아서 리소스로 쓰게 됨
     * 이래서 필요한 경우에만 에러를 처리해야지 로직을 처리할때 쓰는 에러는 좋은 습관은 아님
     */
//    public Progress getProgress() {
//        if (this.progress == null) {
//            throw new IllegalStateException();
//        }
//        return progress;
//    }

    /**
     * 자바 8 이후에는 리턴타입에 사용, 리턴 타입 이외에도 쓸 수 있지만
     * 리턴타입으로만 쓰는 것이 권장사항임
     * 메소드 매개변수로 쓸 수 있지만
     * 리턴에서는 Option 을 리턴해야함(절대 null 을 리턴하면 안됨)
     * 리턴할게 없으면 Optional.empty(); 를 이용할 것!
     * @return
     */
    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }
    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    /**
     * @param progress
     * 이렇게 매개변수에서 Optional 을 사용하면 위험함
     * null 을 호출 할 수 있기 때문에, 파라미터로 계속 null 을 보내줄 수 있음
     * Optional 의 의미가 없어짐, 추가적으로 null 체크를 해야함
     */
    public void setProgress(Optional<Progress> progress) {
        if(progress != null) {
            progress.ifPresent((p) -> this.progress = p);
        }
    }
}
