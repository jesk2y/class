import React, {Component} from 'react'
import TodoInput from './TodoInput'
import TodoList from './TodoList'

class TodoComponent extends Component{

    state = {
        todos : ['AAA','BBB','CCC']
    }

    removeTodo = (idx) => {
        this.state.todos.splice(idx,1)
        this.setState({
            todos:this.state.todos
        })
    }

    addTodo = (newTodo) => {

        this.setState({
            todos:[...this.state.todos, newTodo]
        })
    }

    render(){
        return(
            <div>
                <TodoInput add={this.addTodo}/>
                <TodoList arr={this.state.todos} remove={this.removeTodo}/>
            </div>
        )
    }
}

export default TodoComponent