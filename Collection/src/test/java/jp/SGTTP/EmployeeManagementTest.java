package jp.SGTTP;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.persons.Employee;
import jp.sgttp.model.repository.Employees.EmployeeRepository;
import jp.util.iterator.Iterator;

public class EmployeeManagementTest {
    public static void main(String[] args) {
        // Ruta del archivo JSON de empleados
        String pathFile = "Collection/src/main/java/jp/sgttp/database/employee.json";

        // Instancia de EmployeeRepository
        EmployeeRepository employeeRepository = new EmployeeRepository(pathFile);

        try {
            // Agregar un nuevo empleado
            Employee newEmployee = new Employee("John", "Doe", new Array<>(new String[]{"3","1","6","4","9","9","1","0","2","8"}), "003");
            boolean added = employeeRepository.addEmployee(newEmployee);
            if (added) {
                System.out.println("New employee added successfully.");
            } else {
                System.out.println("Failed to add new employee.");
            }

            // Prueba del método getEmployee()
            String employeeIdToSearch = "001"; // Cambiar por el ID del empleado que deseas buscar
            Employee employee = employeeRepository.getEmployee(employeeIdToSearch);
            if (!employee.equals(Employee.getNullEmployee())) {
                System.out.println("Employee found:");
                System.out.println(employee.toString());
            } else {
                System.out.println("Employee not found for ID: " + employeeIdToSearch);
            }
            
            // Eliminar un empleado
            String employeeIdToRemove = "002"; // Cambiar por el ID del empleado que deseas remover
            boolean removed = employeeRepository.removeEmployee(employeeIdToRemove);
            if (removed) {
                System.out.println("Employee removed successfully.");
            } else {
                System.out.println("Failed to remove employee with ID: " + employeeIdToRemove);
            }

            // Modificar un empleado existente
            String employeeIdToModify = "003"; // Cambiar por el ID del empleado que deseas modificar
            Employee modifiedEmployee = new Employee("Jane", "Smith", new Array<>(new String[]{"987654321"}), "003");
            boolean modified = employeeRepository.modifyEmployee(employeeIdToModify, modifiedEmployee);
            if (modified) {
                System.out.println("Employee modified successfully.");
            } else {
                System.out.println("Failed to modify employee with ID: " + employeeIdToModify);
            }

            // Obtener todos los empleados como una lista enlazada y mostrarlos
            LinkedList<Employee> allEmployees = employeeRepository.getAllEmployeesAsLinkedList();
            System.out.println("All employees:");
            Iterator<Employee> iterator = allEmployees.iterator();
            while (iterator.hasNext()) {
                Employee emp = iterator.next();
                System.out.println(emp.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
