import React, {useState} from 'react'
import ModelView from './ModelView'
import UploadView from './UploadView'
import './App.css';

function App() {
  const [classes, setClasses] = useState([])

  return (
    
    <div className="App">
      <button>Download</button>
      <UploadView setClasses={setClasses}/>
      <ModelView classes={classes}/>
    </div>
  );
}

export default App;
