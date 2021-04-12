import './App.css';
import nomnoml  from 'nomnoml'

const convertClasses = (classes) => {
  var string = ""

  classes.forEach(customClass => {
    string += "[" + customClass.name + "]\n"

    
  });

  return string
}

export default function ModelView(props) {
  const {classes} = props

  console.log(classes)
  var source = convertClasses(classes)
  var canvas = document.getElementById('target-canvas')

  console.log(source)
  nomnoml.draw(canvas, source);

  return null
}