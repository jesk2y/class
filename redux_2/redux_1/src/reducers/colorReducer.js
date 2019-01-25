const colorReducer = (state = {color:'AAA'}, action) => {

    if(action.data){
        return action.data
    }

    return {color:'AAA'}
}

export default colorReducer