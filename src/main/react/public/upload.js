// Run this file and run the index html
// the file upload is showing in the log

var express = require('express');
var app = express();
var formidable = require('formidable');

app.set('port', process.env.PORT || 3000);

app.use(function(req, res, next) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	next();
});

app.post('/upload', function(req, res) {
	var form = new formidable.IncomingForm();
	form.parse(req, function(err, fields, files) {

		console.log('handling form upload - fields', fields);
		
		console.log('handling form upload - files', files);
		
	});
	res.send('Thank you');
});

app.listen(app.get('port'), function() {
	console.log('Express running on http://localhost:' + app.get('port'));
});