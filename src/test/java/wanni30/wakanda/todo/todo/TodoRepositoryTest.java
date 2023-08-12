package wanni30.wakanda.todo.todo;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import wanni30.wakanda.todo.Todo;
import wanni30.wakanda.todo.TodoRepository;

@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    // 얘는 필요없긴한데 나중에 세이브역할이 아닌 업데이트 역할을 수행하기위해서
    // 테스트파일 상의 테스팅은 트랜잭션이 되기전에 ? 롤백이 일어나서
    // 데이터가 수정이 되지 않고 그대로 끝나버려서
    // 버퍼에 persistence context에 있는 값을들 강제로 밀어넣어버리려고 
    // 주입 받는 거임
    @Autowired
    private EntityManager em;

    @Test
    public void save_test() {
        Todo todo = Todo.builder()
        .todo("턱걸이 5세트")
        .build();

        Todo todo2 = todoRepository.save(todo);
        Optional<Todo> todo3 = todoRepository.findById(1);

        Assertions.assertThat(todo2.getTodo()).isSameAs(todo3.get().getTodo());
    }

    // 페이징은 어떻게 테스팅 해야되지 ? 감이 안오네..
    
}
