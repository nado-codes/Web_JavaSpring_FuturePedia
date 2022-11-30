import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useEffect, useState } from "react";
import { Home } from "./Views/Home";
import { SnackbarProvider } from "notistack";

import "./App.css";
import { Redirect } from "./Components/Redirect";
import { Article } from "./Views/Article";
import axios from "axios";

function App() {
  const [isLoaded, setIsLoaded] = useState(false);

  useEffect(() => {
    axios.defaults.baseURL = "http://localhost:8080/";
    setIsLoaded(true);
  }, []);

  return (
    <div className="App">
      {isLoaded && (
        <SnackbarProvider maxSnack={4} autoHideDuration={2000}>
          <BrowserRouter>
            <Routes>
              <Route index element={<Redirect url="f/home" />} />
              <Route path="f/home" element={<Home />} />
              <Route path="f/article/*" element={<Article />} />
              <Route path="*" element={<h1>U fkn w0t m8?</h1>} />
            </Routes>
          </BrowserRouter>
        </SnackbarProvider>
      )}
    </div>
  );
}

export default App;
