import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [selected, setSelected] = useState('');

  const renderComponent = () => {
    if (selected === 'book') return <BookDetails />;
    if (selected === 'blog') return <BlogDetails />;
    if (selected === 'course') return <CourseDetails />;
    return <p className="text-gray-600">Please select a category above.</p>;
  };

  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold mb-4">Blogger App</h1>
      <div className="flex gap-4 mb-6">
        <button onClick={() => setSelected('book')} className="bg-blue-500 text-white px-4 py-2 rounded">Book Details</button>
        <button onClick={() => setSelected('blog')} className="bg-green-500 text-white px-4 py-2 rounded">Blog Details</button>
        <button onClick={() => setSelected('course')} className="bg-purple-500 text-white px-4 py-2 rounded">Course Details</button>
      </div>

      {/* Conditional Rendering Ways */}

      {/* 1. Using Function */}
      {/* {renderComponent()} */}

      {/* 2. Using Ternary */}
      {/* {selected === 'book' ? <BookDetails /> : selected === 'blog' ? <BlogDetails /> : selected === 'course' ? <CourseDetails /> : <p>Select something</p>} */}

      {/* 3. Using Logical AND */}
      {selected === 'book' && <BookDetails />}
      {selected === 'blog' && <BlogDetails />} 
      {selected === 'course' && <CourseDetails />}
    </div>
  );
}
      

export default App;