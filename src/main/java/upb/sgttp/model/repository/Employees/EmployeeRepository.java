package upb.sgttp.model.repository.Employees;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import upb.sgttp.model.domain.persons.Employee;
import upb.sgttp.shared.filejsonadapter.FileJsonAdapter;
import upb.sgttp.shared.filejsonadapter.FileJsonInterface;

public class EmployeeRepository {

    private FileJsonInterface<EmployeeEntity> fileJson;
    private String pathFile;

    public EmployeeRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Employee getEmployee(String employeeId) {
        EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
        for (EmployeeEntity employeeEntity : employeeEntities) {
            if (employeeEntity.getId().equals(employeeId)) {
                return new Employee(
                        employeeEntity.getNames(),
                        employeeEntity.getLastNames(),
                        employeeEntity.getPhoneNumbers(),
                        employeeEntity.getId());
            }
        }
        return Employee.getNullEmployee();
    }

    public boolean addEmployee(Employee employee) {
        // Obtener todos los empleados del archivo JSON
        EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);

        // Verificar si employeeEntities es null antes de continuar
        if (employeeEntities == null) {
            employeeEntities = new EmployeeEntity[0]; // Si es null, asignamos un array vacío
        }

        // Crear una nueva instancia de EmployeeEntity a partir del empleado proporcionado
        EmployeeEntity newEmployeeEntity = new EmployeeEntity(
                employee.getNames(),
                employee.getLastNames(),
                employee.getPhoneNumbers(),
                employee.getId());

        // Crear un nuevo array para almacenar todos los empleados, incluido el nuevo empleado
        Array<EmployeeEntity> updatedEmployeeEntities = new Array<>(employeeEntities.length + 1);
        for (EmployeeEntity entity : employeeEntities) {
            updatedEmployeeEntities.add(entity);
        }
        updatedEmployeeEntities.add(newEmployeeEntity);

        // Convertir el Array<EmployeeEntity> a un array regular de EmployeeEntity[]
        EmployeeEntity[] updatedEmployeeEntitiesArray = new EmployeeEntity[updatedEmployeeEntities.size()];
        for (int i = 0; i < updatedEmployeeEntities.size(); i++) {
            updatedEmployeeEntitiesArray[i] = updatedEmployeeEntities.get(i);
        }

        return fileJson.writeObjects(pathFile, updatedEmployeeEntitiesArray);
    }

    public boolean removeEmployee(String employeeId) {
        // Obtener todos los empleados del archivo JSON
        EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);

        // Buscar el empleado con el ID especificado
        int indexToRemove = -1;
        for (int i = 0; i < employeeEntities.length; i++) {
            if (employeeEntities[i].getId().equals(employeeId)) {
                indexToRemove = i;
                break;
            }
        }

        // Si se encontró el empleado, eliminarlo y escribir de nuevo los empleados actualizados en el archivo JSON
        if (indexToRemove != -1) {
            Array<EmployeeEntity> updatedEmployeeEntities = new Array<>(employeeEntities.length - 1);
            for (int i = 0; i < employeeEntities.length; i++) {
                if (i != indexToRemove) {
                    updatedEmployeeEntities.add(employeeEntities[i]);
                }
            }

            EmployeeEntity[] updatedEmployeeEntitiesArray = new EmployeeEntity[updatedEmployeeEntities.size()];
            for (int i = 0; i < updatedEmployeeEntities.size(); i++) {
                updatedEmployeeEntitiesArray[i] = updatedEmployeeEntities.get(i);
            }

            return fileJson.writeObjects(pathFile, updatedEmployeeEntitiesArray);
        } else {
            // Si no se encontró el empleado con el ID especificado, devolver false
            return false;
        }
    }

    public boolean modifyEmployee(String employeeId, Employee modifiedEmployee) {
        // Obtener todos los empleados del archivo JSON
        EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);

        // Buscar el empleado con el ID especificado
        int indexToModify = -1;
        for (int i = 0; i < employeeEntities.length; i++) {
            if (employeeEntities[i].getId().equals(employeeId)) {
                indexToModify = i;
                break;
            }
        }

        // Si se encontró el empleado, modificarlo y escribir de nuevo los empleados actualizados en el archivo JSON
        if (indexToModify != -1) {
            employeeEntities[indexToModify].setNames(modifiedEmployee.getNames());
            employeeEntities[indexToModify].setLastNames(modifiedEmployee.getLastNames());
            employeeEntities[indexToModify].setPhoneNumbers(modifiedEmployee.getPhoneNumbers());

            return fileJson.writeObjects(pathFile, employeeEntities);
        } else {
            // Si no se encontró el empleado con el ID especificado, devolver false
            return false;
        }
    }

    public LinkedList<Employee> getAllEmployeesAsLinkedList() {
        // Obtener todos los empleados del archivo JSON
        EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);

        // Crear una lista enlazada para almacenar los empleados
        LinkedList<Employee> employeeList = new LinkedList<>();

        // Agregar cada empleado a la lista enlazada
        for (int i = 0; i < employeeEntities.length; i++) {
            EmployeeEntity entity = employeeEntities[i];
            Employee employee = new Employee(
                    entity.getNames(),
                    entity.getLastNames(),
                    entity.getPhoneNumbers(),
                    entity.getId()
            );
            employeeList.add(employee);
        }

        return employeeList;
    }

    public boolean modifyEmployees(LinkedList<Employee> modifiedEmployees) {
        // Convertir la LinkedList a un arreglo de EmployeeEntity
        EmployeeEntity[] modifiedEmployeeEntities = new EmployeeEntity[modifiedEmployees.size()];
        for (int i = 0; i < modifiedEmployees.size(); i++) {
            Employee employee = modifiedEmployees.get(i);
            modifiedEmployeeEntities[i] = new EmployeeEntity(
                    employee.getNames(),
                    employee.getLastNames(),
                    employee.getPhoneNumbers(),
                    employee.getId()
            );
        }

        // Escribir los nuevos objetos en el archivo JSON
        return fileJson.writeObjects(pathFile, modifiedEmployeeEntities);
    }
//    public boolean modifyEmployees(LinkedList<Employee> modifiedEmployees) {
//        // Obtener todos los empleados del archivo JSON
//        EmployeeEntity[] employeeEntities = fileJson.getObjects(pathFile, EmployeeEntity[].class);
//
//        // Iterar sobre los empleados modificados
//        for (int i = 0; i < modifiedEmployees.size(); i++) {
//            Employee modifiedEmployee = modifiedEmployees.get(i);
//            // Iterar sobre las entidades de empleado
//            for (int j = 0; j < employeeEntities.length; j++) {
//                EmployeeEntity entity = employeeEntities[j];
//                // Verificar si la entidad de empleado corresponde al empleado modificado
//                if (entity.getId().equals(modifiedEmployee.getId())) {
//                    // Actualizar los datos de la entidad de empleado con los datos del empleado modificado
//                    entity.setNames(modifiedEmployee.getNames());
//                    entity.setLastNames(modifiedEmployee.getLastNames());
//                    entity.setPhoneNumbers(modifiedEmployee.getPhoneNumbers());
//                    entity.setId(modifiedEmployee.getId());
//                }
//            }
//        }
//
//        // Escribir los empleados modificados en el archivo JSON
//        return fileJson.writeObjects(pathFile, employeeEntities);
//    }
}
