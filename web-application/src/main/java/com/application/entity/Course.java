package com.application.entity;

/**
 * Course.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public class Course extends Entity {
    private String title;
    private User teacher;
    private String description;

    /**
     * @return String field title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method for setting field title.
     *
     * @param title String field title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return User field teacher
     */
    public User getTeacher() {
        return teacher;
    }

    /**
     * Method for setting field teacher.
     *
     * @param teacher User field teacher
     */
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    /**
     * Method for setting id of teacher.
     *
     * @param teacherID Long id of teacher
     */
    public void setTeacherID(Long teacherID) {
        this.teacher.setId(teacherID);
    }

    /**
     * Method for setting name of teacher.
     *
     * @param name String ame of teacher
     */
    public void setTeacherName(String name) {
        this.teacher.setName(name);
    }

    /**
     * @return String field description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method for setting field description.
     *
     * @param description String field description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course: "
                + "id: " + getId()
                + ", title: " + getTitle()
                + ", description: " + getDescription();
    }
}
