package com.softtek.presentacion;

import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AcessoEmpleados;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexion c1 = new Conexion();
        AcessoEmpleados ae = new AcessoEmpleados();
        try {
            //c1.abrirConexion();
            //Obtener todos los empleados:
            //System.out.println(ae.obtenerTodos());
            //Obtener solo un empelado:
            //System.out.println(ae.obtenerEmpleado(2));
            //Insertar un empleado
            Empleado e1 =new Empleado(15,"Hugo","Hervella Gonzalez",2);
            System.out.println(ae.insertarEmpleado(e1));
            //Modificar empleado
            // e2 = new Empleado(10,"Hugo","Hervella Gonzalez",5);
            //System.out.println(ae.actualizarEmpleado(e2));
            //Eliminar empleado
            //System.out.println(ae.eliminarEmpleado(10));
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
