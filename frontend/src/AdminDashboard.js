import React from "react";
import { useNavigate } from "react-router-dom";

const AdminDashboard = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    navigate("/");
  };

  return (
    <div>
      <h1>Admin Dashboard</h1>
      <p>Welcome, Admin! Manage the system here.</p>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};

export default AdminDashboard;