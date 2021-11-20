package ru.netology.domain;

import java.util.List;

public class Issue{

    private int id;
    private String author;
    private String name;
    private String assignee;
    private List<String> labels;
    private int time;
    private boolean isOpen;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }


    public Issue() {
    }
    public Issue(String author, String name, String assignee, List<String> labels, int time, int id, boolean isOpen) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.assignee = assignee;
        this.labels = labels;
        this.time = time;
        this.isOpen = isOpen;
    }

    public Issue(List<String> labels) {
        this.labels = labels;
    }



}
