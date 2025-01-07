# Grading-Student-System
Developing a utility that calculates a student's overall course grade based on individual assessment scores, following the grading rules in the syllabus.

The utility consists of two main classes: StudentGrades and Gradebook. The StudentGrades class will store and manage individual student grades across various assessment categories (participation, readings, labs, exercises, projects, midterm exam, and final exam). It includes methods to add scores for each category, calculate unweighted scores, and compute the total score by applying weightings to each category. Additionally, it will determine the student's letter grade based on the total score.

The Gradebook class manages a collection of StudentGrades objects and includes methods for computing statistics such as the average, minimum, maximum, and median total scores. This class uses a Collection to store the StudentGrades instances and provides utility methods to analyze the grade data.

GradeChecker class, which serves as a driver to test the functionality of your StudentGrades class. It prompts you for input (either interactively or from a file) and displays the calculated grade information.

The main objective is to implement the necessary fields, methods, and logic in StudentGrades and Gradebook while following the specified grading rules. You should also test your implementation thoroughly to ensure correctness before submitting it.
