const express = require("express");

const app = express();
app.use(express.static('public'));

function startAppListener(port) {
    app.listen(port, () => {
        console.log('\nExample app listening on port '+port+'!');
    });
}

startAppListener(5000);

