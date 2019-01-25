import React, {Component} from 'react'
import RefInner from './RefInner'

class RefOuter extends Component {

    state = {
        content:"Outer Content"
    }

    changeHandler = (e) => {
        console.log("outer change click...")

        this.setState({
            content:"Change.................."
        })

    }

    render() {
        return (
            <div>
                <h2>바깥쪽 부모 컴포넌트</h2>
                <button onClick={this.changeHandler}>Change</button>
                <RefInner title={this.state.content} />
            </div>
        )
    }

}

export default RefOuter