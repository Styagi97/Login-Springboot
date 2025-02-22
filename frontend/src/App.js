import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AuthForm from "./Login";
import UserHome from "./UserHome";
import AdminDashboard from "./AdminDashboard";
import ProtectedRoute from "./ProtectedRoute";

const App = () => {
  return (
    <Router>
      <Routes>
    
     {/* Route for the login/register form */}
        <Route path="/" element={<AuthForm />} />
  
    {/* Protected route for user home page */}
        <Route
          path="/userhome"
          element={
            <ProtectedRoute role="USER">
              <UserHome />
            </ProtectedRoute>
          }
        />
          {/* Protected route for admin dashboard */}
        <Route
          path="/dashboard"
          element={
            <ProtectedRoute role="ADMIN">
              <AdminDashboard />
            </ProtectedRoute>
          }
        />
      {/* Route for unauthorized access */}
        <Route path="/unauthorized" element={<h2>Unauthorized Access</h2>} />
      </Routes>
    </Router>
  );
};

export default App;
