import React from "react";
import List from "./components/List";
import dummyItems from "./items.json";
import EmptyState from './components/EmptyState';
import "./App.css";

export default class App extends React.Component {
  state = {
    favItems: [],
    showFav: false,
    isLight: true
  };
  handleChange = () => this.setState({ showFav: !this.state.showFav});
  render() {
    const {favItems} = this.state;
    return (
      <div className={this.state.isLight ? 'lightMode' : 'darkMode'}> 
      <div className="container-fluid">
        <h1 className="text-center">
          Welcome!
          <small>Class-based</small>
        </h1>
        <div className="row justify-content-center align-items center">
            <input type="checkbox" onChange={this.handleChange}/>
            <small>Show Favorite</small>
        </div>

        <div className ="row">
          <div className = "col-sm" align="right">
            <input type="checkbox" onChange={this.mode}/>
            <small> Dark Mode </small>
          </div>
        </div>

        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
              title="Our Menu"
              items={dummyItems}
              onItemClick={this.handleItemMenuClick}
              inputType = "hidden"
              />
            </div>
            {this.myFav(this.state.showFav)}
          </div>
        </div>
      </div>
      </div>
    );
  }

  mode = () => {
    if (this.state.isLight) {
      this.setState({ isLight: false})
    } else {
      this.setState({ isLight: true})
    }
  };

  handleItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);
    this.setState({ favItems: newItems });
  };

  handleItemMenuClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    this.setState({ favItems: newItems });
  };

  myFav = showFav => {
    if (showFav === true && this.state.favItems.length > 0) { return(
            <div className="col-sm">
              <List
                title="My Favorite"
                items={this.state.favItems}
                onItemClick={this.handleItemClick}
                inputType="checkbox"
              />
          </div>
      );
    } else if (showFav === true && this.state.favItems.length === 0) {
      return(
        <div className="col-sm">
          <EmptyState
              title="My Favorite"
          />
        </div>
      );
    }
  }
}
