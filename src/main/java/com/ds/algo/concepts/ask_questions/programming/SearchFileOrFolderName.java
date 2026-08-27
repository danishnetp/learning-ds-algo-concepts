package com.ds.algo.concepts.ask_questions.programming;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SearchFileOrFolderName {
    public static void main(String[] args) {
        DemoFile file1 = new DemoFile("file1.txt");
        DemoFile file2 = new DemoFile("file2.txt");
        DemoFolder folder1 = new DemoFolder("folder1");
        folder1.addFile(file1);
        folder1.addFile(file2);

        DemoFolder folder2 = new DemoFolder("folder2");
        folder2.addFolder(folder1);

        search(folder1, "folder1");
    }

    static void search(DemoFolder folder, String searchQuery) {
        if (folder.getName().equals(searchQuery)) {
            System.out.println("Found folder: " + folder.getName());
            return;
        } else if (folder.getFiles().stream().anyMatch(file -> file.name().equals(searchQuery))) {
            System.out.println("Found file: " + searchQuery);
            return;
        } else {
            for (DemoFolder subFolder : folder.getFolders()) {
                search(subFolder, searchQuery);
            }
        }
        System.out.println("Found not file: " + searchQuery);
    }

    record DemoFile(String name) {
    }

    static class DemoFolder {
        private final String name;
        private final Set<DemoFile> files;
        private final Set<DemoFolder> folders;

        public DemoFolder(String name) {
            this.name = name;
            this.files = new HashSet<>();
            this.folders = new HashSet<>();
        }

        public void addFolder(DemoFolder folder) {
            this.folders.add(folder);
        }

        public void addFile(DemoFile file) {
            this.files.add(file);
        }

        public String getName() {
            return name;
        }

        public Set<DemoFile> getFiles() {
            return files;
        }

        public Set<DemoFolder> getFolders() {
            return Collections.unmodifiableSet(folders);
        }
    }
}
