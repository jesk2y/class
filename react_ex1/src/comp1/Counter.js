import React, { Component } from 'react';

class Counter extends Component{

    constructor(props){
        super(props)
        this.state = {
            count: 0,
            amount: props.amount
        }

    }

    clickHandle = () => {
        this.setState({
            count: this.state.count + this.state.amount //this.props.amount
        })
    }

    render(){
        return(
            <div>
                <h3>{ this.state.count }</h3>
                <button onClick={this.clickHandle}>CLICK</button>
                <hr/>
            </div>
        )
    }
}
export default Counter