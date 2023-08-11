import java.util.*;
class ExamSeatingSystem { 
     private List<Student> students; 
     private int totalStudents; 
     private int availableClasses; 
     private int seatsPerClass; 
     private Map<String, List<Student>> studentsByBranch; 
     private Map<Integer, List<Student>> studentsBySemester; 
     private Map<Integer, List<Student>> studentsByYear; 
  
     // Constructor 
     public ExamSeatingSystem(int totalStudents, int availableClasses, int seatsPerClass) { 
         this.students = new ArrayList<>(); 
         this.totalStudents = totalStudents; 
         this.availableClasses = availableClasses; 
         this.seatsPerClass = seatsPerClass; 
         this.studentsByBranch = new HashMap<>(); 
         this.studentsBySemester = new HashMap<>(); 
         this.studentsByYear = new HashMap<>(); 
     } 
  
     // Add student to the system 
     public void addStudent(Student student) { 
         this.students.add(student); 
         // Add student to maps for easy lookup by branch, semester, and year 
         if (!studentsByBranch.containsKey(student.getBranch())) { 
             studentsByBranch.put(student.getBranch(), new ArrayList<>()); 
         } 
         studentsByBranch.get(student.getBranch()).add(student); 
  
         if (!studentsBySemester.containsKey(student.getSemester())) { 
             studentsBySemester.put(student.getSemester(), new ArrayList<>()); 
         } 
         studentsBySemester.get(student.getSemester()).add(student); 
  
         if (!studentsByYear.containsKey(student.getYear())) { 
             studentsByYear.put(student.getYear(), new ArrayList<>()); 
         } 
         studentsByYear.get(student.getYear()).add(student); 
     } 
         // Generate seating arrangement 
         public void generateSeatingArrangement() { 
         int totalSeats = availableClasses * seatsPerClass; 
         if (totalStudents > totalSeats) { 
             System.out.println("Error: Not enough seats available"); 
             return; 
         } 
  
         // Sort students by roll number 
         Collections.sort(students, new Comparator<Student>() { 
             public int compare(Student s1, Student s2) { 
                 return s1.getRollNumber().compareTo(s2.getRollNumber()); 
             } 
         }); 
  
         int seatCount = 0; 
         int rowNumber = 1; 
         for (Student student : students) { 
             int seatNumber = seatCount % seatsPerClass + 1; 
             student.setSeatNumber(seatNumber); 
             student.setRowNumber(rowNumber); 
             seatCount++; 
             if (seatCount % seatsPerClass == 0) { 
                 rowNumber++; 
             } 
         } 
  
         System.out.println("Seating arrangement generated:"); 
         for (int classNumber = 1; classNumber <= availableClasses; classNumber++) { 
             System.out.println("Class " + classNumber + ":"); 
             for (int seatNumber = 1; seatNumber <= seatsPerClass; seatNumber++) { 
                 System.out.print("Seat " + seatNumber + ": "); 
                 for (Student student : students) { 
                     if (student.getSeatNumber() == seatNumber && student.getRowNumber() == classNumber) { 
                         System.out.print(student.getName() + " (" + student.getRollNumber() + ")"); 
                     } 
                 } 
                 System.out.println(); 
             } 
         } 
     } 
}
    private String rollNumber; 
    private String name; 
    private int semester; 
    private String branch; 
    private int year; 
    private int seatNumber; 
    private int rowNumber; 
 
    // Constructor 
    public Student(String rollNumber, String name, int semester, String branch, int year) { 
        this.rollNumber = rollNumber; 
        this.name = name; 
        this.semester = semester; 
        this.branch = branch; 
        this.year = year; 
        this.seatNumber = -1; // default value for un-assigned seat 
        this.rowNumber = -1; // default value for un-assigned seat 
    } 
 
    // Getters and setters 
    public String getRollNumber() { 
        return rollNumber; 
    } 
 
    public void setRollNumber(String rollNumber) { 
        this.rollNumber = rollNumber; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
    } 
 
    public int getSemester() { 
        return semester; 
    } 
 
    public void setSemester(int semester) { 
        this.semester = semester; 
    } 
 
    public String getBranch() { 
        return branch; 
    } 
 
    public void setBranch(String branch) { 
        this.branch = branch; 
    } 
 
    public int getYear() { 
        return year; 
    } 
 
    public void setYear(int year) { 
        this.year = year; 
    } 
 
    public int getSeatNumber() { 
        return seatNumber; 
    } 
 
    public void setSeatNumber(int seatNumber) { 
        this.seatNumber = seatNumber; 
    } 
 
    public int getRowNumber() { 
        return rowNumber; 
    } 
 
    public void setRowNumber(int rowNumber) { 
        this.rowNumber = rowNumber; 
    } 
}