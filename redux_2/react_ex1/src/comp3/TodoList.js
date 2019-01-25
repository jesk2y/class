import React, {Component} from 'react'


class TodoList extends Component{

    removeHandler = (e) => {
        const target = e.target
        this.props.remove(target.getAttribute("data-index"))
    }

    render(){
        const todoLi = this.props.arr.map( (item, index) =>
            <li key={index}>{item}<button data-index={index} onClick={this.removeHandler}>Delete</button></li>)

        return(
            <div>
                {todoLi}
            </div>
        )
    }
}

export default TodoList