import React, { useState } from "react";
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const AuthForm = () => {
  const [isLogin, setIsLogin] = useState(true);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const toggleForm = () => {
    setIsLogin((prev) => !prev);
    setError("");
  };

  const validationSchema = Yup.object({
    username: isLogin
      ? Yup.string().notRequired()
      : Yup.string().min(3, "Too short!").required("Username is required"),
    email: Yup.string().email("Invalid email").required("Email is required"),
    password: Yup.string().min(6, "Password must be at least 6 characters").required("Password is required"),
    role: Yup.string().oneOf(["USER", "ADMIN"], "Invalid role").required("Role is required"),
  });

  const formik = useFormik({
    initialValues: {
      username: "",
      email: "",
      password: "",
      role: "",
    },
    validationSchema,
    onSubmit: async (values, { resetForm }) => {
      try {
        const endpoint = isLogin
          ? "http://localhost:8080/auth/login"
          : "http://localhost:8080/auth/register";

//        const response = await axios.post(endpoint, values);
    const response = await axios.post(endpoint, {
                    ...values,
                    roles: [values.role] // Ensure roles are sent as an array
                });
        if (isLogin) {
          // Store token and role in localStorage
          localStorage.setItem("token", response.data.token);

          // Extract the first role from the roles array
          const userRole = response.data.roles[0]; // Assuming roles is an array
          localStorage.setItem("role", userRole);

          // Redirect based on role
          if (userRole === "ADMIN") {
            navigate("/dashboard");
          } else {
            navigate("/userhome");
          }
        } else {
          alert("Registration successful! Please login.");
          setIsLogin(true);
        }

        resetForm();
        setError("");
      } catch (error) {
        setError(error.response?.data?.message || "Something went wrong");
      }
    },
  });

  return (
    <div className="container">
      <h2>{isLogin ? "Login" : "Register"}</h2>

      {error && <p className="error">{error}</p>}

      <form onSubmit={formik.handleSubmit}>
        {!isLogin && (
          <div>
            <label>Username:</label>
            <input type="text" name="username" {...formik.getFieldProps("username")} />
            {formik.touched.username && formik.errors.username && (
              <p className="error">{formik.errors.username}</p>
            )}
          </div>
        )}

        <div>
          <label>Email:</label>
          <input type="email" name="email" {...formik.getFieldProps("email")} />
          {formik.touched.email && formik.errors.email && (
            <p className="error">{formik.errors.email}</p>
          )}
        </div>

        <div>
          <label>Password:</label>
          <input type="password" name="password" {...formik.getFieldProps("password")} />
          {formik.touched.password && formik.errors.password && (
            <p className="error">{formik.errors.password}</p>
          )}
        </div>

        <div>
          <label>Role:</label>
          <select
            name="role"
            value={formik.values.role}
            onChange={formik.handleChange}
            onBlur={formik.handleBlur}
          >
            <option value="">Select</option>
            <option value="USER">User</option>
            <option value="ADMIN">Admin</option>
          </select>
          {formik.touched.role && formik.errors.role && (
            <p className="error">{formik.errors.role}</p>
          )}
        </div>

        <button type="submit">{isLogin ? "Login" : "Register"}</button>
      </form>

      <p onClick={toggleForm} className="toggle-text">
        {isLogin ? "Don't have an account? Register" : "Already have an account? Login"}
      </p>
    </div>
  );
};

export default AuthForm;