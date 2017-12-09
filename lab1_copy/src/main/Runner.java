package main;

import entities.University;
import services.DialogService;
import services.FileReaderService;

public class Runner {
    private University    university;

    public Runner() {
        this.createUniversityFromMockData();
        this.initializeDialog();
    }

    private void createUniversityFromMockData() {
        this.university = new FileReaderService().getUniversityFromFile();
    }

    private void initializeDialog() {
        new DialogService(this.university);
    }
}
