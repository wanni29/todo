package wanni30.wakanda.todo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Table(name = "todo_tb")
@Data // Getter, Setter, equals, hashCode, toString 메서드가 자동으로 생성
@Entity // @Entity 어노테이션이 적용된 클래스는 데이터베이스 내에 테이블로 매핑
public class Todo {

    @Id // 프라이머리 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment
    private int id;

    private String todo;


    // 이거 쌤이랑 봤던 어노테이션이네 ? 기능 다시한번만 더 정리하지
    // CreationTimestamp :엔티티 객체가 데이터베이스에 저장될 때 해당 객체가 생성된 시간을 자동으로 기록하는 데 사용
    @CreationTimestamp 
    private Timestamp createdAt;



    @Builder
    public Todo(int id, String todo, Timestamp createdAt) {
        this.id = id;
        this.todo = todo;
        this.createdAt = createdAt;
    }


   

    // builder 이것도 넘나 편한것
    



    
    
}
