import React, {Component} from 'react'


class TodoInput extends Component{

    clickHandle = () => {
        const input = this.input
        this.props.add(input.value)
        input.value=''
    }

    render(){
        return(
            <div>
                <small>Todo Input</small>
                <input type='text' ref={(ref) => this.input = ref}></input>
                <button onClick={this.clickHandle}>ADD</button>
            </div>
        )
    }
}

export default TodoInput