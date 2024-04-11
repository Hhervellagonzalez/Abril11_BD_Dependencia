package com.softtek.persistencia;

import com.softtek.modelo.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcessoEmpleados extends Conexion{
    public List<Empleado> obtenerTodos() throws SQLException, ClassNotFoundException{
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT employee_id,first_name,last_name,reports_to FROM employees";
        abrirConexion();
        PreparedStatement sentencia;
        sentencia = miConexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            empleados.add(new Empleado(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("reports_to")));
        }
        return empleados;
    }

    public Empleado obtenerEmpleado(int idEmpleado) throws SQLException, ClassNotFoundException {
        Empleado empleado = null;
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, idEmpleado);
        ResultSet rs = sentencia.executeQuery();
        if (rs.next()) {
            empleado = new Empleado(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("reports_to"));
        }
        return empleado;
    }
    public String insertarEmpleado(Empleado e) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employees (employee_id, last_name, first_name, reports_to) VALUES (?, ?, ?, ?);";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, e.getIdEmpleado());
        sentencia.setString(2, e.getApellidos());
        sentencia.setString(3, e.getNombre());
        sentencia.setInt(4, e.getJefe());
        sentencia.executeUpdate();
        return "Empleado insertado";
    }

    public String actualizarEmpleado(Empleado e) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, reports_to = ? WHERE employee_id = ?";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setString(1, e.getNombre());
        sentencia.setString(2, e.getApellidos());
        sentencia.setInt(3, e.getJefe());
        sentencia.setInt(4, e.getIdEmpleado());
        sentencia.executeUpdate();
        return "Trabajador modificado";
    }
    public String eliminarEmpleado(int idEmpleado) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, idEmpleado);
        sentencia.executeUpdate();
        return "Trabajador eliminado";
    }



}
