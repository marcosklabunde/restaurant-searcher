import './App.scss';
import FilteredList from "./components/filtered-list/filtered-list.component";

function App() {
  return (
    <div className="app-container">
      <h1 className='title'>Restaurants Searcher</h1>
      <FilteredList/>
    </div>
  );
}

export default App;
