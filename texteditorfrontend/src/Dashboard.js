import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Dashboard() {
  const [documents, setDocuments] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchDocuments = async () => {
      try {
        const response = await axios.get('/documents/owned', { params: { owner: 'currentUsername' } });
        setDocuments(response.data);
      } catch (error) {
        console.error('Error fetching documents', error);
      }
    };
    fetchDocuments();
  }, []);

  const handleCreateDocument = async () => {
    try {
      const newDoc = { name: 'New Document', content: '', owner: 'currentUsername' };
      await axios.post('/documents/create', newDoc);
      setDocuments([...documents, newDoc]);
    } catch (error) {
      console.error('Error creating document', error);
    }
  };

  const handleEditDocument = (id) => {
    navigate('/editor/${id}');
  };

  const handleDeleteDocument = async (id) => {
    try {
      await axios.delete('/documents/delete/${id}');
      setDocuments(documents.filter(doc => doc.id !== id));
    } catch (error) {
      console.error('Error deleting document', error);
    }
  };

  return (
    <div>
      <h2>Dashboard</h2>
      <button onClick={handleCreateDocument}>Create Document</button>
      <ul>
        {documents.map(doc => (
          <li key={doc.id}>
            {doc.name}
            <button onClick={() => handleEditDocument(doc.id)}>Edit</button>
            <button onClick={() => handleDeleteDocument(doc.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Dashboard;