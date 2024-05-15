import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';
import Dashboard from './Dashboard';
import DocumentEditor from './DocumentEditor';

function App() {
  return (
    <Routes>
        <Route path="/login" element={<Login/>} />
        <Route path="/signup" element={<Signup/>} />
        <Route path="/dashboard" element={<Dashboard/>} />
        <Route path="/editor/:id" element={<DocumentEditor/>} />
    </Routes>
  );
}

export default App;