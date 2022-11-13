import React from "react";
import logo from "../Res/Logo128.png";
import "../App.css";

export const Home: React.FC = () => {
  return (
    <header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
      <h3>Loading...</h3>
    </header>
  );
};
