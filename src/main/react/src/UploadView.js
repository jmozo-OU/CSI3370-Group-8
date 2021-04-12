import './App.css';
import React, {useState} from 'react'

export default function UploadView(props) {
    const [files, setFiles] = useState([])
    const {setClasses} = props

    function handleSubmit(event) {
        var formData = new FormData();
        for(var index = 0; index < files.length; index++) {
            formData.append("files", files[index]);
        }
    
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/reverse-uml/v1/multiple");
    
        xhr.onload = function() {
            //console.log(xhr.responseText);
            var response = JSON.parse(xhr.responseText);
            if(xhr.status === 200) {
                console.log(response)
                setClasses(response)
            } else {
                
            }
        }
    
        xhr.send(formData);
        event.preventDefault();
    }

    function onChange(data) {
        setFiles(data.target.files)
    }

    return (
        <div class="multiple-upload">
            <h3>Upload Multiple Files</h3>
            <form id="multipleUploadForm" name="multipleUploadForm" onSubmit={handleSubmit}>
                <input id="multipleFileUploadInput" type="file" name="files" class="file-input" onChange={onChange} multiple required />
                <button type="submit" class="primary submit-btn">Submit</button>
            </form>
        </div>
    )
}
