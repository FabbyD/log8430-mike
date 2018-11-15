let express = require('express');
let app = express();

app.get('/', function(req, res) {
  res.send('Hello World');
})

app.put('/factures', function(req, res) {
  
})

var server = app.listen(8085, function() {
  let host = server.address().address;
  let port = server.address().port;

  console.log("Listening at http://%s:%s", host, port); 
})
