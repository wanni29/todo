package wanni30.wakanda.todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// 뭐지? 갑자기 어노테이션 다 때려박는 느낌인데 ?
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    int status;
    T data;
}
