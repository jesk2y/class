import React, { Component } from 'react';
import ControllPanel from "./components/ControllPanel";
import BillBoard from "./components/BillBoard";

class App extends Component {
  render() {
    return (
      <div className="App">
        <ControllPanel/>
        <BillBoard area='서울'/>
          <BillBoard area='대전'/>
          <BillBoard area='부산'/>
          <BillBoard area='광주'/>
      </div>
    );
  }
}

export default App;
