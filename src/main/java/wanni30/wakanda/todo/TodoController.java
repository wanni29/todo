package wanni30.wakanda.todo;

import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todolist") // model 이나 HttpServletRequest 나 둘이 가방이라는 역할은 똑같은거야 :)
    public String todo(Model model,
            @PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable, Todo todo) {
        model.addAttribute("todoList", todoService.todolist(pageable));
        return "/todo";
    }

}
