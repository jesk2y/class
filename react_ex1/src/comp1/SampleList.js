import React, {Component} from 'react'

class SampleList extends Component{

    state = {
        arr: ["AAA","BBB","CCC","DDD"]
    }

    render(){

        const fragment = this.state.arr.map( (value, index) => <li key={index}>{value}</li>) //루프: map

        return(
            <div>
                <h3>SampleList</h3>
                <ul>
                    {fragment}
                </ul>
            </div>
        )
    }
}

export default SampleList