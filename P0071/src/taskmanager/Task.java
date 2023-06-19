/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

/**
 *
 * @author FPT1174
 */
public class Task {
    private int taskId;
    private String taskTypeId;
    private String requirement;
    private String date;
    private String planStartTime;
    private String planEndTime;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int taskId, String taskTypeId, String requirement, String date, String planStartTime, String planEndTime, String assignee, String reviewer) {
        this.taskId = taskId;
        this.taskTypeId = taskTypeId;
        this.requirement = requirement;
        this.date = date;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}

