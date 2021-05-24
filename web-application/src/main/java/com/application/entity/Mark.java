package com.application.entity;

/**
 * Mark.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class Mark extends Entity {
    private User student;
    private Course course;
    private int marks;

    /**
     * @return User field student
     * @see User
     */
    public User getStudent() {
        return student;
    }

    /**
     * Method for setting field student.
     *
     * @param student User field student
     * @see User
     */
    public void setStudent(User student) {
        this.student = student;
    }

    /**
     * Method for setting id of student.
     *
     * @param studentID Long id of student
     * @see User
     */
    public void setStudentID(Long studentID) {
        this.student.setId(studentID);
    }

    /**
     * Method for setting name of student.
     *
     * @param name String name of student
     * @see User
     */
    public void setStudentName(String name) {
        this.student.setName(name);
    }

    /**
     * @return Course field course
     * @see Course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Method for setting field course.
     *
     * @param course Course field course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Method for setting id of course.
     *
     * @param courseID Long id of course
     */
    public void setCourseID(Long courseID) {
        this.course.setId(courseID);
    }

    /**
     * Method for setting title of course.
     *
     * @param title String title of course
     */
    public void setCourseTitle(String title) {
        this.course.setTitle(title);
    }

    /**
     * @return int field mark
     */
    public int getMark() {
        return marks;
    }

    /**
     * Method for setting field mark.
     *
     * @param marks int field mark
     */
    public void setMark(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Mark: "
                + "id: " + getId()
                + ", student: " + getStudent()
                + ", course: " + getCourse()
                + ", marks: " + getMark();
    }
}
