import React, {Component} from 'react'
import {connect} from 'react-redux'

class CotrollPanel extends Component{

    changeColor = (e) => {
        const codeValue = e.target.getAttribute("data-code")
        const actionData = {
            color:codeValue
        }

        this.props.dispatch({type:"change", data:actionData}) //리듀서가 액션을 받음
    }

    render() {
        return(
            <div>
                <h3>CotrollPanel</h3>
                <button data-code="red" onClick={this.changeColor}>Red</button>
                <button data-code="green" onClick={this.changeColor}>Green</button>
                <button data-code="blue" onClick={this.changeColor}>Blue</button>
            </div>
        )
    }
}

export default connect()(CotrollPanel)