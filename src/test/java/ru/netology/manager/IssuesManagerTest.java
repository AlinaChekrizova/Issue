package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;


class IssuesManagerTest {


    private static Issue first = new Issue("Ivan Ivanov", "Provide a Method", "Petr Petrov",
            List.of("component: Groovy, dependencies, status: declined"), 5, 1, true);
    private static Issue second = new Issue("Sergey Sergeev", "Support", "Ivan Ivanov",
            List.of("component: Groovy", "dependencies"), 165, 2, false);
    private static Issue third = new Issue("Ivan Ivanov", "Improve Documentation", "Max Maximov",
            List.of("status: stale", "component: Platform", "component: OTA"), 23, 3, true);
    private static Issue fourth = new Issue("Max Maximov", "Add functions", "Sergey Sergeev",
            List.of("status: blocked", "component: OTA"), 15, 4, true);
    private static Issue fifth = new Issue("Michael Mihailov", "Add tests", "Ivan Ivanov",
            List.of("3rd-party: IntelliJ IDEA", "component: Jupiter", "dependencies"), 423, 5, false);


    static IssuesRepository repository = new IssuesRepository();
    static IssuesManager manager = new IssuesManager(repository);

    @BeforeAll
    public static void init(){
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
        repository.add(fifth);
    }

    @Test
    public void shouldSearchByOpen() {
        List<Issue> actual = manager.searchByOpen();
        List<Issue> expected = List.of(first, third, fourth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByClose() {
        List<Issue> actual = manager.searchByClose();
        List<Issue> expected = List.of(second, fifth);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {

        List<Issue> actual = manager.filterByAuthor("Ivan Ivanov");
        List<Issue> expected = List.of(first, third);


        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {

        List<Issue> actual = manager.filterByLabel("component: Groovy");
        List<Issue> expected = List.of(second);


        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {

        List<Issue> actual = manager.filterByAssignee("Sergey Sergeev");
        List<Issue> expected = List.of(fourth);


        assertEquals(expected, actual);
    }

    @Test
    public void shouldCloseById() {

        manager.closeById(1);

        boolean actual = repository.findById(1).isOpen();

        assertEquals(false, actual);

    }

    @Test
    public void shouldOpenById() {

        manager.openById(5);

        boolean actual = repository.findById(5).isOpen();

        assertEquals(true, actual);
    }


}