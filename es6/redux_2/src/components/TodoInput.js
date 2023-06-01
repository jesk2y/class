import React, {Component} from 'react'
import {connect} from "react-redux";

class TodoInput extends Component{

    clickHandle = (e) => {
        this.props.dispatch({
            type:'ADD',
            data:'...'
        })
    }

    render(){
        return(
            <div>
                <h3>TodoInput</h3>
                <button onClick={this.clickHandle}>CLICK</button>
            </div>
        )
    }
}

export default connect()(TodoInput)