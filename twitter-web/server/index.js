const express = require('express');
const path = require('path');
const app = express();
const PORT = process.env.PORT || 3000;

// Reserved front-end server URLs
app.get('/hello', (req, res) => res.redirect('/api/hello'));

// Serve static resources
app.use(express.static(path.join(process.cwd(), 'dist')));
app.get('/*', (req, res) => res.sendFile(path.join(process.cwd(), 'dist', 'index.html')));

app.listen(PORT, () => console.log(`Express started in port ${PORT} successfully`));
