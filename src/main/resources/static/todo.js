let index = {
    init: function() {
        $("#btn-todo").on("click", () => {
            this.todo();
        });
    },

    todo: function() {
        let data = {
            todo: $("#todo").val()
        };


        // 약간 느낌이 fetch().then().... 그거 같은데 ?
        $.ajax({
            type:"POST",
            url:"/api/todo",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("일정이 추가되었습니다.");
            location.href="/todolist";
        }).fail(function(error){
            alert(JSON.stringfy(error));
        });
    },

    deleteById: function(id) {
        $.ajax({
            type: "DELETE",
            url: "/api/todo/"+id,
            dataType:"json"
        }).done(function(resp){
            alert("일정을 목록에서 삭제합니다.");
            location.href="/todolist";
        }).fail(function(error) {
            alert(JSON.stringfy(error));
        });
    },


}


index.init();


// Mustache로부터 받은 문자열을 JavaScript Date 객체로 변환
var createdAt = new Date("{{createdAt}}"); 

// getMonth()는 0부터 시작하므로 1을 더해줌
var year = createdAt.getUTCFullYear();
var month = createdAt.getMonth() + 1; 
var date = createdAt.getDate();
