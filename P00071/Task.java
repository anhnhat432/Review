/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P00071;

/**
 *
 * @author FPT
 */

/**
 *
 * @author THAYCACAC
 */
public class Task {
    private int id;
    private String taskTypeId;
    private String requirementName;
    private String date;
    private String planFrom;
    private String planTo;
    private String assign;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    // Getter và Setter cho thuộc tính 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho thuộc tính 'taskTypeId'
    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    // Getter và Setter cho thuộc tính 'requirementName'
    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    // Getter và Setter cho thuộc tính 'date'
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getter và Setter cho thuộc tính 'planFrom'
    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    // Getter và Setter cho thuộc tính 'planTo'
    public String getPlanTo() {
        return planTo;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    // Getter và Setter cho thuộc tính 'assign'
    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    // Getter và Setter cho thuộc tính 'reviewer'
    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}

