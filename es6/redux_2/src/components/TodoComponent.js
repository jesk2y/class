import React, {Component} from 'react'
import TodoInput from "./TodoInput";
import TodoList from "./TodoList";

class TodoComponent extends Component{
    render(){
        return(
            <div>
                <h3>TodoComponent</h3>
                <TodoInput/>
                <TodoList/>
            </div>
        )
    }
}

export default TodoComponent