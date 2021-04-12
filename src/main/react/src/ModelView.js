import './App.css';
import nomnoml  from 'nomnoml'

const convertClasses = (classes) => {
  var string = ""

  classes.forEach(customClass => {
    string += "[" + customClass.name + "|"
    customClass.attributes.forEach(attributes =>{
        string += attributes.name + " : " + attributes.type + ";"
    })
    string = string.slice(0,-1)
    string += "|"
    customClass.methods.forEach(methods =>{
      string += methods.name + "() : " + methods.returnType + ";"
    })
    string = string.slice(0,-1)
    string += "]\n" 
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