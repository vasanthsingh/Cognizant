import React, { useState } from 'react';
import UserPage from './UserPage';
import GuestPage from './GuestPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div className="p-4">
      <header className="flex justify-between items-center mb-4">
        <h1 className="text-2xl font-bold">Ticket Booking App</h1>
        {!isLoggedIn ? (
          <button onClick={handleLogin} className="bg-blue-500 text-white px-4 py-2 rounded">Login</button>
        ) : (
          <button onClick={handleLogout} className="bg-red-500 text-white px-4 py-2 rounded">Logout</button>
        )}
      </header>

      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;