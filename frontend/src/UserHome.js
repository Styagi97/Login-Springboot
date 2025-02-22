import React from "react";
import { useNavigate } from "react-router-dom";

const UserHome = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    navigate("/");
  };

  return (
    <div>
      <h1>Welcome User</h1>
      <p>This is the user homepage.</p>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};

export default UserHome;