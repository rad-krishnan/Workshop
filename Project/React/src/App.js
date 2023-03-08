import './App.css';
import Orderform from './components/create';
import Table1 from './components/table';
import { BrowserRouter,Routes,Route } from 'react-router-dom';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Routes>
    <Route exact path="/" element={<Orderform/>}></Route>
    <Route exact path="/table" element={<Table1/>}></Route>
    </Routes> 
    </BrowserRouter>

    </div>
  );
}

export default App;
