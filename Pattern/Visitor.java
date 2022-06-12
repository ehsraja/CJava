package Pattern;

import java.util.HashSet;
import java.util.Set;

public class Visitor {

}

class Student {
	
}

interface Course {
    void join(Student s);
    Student[] getStudents();
    int getLimit();
    int getCost();
    void incrementLimit(int additional);
}

 class OilCourse implements Course {
    private Set students = new HashSet();
    private int limit;    

    public OilCourse() {
        limit = 15;
    }
    
    @Override
    public void join(Student s) {
        students.add(s);
    }

    @Override
    public Student[] getStudents() {
        return  (Student[]) students.toArray(new Student[students.size()]);
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public int getCost() {
        return 2000;
    }

    @Override
    public void incrementLimit(int i) {
        limit += i;
    }
}