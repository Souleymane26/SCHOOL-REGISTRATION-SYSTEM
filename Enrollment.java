package org.example;

import university.ui.MainMenu;
import university.util.DataContext;

public class Main {
    public static void main(String[] args) {
        // 1. Load all data (Students, Courses, Sections) into memory
        DataContext data = new DataContext();

        // 2. Start the UI
        new MainMenu(data).start();
    }
}