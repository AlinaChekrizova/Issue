package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.ArrayList;
import java.util.List;


public class IssuesManager {
    private IssuesRepository repository;

    public IssuesManager(IssuesRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    public List<Issue> searchByOpen() {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.isOpen()) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public List<Issue> searchByClose() {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (!issue.isOpen()) {
                issues.add(issue);
            }
        }
        return issues;
    }


    public List<Issue> filterByAuthor(String author) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAuthor() == author) {
                issues.add(issue);
            }
        }
        return issues;
    }


    public List<Issue> filterByLabel(String searchLabel) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            List<String> labels = issue.getLabels();
            boolean hasLabel = hasLabelIssue(labels, searchLabel);
            if (hasLabel) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public boolean hasLabelIssue(List<String> labels, String searchLabel) {
        for (String label : labels) {
            if (label.equals(searchLabel)) {
                return true;
            }
        }
        return false;
    }

    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAssignee() == assignee) {
                issues.add(issue);
            }
        }
        return issues;
    }

    public void closeById(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(false);
                return;
            }
        }
    }

    public void openById(int id) {
        for (Issue issue : repository.findAll()) {
            if (issue.getId() == id) {
                issue.setOpen(true);
                return;
            }
        }
    }
}













