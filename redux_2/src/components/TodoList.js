import React, {Component} from 'react'
import {connect} from "react-redux";

class TodoList extends Component{


    render(){
        return(
            <div>
                <h3>TodoList</h3>
                <h4>{this.props.arr}</h4>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {arr:state}
}

export default connect(mapStateToProps)(TodoList)