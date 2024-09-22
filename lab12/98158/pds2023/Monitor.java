import java.util.ArrayList;
import java.util.List;

public abstract class Monitor {
        protected StudentAdm adm;
        public List<Professor> profs = new ArrayList<>();
        public List<Director> dirs = new ArrayList<>();

        public Monitor(StudentAdm adm){
                this.adm=adm;
        }

}
