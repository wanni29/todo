package wanni30.wakanda.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

    // JpaRepository<Todo, Integer> 이 부분 다시 정리해보자
    // -> todo 는 클래스 명을 적는 자리야
    // -> Integer는 프라이머리키가 되는 값을 적는자리야
    
}
