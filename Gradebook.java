import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Gradebook implements Comparator<StudentGrades>{
	// Field
	private Collection<StudentGrades> grades;

	// Contructor
	public Gradebook(){
		grades = new ArrayList<>();
	}

	// Methods
	// 1
	/**
	 * Add a student in the book
	 * @param sg
	 */
	public void addGrade(StudentGrades sg){
		grades.add(sg);
	}
	// 2
	/**
	 * Return average total score for all student in the list
	 * @return
	 */
	public double average(){
		double totalScore = 0;
		for(StudentGrades i : grades){
			totalScore += i.totalScore();
		}
		totalScore = totalScore / grades.size();
		return totalScore;
	}
	// 3
	/**
	 * Get the student with the lowest totalScore
	 * @return
	 */
	public StudentGrades min(){
		// TODO: How to get a ele in a COllection
		// Print out the first
		ArrayList<StudentGrades> temp = new ArrayList<>(grades);
		StudentGrades lowest = temp.get(0);
		for(StudentGrades i : grades){
			if(i.totalScore() < lowest.totalScore()){
				lowest = i;
			}
		}
		return lowest;
	}
	// 4
	/**
	 * Get the student with the highest totalScore
	 * @return
	 */
	public StudentGrades max(){
		// TODO: How to get a ele in a COllection
		ArrayList<StudentGrades> temp = new ArrayList<>(grades);
		StudentGrades highest = temp.get(0);
		for(StudentGrades i : grades){
			if(i.totalScore() > highest.totalScore()){
				highest = i;
			}
		}
		return highest;
	}
	// 5
	/**
	 * Get the student who have the median score
	 * @return
	 */
	public StudentGrades median(){
		ArrayList<Double> gradesArray = new ArrayList<>();
		ArrayList<StudentGrades> temp = new ArrayList<>(grades);
		Double gradeNeeded = 0.0;
		for(int i = 0; i < grades.size(); i ++){
			gradesArray.add(temp.get(i).totalScore());
		}
		Collections.sort(gradesArray);
		gradeNeeded = gradesArray.get(Math.floorDiv(gradesArray.size(), 2));
		for(int i = 0; i < grades.size(); i++){
			if(temp.get(i).totalScore() == gradeNeeded){
				return temp.get(i);
			}
		}
		return null;
	}
		

	public int compare(StudentGrades left, StudentGrades right){
		return (int)(left.totalScore()-right.totalScore());
	}

	//provided
	public String toString(){
		String rv = "Grades: [ ";
		for(StudentGrades sg : grades){
			rv += "("+sg.getStudentName()+": "+sg.letterGrade()+"), ";
		}
		rv += "]\n";
		rv += "Max: "+max()+", Median: "+median()+", Average: "+average()+", Min: "+min();
		return rv;
	}

}
//:)
