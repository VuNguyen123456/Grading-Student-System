import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentGrades{
    // Fiels: categories
    private double participation;
    private List<Double> readings;
    private double midterm;
    private double finalExam;
    private Collection<Double> labs; //TODO: hint autobox and unboxing
    private Collection<Double> exercises; //TODO: hint autobox and unboxing
    private Collection<Double> projects;
    private String studentName;
    private String gNumber;
    
    // Fields in the final grade calculation
    private double participationWeight;
    private double readingsWeight;
    private double labsWeight;
    private double exercisesWeight;
    private double projectsWeight;
    private double midtermWeight;
    private double finalExamWeight;

    //TODO: Getter and Setter for some specific field, not all 
    //Setter
    /**
     * 
     * @param participation
     */
    public void setParticipation(double participation){
        this.participation = participation;
    }
    /**
     * 
     * @param midterm
     */
    public void setMidterm(double midterm){
        this.midterm = midterm;
    }
    /**
     * 
     * @param finalExam
     */
    public void setFinalExam(double finalExam){
        this.finalExam = finalExam;
    }
    /**
     * 
     * @param studentName
     */
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    /**
     * 
     * @param gNumber
     */
    public void setGNumber(String gNumber){
        this.gNumber = gNumber;
    }
    //Getter
    /**
     * 
     * @return
     */
    public double getParticipation(){
        return this.participation;
    }
    /**
     * 
     * @return
     */
    public double getMidterm(){
        return this.midterm;
    }
    /**
     * 
     * @return
     */
    public double getFinalExam(){
        return this.finalExam;
    }
    /**
     * 
     * @return
     */
    public String getStudentName(){
        return this.studentName;
    }
    /**
     * 
     * @return
     */
    public String getGNumber(){
        return this.gNumber;
    }
    /**
     * Contructor
     * @param name
     * @param gNumber
     * @param weights
     */
    public StudentGrades (String name, String gNumber, double[] weights){
        this.studentName = name;
        this.gNumber = gNumber;
        setWeights(weights);
        this.readings = new ArrayList<>();
        this.labs = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    // Adder
    /**
     * 
     * @param d
     */
    public void addReading(double d){
        this.readings.add(d);
    }
    /**
     * 
     * @param d
     */
    public void addLab(double d){
        this.labs.add(d);
    }
    /**
     * 
     * @param d
     */
    public void addExercise(double d){
        this.exercises.add(d);
    }
    /**
     * 
     * @param d
     */
    public void addProject(double d){
        this.projects.add(d);
    }

    // Methods
    // 1
    /**
     * Set the weights of each section
     * @param weights
     */
    public void setWeights(double[] weights){
        //TODO: Check with others
        this.participationWeight = weights[0];
        this.readingsWeight = weights[1];
        this.labsWeight = weights[2];
        this.exercisesWeight = weights[3];
        this.projectsWeight = weights[4];
        this.midtermWeight = weights[5];
        this.finalExamWeight = weights[6];
    }
    // 2 
    /**
     * Find the unweighted reading Score
     * @return
     */
    public double unweightedReadingsScore(){
        double scores = 0;
        Collections.sort(readings);
        if(readings.size() < 15){
            return 100;
        }
        else{
            for(int i = 15; i < this.readings.size(); i++){
                scores += this.readings.get(i);
            }
        }
        scores = scores/(this.readings.size()-15);
        return scores;
    }
    // 3
    // 2 
    /**
     * Find the unweighted labs Score
     * @return
     */
    public double unweightedLabsScore(){
        double scores = 0;
        if(this.labs.size() == 0){
            return 100;
        }
        else{
            for(double scoresInCollection : this.labs){
                scores += scoresInCollection;
            }
        }
        scores = scores/(this.labs.size());
        return scores;
    }
    // 4
    // 2 
    /**
     * Find the unweighted exercises Score
     * @return
     */
    public double unweightedExercisesScore(){
        double scores = 0;
        if(this.exercises.size() == 0){
            return 100;
        }
        else{
            for(double scoresInCollection : this.exercises){
                scores += scoresInCollection;
            }
        }
        scores = scores/(this.exercises.size());
        return scores;
    }
    // 5 
    // 2 
    /**
     * Find the unweighted project Score
     * @return
     */
    public double unweightedProjectsScore(){
        double scores = 0;
        if(this.projects.size() == 0){
            return 100;
        }
        else{
            for(double scoresInCollection : this.projects){
                scores += scoresInCollection;
            }
        }
        scores = scores/(this.projects.size());
        return scores;
    }
    // 6
    /**
     * Find out that does the final score is larger than the midterm score
     * @return
     */
    public boolean finalReplacesMidterm(){
        if(this.finalExam > this.midterm){
            return true;
        }
        return false;
    }
    // 7
    /**
     * Find out if finalScore is higher than 60 or not
     * @return
     */
    public boolean finalIsPassing(){
        if(this.finalExam > 60){
            return true;
        }
        return false;
    }
    // 8 
    /**
     * Find the total Score of the student
     * @return
     */
    public double totalScore(){
        double totalScore = 0.0;
        totalScore += participation * participationWeight;
        totalScore += unweightedReadingsScore() * readingsWeight;
        totalScore += unweightedLabsScore() * labsWeight;
        totalScore += unweightedExercisesScore() * exercisesWeight;
        totalScore += unweightedProjectsScore() * projectsWeight;
        // If final is bigger then midterm replace the midterm graded with final
        if(finalReplacesMidterm()){
            totalScore += this.finalExam * midtermWeight; 
            totalScore += this.finalExam * finalExamWeight; 
        }
        else{
            totalScore += this.midterm * midtermWeight;
            totalScore += this.finalExam * finalExamWeight; 
        }
        return totalScore;
    }
    // 9 
    /**
     * Return the letter grade corresponding to the totalScore
     * @return
     */
    public String letterGrade(){
        // If final is lower than 60, the student fail
        if(!finalIsPassing()){return "F";}
        else if(totalScore() >= 98){return "A+";}
        else if(totalScore() >= 92){return "A";}
        else if(totalScore() >= 90){return "A-";}
        else if(totalScore() >= 88){return "B+";}
        else if(totalScore() >= 82){return "B";}
        else if(totalScore() >= 80){return "B-";}
        else if(totalScore() >= 78){return "C+";}
        else if(totalScore() >= 72){return "C";}
        else if(totalScore() >= 70){return "C-";}
        else if(totalScore() >= 60){return "D";}
        else {return "F";}
    }
    
    @Override
    public String toString(){
		String rv = "Name: "+getStudentName()+"\n";
		rv += "G#: "+getGNumber()+"\n";
		rv += "Participation: "+getParticipation()+"\n";
		rv += "Readings: "+unweightedReadingsScore()+", "+readings+"\n";
		rv += "Labs: "+unweightedLabsScore()+", "+labs+"\n";
		rv += "Exercises: "+unweightedExercisesScore()+", "+exercises+"\n";
		rv += "Projects: "+unweightedProjectsScore()+", "+projects+"\n";
		rv += "Midterm: "+getMidterm()+"\n";
		rv += "Final Exam: "+getFinalExam()+"\n";
		rv += totalScore()+", "+letterGrade()+"\n";
		return rv;
	}

}
//:):)
