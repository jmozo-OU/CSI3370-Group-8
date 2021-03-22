import './App.css';
import React from 'react'
import nomnoml  from 'nomnoml'


class ModelView extends React.Component {
    render() {
      var canvas = document.getElementById('target-canvas');
      var source = '[nomnoml] -> [awesome]';
      nomnoml.draw(canvas, source);
      return null; 
    }
  
} 

export default ModelView;