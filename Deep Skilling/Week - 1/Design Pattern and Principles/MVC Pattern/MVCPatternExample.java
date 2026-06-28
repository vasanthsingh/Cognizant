public class MVCPatternExample {
    public static void main(String[] args) {
        Student model = fetchStudentFromDb();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        System.out.println("Initial Load:");
        controller.updateView();

        System.out.println("Updating grade and pushing to View...");
        controller.setStudentGrade("A+");
        controller.setStudentName("Johnathan Doe");

        controller.updateView();
    }

    private static Student fetchStudentFromDb() {
        return new Student("98765", "John Doe", "B+");
    }
}