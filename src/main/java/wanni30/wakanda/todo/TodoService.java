package wanni30.wakanda.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 트랜잭션을 관리하는 어노테이션
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional // 임포트 주의하세용~
    public void save(Todo todo) { 
        todoRepository.save(todo);
        // 헝.... 너무 편해 ㅠㅠㅠㅠ
    }

    @Transactional // 이 기능이 있으면 page 기능을 굳이 내가 안만들어도 되네? 더 편해지겠다.
    public Page<Todo> todolist(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    @Transactional // 흐허ㅠㅜㅠㅜㅠ 넘 좋아
    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    // 서비스 기능이 되는지 테스팅 해볼끼 ?
    // 이번에 배운것을 바탕으로 + Assertions 까지 이용하면 딱 인데 ? ㅋㅋㅋ
    
}
