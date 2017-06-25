package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportCard studentOne = new ReportCard(12345);

        List<String> subjectsList = new ArrayList<>();


        studentOne.setSubjects(subjectsList);

        List<Integer> gradesList = new ArrayList<>();
        gradesList.add(18);
        gradesList.add(15);
        gradesList.add(20);
        gradesList.add(17);
        gradesList.add(13);

        studentOne.setGrades(gradesList);

        List<Integer> attendanceList = new ArrayList<>();
        attendanceList.add(200);
        attendanceList.add(270);
        attendanceList.add(200);
        attendanceList.add(280);
        attendanceList.add(40);

        studentOne.setAttendance(attendanceList);

        String messageToParents = "Wnjoy the rest of the Summer Break and we will see you in July";
        studentOne.setMessageToParents(messageToParents);

        Log.v("MainActivity", "studentOne: " + studentOne);
    }

    public class ReportCard {

        // is final because it can't be modified
        final String schoolName = "ST_PATRICKS_COLLEGE_CAVAN";
        int studentId;
        String messageToParents;
        // List of names of subjects in report card
        List<String> subjects;
        // List of every subject's grade in report card.
        // Grades go from 0 to 10 (< 5 means failed)
        // Grade system from Spain
        List<Integer> grades;
        // Number of days attended in every subject
        List<Integer> attendance;


        // constructor requires the studentId because is mandatory
        public ReportCard(int studentId) {
            this.studentId = studentId;
            this.subjects = new ArrayList<>();
            this.grades = new ArrayList<>();
            this.attendance = new ArrayList<>();
        }

        public String getSchoolName() {
            return schoolName;
        }

        public String getMessageToParents() {
            return messageToParents;
        }

        public void setMessageToParents(String messageToParents) {
            this.messageToParents = messageToParents;
        }

        public List<String> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<String> subjects) {
            this.subjects = subjects;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public void setGrades(List<Integer> grades) {
            this.grades = grades;
        }

        public List<Integer> getAttendance() {
            return attendance;
        }

        public void setAttendance(List<Integer> attendance) {
            this.attendance = attendance;
        }

        public int getStudentId() {
            return studentId;
        }

        public float getAverageGrade() {
            int sum = 0;

            for (int i = 0; i < grades.size(); i++) {
                sum += grades.get(i);
            }
            float averageGrade = sum / grades.size();
            return averageGrade;
        }

        public String getStringOfOneSubjectWithGradeAndAttendance(int index) {
            List<String> subjects = getSubjects();
            List<Integer> grades = getGrades();
            List<Integer> attendance = getAttendance();

            String subjectWithGradeAndAttendance = subjects.get(index) + " with grade " +
                    Integer.toString(grades.get(index)) + " with " +
                    Integer.toString(attendance.get(index)) + " number of days of attendance";

            return subjectWithGradeAndAttendance;
        }

        public String getStringOfAllSubjectsWithGradesAndAttendance() {
            String allSubjectsWithGradesAndAttendance = "";

            for (int i = 0; i < subjects.size(); i++) {
                allSubjectsWithGradesAndAttendance +=
                        (getStringOfOneSubjectWithGradeAndAttendance(i) + "\n");
            }

            return allSubjectsWithGradesAndAttendance;
        }

        @Override
        public String toString() {
            String filledReportCard = "Student ID: " + Integer.toString(studentId) + "\n" +
                    "Institution Name: " + getSchoolName() + "\n" +
                    "Subjects reviewed:\n" +
                    getStringOfAllSubjectsWithGradesAndAttendance() +
                    "Average grade: " + getAverageGrade() + "\n" +
                    "Message from the teacher: " + getMessageToParents();
            return filledReportCard;
        }
    }


}