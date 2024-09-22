import java.util.ArrayList;
import java.util.List;

public class StudentAdm {
    private Student student;
    private List<Director> dirs;
    private List<Professor> profs;
    private Monitor m;

    public StudentAdm(Student s) {
        this.student = s;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);
        Course course = student.getCourse();
        
        Director d;
        for(Director dir : dirs){
            if(dir.getCourseName().equals(course)){
                d=dir;
            }
        }

        System.out.println(course + " director reports that student " + student.toString() + " has changed the overall grade: " + score);
        Professor p;
        for(Professor prof : profs){
            if(prof.getClassName().equals(className)){
                return prof;
            }
        }

        System.out.println("Professor " + prof.getName() + " of " + className + " class evaluated student " + student.toString() + "with score: " + score);

    }
    
    public Student getStudent() {
        return student;
    }

    // public ArrayList<Director> gDirectors(){
    //     dirs = new ArrayList<>();
    //     dirs.add()
    // }
    
}








