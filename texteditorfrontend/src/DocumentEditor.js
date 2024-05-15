import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function DocumentEditor() {
  const { id } = useParams();
  const [document, setDocument] = useState({});

  useEffect(() => {
    const fetchDocument = async () => {
      try {
        const response = await axios.get('/documents/${id}');
        setDocument(response.data);
      } catch (error) {
        console.error('Error fetching document', error);
      }
    };
    fetchDocument();
  }, [id]);

  const handleSave = async () => {
    try {
      await axios.put('/documents/update', document);
    } catch (error) {
      console.error('Error saving document', error);
    }
  };

  return (
    <div>
      <h2>Document Editor</h2>
      <input type="text" value={document.name} onChange={(e) => setDocument({ ...document, name: e.target.value })} />
      <textarea value={document.content} onChange={(e) => setDocument({ ...document, content: e.target.value })} />
      <button onClick={handleSave}>Save</button>
    </div>
  );
}

export default DocumentEditor;