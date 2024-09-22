public class Professor extends Monitor{
    private String className;
    private String name;

    public Professor(StudentAdm adm, String name, String className) {
        super(adm);
        this.name = name;
        this.className = className;
        profs.add(this);
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public Professor getProfessor(String classname){
        for(Professor prof : profs){
            if(prof.getClassName().equals(classname)){
                return prof;
            }
        }
        return null;
    }

}
