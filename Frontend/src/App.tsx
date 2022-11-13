import { BrowserRouter, Routes, Route, redirect } from "react-router-dom";
import { Home } from "./Views/Home";
import { SnackbarProvider } from "notistack";

import "./App.css";
import { Redirect } from "./Components/Redirect";

function App() {
  return (
    <div className="App">
      <SnackbarProvider maxSnack={4} autoHideDuration={2000}>
        <BrowserRouter>
          <Routes>
            <Route index element={<Redirect url="f/home" />} />
            <Route path="f/home" element={<Home />} />
            <Route path="*" element={<h1>U fkn w0t m8?</h1>} />
          </Routes>
        </BrowserRouter>
      </SnackbarProvider>
    </div>
  );
}

export default App;
