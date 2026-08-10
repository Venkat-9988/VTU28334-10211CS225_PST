import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        Collections.sort(studentList,new Comparator<Student>()
        {
            @Override
            public int compare(Student s1 ,Student s2)
            {
                if(s1.getCgpa() !=s2.getCgpa()){
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                }
                if(!s1.getFname().equals(s2.getFname())){
                    return s1.getFname().compareTo(s2.getFname());
                }
                return Integer.compare(s1.getId(),s2.getId());
            }
        });
      
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}


Input (stdin)
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76

Your Output (stdout)
Ashis
Fahim
Samara
Samiha
Rumpa

Expected Output
Ashis
Fahim
Samara
Samiha
Rumpa
