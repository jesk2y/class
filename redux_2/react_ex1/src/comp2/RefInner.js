import React, {Component} from 'react'


class RefInner extends Component {


    render(){
        return (
            <div >
                <h3>안쪽 컴포넌트</h3>
                <div>{this.props.title}</div>
            </div>
        )
    }

}

export default RefInner