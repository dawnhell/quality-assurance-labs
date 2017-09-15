package services;

import entities.Faculty;
import entities.Group;
import entities.Student;
import entities.University;

import java.util.Scanner;

public class DialogService {
    private University university;

    public DialogService(University university) {
        this.university = university;
        this.showMenu();
        this.handleInput();
    }

    private void showMenu() {
        System.out.println("\nAvailable actions:");
        System.out.println("1) Show faculties;");
        System.out.println("2) Show groups;");
        System.out.println("3) Show students;");
        System.out.println("4) Calculate average marks for student;");
        System.out.println("5) Calculate average marks for group;");
        System.out.println("6) Calculate average marks for faculty;");
        System.out.println("7) Calculate average marks for university;");
    }

    private void handleInput() {
        while (true) {
            try {
                int option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1:
                        this.showFaculty(university.get_faculties());
                        this.showMenu();
                        break;

                    case 2:
                        this.showGroups(university.get_faculties());
                        this.showMenu();
                        break;

                    case 3:
                        this.showStudents(university.get_faculties());
                        this.showMenu();
                        break;

                    case 4:
                        this.calculateAverageForStudent(university.get_faculties());
                        this.showMenu();
                        break;

                    case 5:
                        this.calculateAverageForGroup(university.get_faculties());
                        this.showMenu();
                        break;

                    case 6:
                        this.calculateAverageForFaculty(university.get_faculties());
                        this.showMenu();
                        break;

                    case 7:
                        this.calculateAverageForUniversity(university);
                        this.showMenu();
                        break;

                    default:
                        System.out.println("Unknown parameter.");
                        this.showMenu();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showFaculty(Faculty[] faculties) {
        for (int i = 0; i < faculties.length; ++i) {
            System.out.println("Faculty #" + faculties[i].get_facultyId());
        }
    }

    private void showGroups(Faculty[] faculties) {
        System.out.println("Select faculty:");
        int facultyId = -1;

        try {
            facultyId = new Scanner(System.in).nextInt();
        } catch(Exception e) {
            e.printStackTrace();
        }

        this.showGroupsOfFaculty(facultyId, faculties);
    }

    private void showGroupsOfFaculty(int facultyId, Faculty[] faculties) {
        for (int i = 0; i < faculties.length; ++i) {
            if (faculties[i].get_facultyId() == facultyId) {
                Group[] groups = faculties[i].get_groups();

                System.out.println("Groups of faculty #" + facultyId);
                for (int j = 0; j < groups.length; ++j) {
                    System.out.println("Group #" + groups[i].get_groupId());
                }
            }
        }

    }

    private void showStudents(Faculty[] faculties) {
        int facultyId = -1;
        int groupId   = -1;

        try {
            System.out.println("Select faculty:");
            facultyId = new Scanner(System.in).nextInt();

            this.showGroupsOfFaculty(facultyId, faculties);

            System.out.println("Select group:");
            groupId   = new Scanner(System.in).nextInt();
        } catch(Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < faculties.length; ++i) {
            if (faculties[i].get_facultyId() == facultyId) {
                this.showStudentsOfGroup(groupId, faculties[i].get_groups());
            }
        }
    }

    private void showStudentsOfGroup(int groupId, Group[] groups) {
        for (int i = 0; i < groups.length; ++i) {
            if (groups[i].get_groupId() == groupId) {
                Student[] students = groups[i].get_students();

                System.out.println("Students of group #" + groupId);
                for (int j = 0; j < students.length; ++j) {
                    System.out.println("Student #" + students[i].get_id());
                }
            }
        }
    }

    private void calculateAverageForStudent(Faculty[] faculties) {
        int facultyId = -1;
        int groupId   = -1;
        int studentId = -1;

        try {
            this.showFaculty(faculties);
            System.out.println("Enter student id:");
            facultyId = new Scanner(System.in).nextInt();

            for (int i = 0; i < faculties.length; ++i) {
                if (faculties[i].get_facultyId() == facultyId) {
                    this.showGroupsOfFaculty(facultyId, faculties);
                    System.out.println("Enter group id:");
                    groupId = new Scanner(System.in).nextInt();
                    Group[] groups = faculties[i].get_groups();

                    for (int j = 0; j < groups.length; ++j) {
                        if (groups[j].get_groupId() == groupId) {
                            this.showStudentsOfGroup(groupId, groups);
                            System.out.println("Enter student id:");
                            studentId = new Scanner(System.in).nextInt();
                            Student[] students = groups[j].get_students();

                            for (int k = 0; k < students.length; ++k) {
                                if (students[k].get_id() == studentId) {
                                    System.out.println(
                                        "Average mark of student #" +
                                        studentId +
                                        " is: " +
                                        new CalculationService().getAverageMarksOfStudent(students[k])
                                    );
                                }
                            }
                        }
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageForGroup(Faculty[] faculties) {
        int facultyId = -1;
        int groupId   = -1;

        try {
            this.showFaculty(faculties);
            System.out.println("Enter student id:");
            facultyId = new Scanner(System.in).nextInt();

            for (int i = 0; i < faculties.length; ++i) {
                if (faculties[i].get_facultyId() == facultyId) {
                    this.showGroupsOfFaculty(facultyId, faculties);
                    System.out.println("Enter group id:");
                    groupId = new Scanner(System.in).nextInt();
                    Group[] groups = faculties[i].get_groups();

                    for (int j = 0; j < groups.length; ++j) {
                        if (groups[j].get_groupId() == groupId) {
                            System.out.println(
                                "Average mark of group #" +
                                groupId +
                                " is: " +
                                new CalculationService().getAverageMarksOfGroup(groups[j])
                            );
                        }
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageForFaculty(Faculty[] faculties) {
        int facultyId = -1;

        try {
            this.showFaculty(faculties);
            System.out.println("Enter student id:");
            facultyId = new Scanner(System.in).nextInt();

            for (int i = 0; i < faculties.length; ++i) {
                if (faculties[i].get_facultyId() == facultyId) {
                    System.out.println(
                        "Average mark of faculty #" +
                        facultyId +
                        " is: " +
                        new CalculationService().getAverageMarksOfFaculty(faculties[i])
                    );
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageForUniversity(University university) {
        System.out.println(
            "Average mark of university #" +
            university.get_universityId() +
            " is: " +
            new CalculationService().getAverageMarksOfUniversity(university)
        );
    }
}
