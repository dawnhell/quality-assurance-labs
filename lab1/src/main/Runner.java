package main;

import data.MockData;
import entities.University;
import services.DialogService;

public class Runner {
    private University    university;
    private DialogService dialogService;

    public Runner() {
        this.createUniversityFromMockData();
        this.initializeDialog();
    }

    private void createUniversityFromMockData() {
        this.university = new MockData().initialize();
    }

    private void initializeDialog() {
        this.dialogService = new DialogService(this.university);
    }
}
