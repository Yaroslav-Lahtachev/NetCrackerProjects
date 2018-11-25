package com.netcracker.educentr.lahtachev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Swing extends JFrame {
    private JFrame frame;
    public BookModel m = new BookModel();
    public JTable table = new JTable(m);

    public class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);

            try {
                m.removePreviousRecords();
                m.readFromFile(fileOpen.getSelectedFile().getName());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public class RemoveSelectorListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            int idx = table.getSelectedRow();
            m.removeBook(idx);
        }
    }

    public class AdditionalListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            boolean flag = false;
            String bookName = "";
            String authorName = "";
            String authorEmail = "";
            String authorGender = "";
            String bookPrice = "";
            String bookCount = "";
            double price = 0;
            int count = 0;

            while (flag != true) {
                bookName = JOptionPane.showInputDialog(
                        "<html><h2>insert book name");
                if (!bookName.isEmpty())
                    flag = true;
                else JOptionPane.showMessageDialog(frame, "empty book name");
            }
            flag = false;
            while (flag != true) {
                authorName = JOptionPane.showInputDialog(
                        "<html><h2>insert author name");
                if (!authorName.isEmpty())
                    flag = true;
                else JOptionPane.showMessageDialog(frame, "empty author name");
            }
            flag = false;
            while (flag != true) {
                authorEmail = JOptionPane.showInputDialog(
                        "<html><h2>insert author eMail");
                if (!authorEmail.isEmpty() && authorEmail.contains("@"))
                    flag = true;
                else JOptionPane.showMessageDialog(frame, "wrong eMail");
            }
            flag = false;
            while (flag != true) {
                authorGender = JOptionPane.showInputDialog(
                        "<html><h2>insert author gender (m/f)");
                if (authorGender.equals("m") || authorGender.equals("f") || authorGender.equals("t"))
                    flag = true;
                else JOptionPane.showMessageDialog(frame, "wrong gender");
            }
            flag = false;
            while (flag != true) {
                bookPrice = JOptionPane.showInputDialog(
                        "<html><h2>insert book price (it should contain '.')");
                try {
                    price = Double.parseDouble(bookPrice);
                    flag = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "not a number");
                    continue;
                }
            }
            flag = false;
            while (flag != true) {
                bookCount = JOptionPane.showInputDialog(
                        "<html><h2>insert book count");
                try {
                    count = Integer.parseInt(bookCount);
                    flag = true;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "not a number");
                    continue;
                }
            }
            m.addBook(new Book(bookName, new Author(authorName, authorEmail, authorGender), price, count));
        }
    }

    public class saveFileListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showSaveDialog(frame);
            try {
                m.writeToFile(fileOpen.getSelectedFile().getName(), m);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");

        JMenuItem addBook = new JMenuItem("Add book");
        JMenuItem loadFile = new JMenuItem("Load books set");
        JMenuItem removeSelectedRows = new JMenuItem("Remove selected books");
        JMenuItem saveFileChanges = new JMenuItem("Save file changes");

        file.add(loadFile);
        file.add(addBook);
        file.add(removeSelectedRows);
        file.add(saveFileChanges);

        removeSelectedRows.addActionListener(new RemoveSelectorListener());
        loadFile.addActionListener(new OpenMenuListener());
        addBook.addActionListener(new AdditionalListener());
        saveFileChanges.addActionListener(new saveFileListener());

        return file;
    }


    public Swing() {
        frame = new JFrame("My Frame");

        frame.setSize(350, 250);
        frame.setLocation(150, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());

        JScrollPane jScrollPane = new JScrollPane(table);
        frame.setJMenuBar(menuBar);

        frame.add(jScrollPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }
}


