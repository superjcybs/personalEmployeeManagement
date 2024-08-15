import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeManagement {

    public static void main(String[] args) {
        // Step 1: Read the dataset and store it in a collection
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 28, "HR", 50000),
            new Employee("Bob", 34, "Engineering", 75000),
            new Employee("Charlie", 40, "Management", 90000),
            new Employee("David", 25, "Engineering", 60000),
            new Employee("Eve", 45, "HR", 65000)
        );

        // Step 2: Use the Function interface to concatenate employee's name and department
        Function<Employee, String> nameAndDepartment = emp -> emp.getName() + " - " + emp.getDepartment();

        // Step 3: Use streams to generate a new collection of concatenated strings
        List<String> nameAndDepartmentList = employees.stream()
                                                      .map(nameAndDepartment)
                                                      .collect(Collectors.toList());

        // Output the concatenated strings
        nameAndDepartmentList.forEach(System.out::println);

        // Step 4: Calculate the average salary using streams
        double averageSalary = employees.stream()
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0.0);

        System.out.println("Average Salary: " + averageSalary);

        // Step 5: Filter employees by age threshold and repeat the above operations
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                                                    .filter(emp -> emp.getAge() > ageThreshold)
                                                    .collect(Collectors.toList());

        List<String> filteredNameAndDepartmentList = filteredEmployees.stream()
                                                                      .map(nameAndDepartment)
                                                                      .collect(Collectors.toList());

        double filteredAverageSalary = filteredEmployees.stream()
                                                        .mapToDouble(Employee::getSalary)
                                                        .average()
                                                        .orElse(0.0);

        // Output the results for filtered employees
        filteredNameAndDepartmentList.forEach(System.out::println);
        System.out.println("Filtered Average Salary: " + filteredAverageSalary);
    }
}