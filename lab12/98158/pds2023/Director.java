public class Director extends Monitor{
    private Course degreeName;

    public Director (StudentAdm stud, Course degree) {
        super(stud);
        this.degreeName = degree;
        dirs.add(this);
    }

    public Course getCourseName() {
        return degreeName;
    }

    public Director getDirector(String course){
        for(Director dir : dirs){
            if(dir.getCourseName().equals(course)){
                return dir;
            }
        }
        return null;
    }

}
