package com.application.entity;

/**
 * CourseStudent.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class CourseStudent extends Entity {
    private Course course;
    private User student;

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
     * @return String field student
     * @see Course
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
     * Method for setting id of course.
     *
     * @param id Long id of course
     */
    public void setCourseId(Long id) {
        this.course.setId(id);
    }

    /**
     * Method for setting title of course.
     *
     * @param title String title of course
     */
    public void setCourseTile(String title) {
        this.course.setTitle(title);
    }


    /**
     * Method for setting id of student.
     *
     * @param id Long field id of student
     */
    public void setStudentId(Long id) {
        this.student.setId(id);
    }

    /**
     * Method for setting name of student.
     *
     * @param name String name of student
     */
    public void setStudentName(String name) {
        this.student.setName(name);
    }

    @Override
    public String toString() {
        return "CourseStudent: "
                + "course: " + course
                + ", student: " + student;
    }
}
