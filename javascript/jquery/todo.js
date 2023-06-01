var todoList = (function () {

    function getAll(callback) {
        $.getJSON("http://10.10.10.93:8080/jsonEx/todo/all",function (list) {
            //getJson은 제이슨 문자로 받으면 자동으로 자바스크립트 객체로 바꿔줌
            console.log(list);
            callback(list);
        });
    }

    function modify(obj, callback) {
        $.post("http://10.10.10.93:8080/jsonEx/todo/modify",obj,function (data) {
            callback(data);
            console.log(data.result);
        },"json")
    }

    function remove(pk, callback) {
        $.post("http://10.10.10.93:8080/jsonEx/todo/remove",{pk:pk},function (data) {
            callback(data);
            console.log(data.result);
        },"json")
    }

    function add(obj, callback) { //모듈패턴, 가장 많이쓰임
       $.post("http://10.10.10.93:8080/jsonEx/todo/add",{title:obj},function (data) {
           callback(data.pk);
           console.log(data.pk);
       },"json")
    }
    return {
        add : add,   //전역변수 안써도 밖에서 함수 접근가능(배열엔 접근불가능)
        getAll : getAll,
        remove : remove,
        modify : modify
    }
})();