package wanni30.wakanda.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // 데이터만 주고받는 Ajax통신이기에 레스트 컨트롤러를 사용했네 ?
public class TodoApiController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/api/todo")
    public ResponseDTO<Integer> save(@RequestBody Todo todo) {
        todoService.save(todo);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/todo/{id}")
    public ResponseDTO<Integer> deleteById(@PathVariable int id) {
        todoService.delete(id);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }
    
}
