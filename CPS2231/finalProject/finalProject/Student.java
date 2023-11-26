package finalProject;

import java.util.ArrayList;
    
	public class Student extends Person {
        private String name;
        private String studentId;
        private String major;
        private double deposit;


        public Student(String name, String studentId, String major,double deposit) {
            this.name = name;
            this.studentId = studentId;
            this.major = major;
            this.deposit = deposit;
      
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }



        public double getDeposit() {
        	return deposit;
        }
        
        public void setDeposit(double deposit) {
        	this.deposit=deposit;
        }
    }






