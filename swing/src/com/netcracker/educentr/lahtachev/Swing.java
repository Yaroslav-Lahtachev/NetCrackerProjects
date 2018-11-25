package com.netcracker.educentr.lahtachev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Swing extends JFrame {
    private JFrame frame;
    public BookModel m = new BookModel();
    public JTable table = new JTable(m);
    boolean flag = false;

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
            String bookName;
            String authorName;
            String authorEmail;
            String authorGender;
            double price;
            int count;

            bookName = checkName();
            authorName = checkAuthorName();
            authorEmail = checkEmail();
            authorGender = checkGender();
            price = checkPrice();
            count = checkCount();
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

    public class changeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            String bookName;
            String authorName;
            String authorEmail;
            String authorGender;
            double price;
            int count;

            int idRow = table.getSelectedRow();
            int idColumn = table.getSelectedColumn();
            Book cur = m.books.get(idRow);
            switch (idColumn) {
                case 0:
                    bookName = checkName();
                    cur.setName(bookName);
                    break;
                case 1:
                    authorName = checkAuthorName();
                    authorEmail = checkEmail();
                    authorGender = checkGender();
                    Author tmpAuthor = new Author(authorName, authorEmail, authorGender);
                    cur.setAuthor(tmpAuthor);
                    break;
                case 2:
                    price = checkPrice();
                    cur.setPrice(price);
                    break;
                case 3:
                    count = checkCount();
                    cur.setQty(count);
                    break;
            }
            frame.repaint();
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

    private JPanel createButton(){
        JButton changeButton = new JButton("Change");
        changeButton.addActionListener(new changeButtonListener());
        JPanel jPanelS = new JPanel(new GridLayout(1, 1, 5, 0));
        jPanelS.add(changeButton);

        return jPanelS;
    }



    public Swing() {
        frame = new JFrame("My Frame");

        frame.setSize(350, 250);
        frame.setLocation(150, 100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jPanelR = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        frame.add(jPanelR, BorderLayout.SOUTH);
        jPanelR.add(createButton());

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







    public String checkName() {
        String bookName = "";
        while (flag != true) {
            bookName = JOptionPane.showInputDialog(
                    "<html><h2>insert book name");
            if (!bookName.isEmpty())
                flag = true;
            else JOptionPane.showMessageDialog(frame, "empty book name");
        }
        flag = false;
        return bookName;
    }

    public String checkAuthorName() {
        String authorName = "";
        while (flag != true) {
            authorName = JOptionPane.showInputDialog(
                    "<html><h2>insert author name");
            if (!authorName.isEmpty())
                flag = true;
            else JOptionPane.showMessageDialog(frame, "empty author name");
        }
        flag = false;
        return authorName;
    }

    public String checkEmail() {
        String authorEmail = "";
        while (flag != true) {
            authorEmail = JOptionPane.showInputDialog(
                    "<html><h2>insert author eMail");
            if (!authorEmail.isEmpty() && authorEmail.contains("@"))
                flag = true;
            else JOptionPane.showMessageDialog(frame, "wrong eMail");
        }
        flag = false;
        return authorEmail;
    }

    public String checkGender() {
        String authorGender = "";
        while (flag != true) {
            authorGender = JOptionPane.showInputDialog(
                    "<html><h2>insert author gender (m/f)");
            if (authorGender.equals("m") || authorGender.equals("f") || authorGender.equals("t"))
                flag = true;
            else JOptionPane.showMessageDialog(frame, "wrong gender");
        }
        flag = false;
        return authorGender;
    }

    public double checkPrice() {
        String bookPrice;
        double price = 0;
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
        return price;
    }

    public int checkCount() {
        String bookCount;
        int count = 0;
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
        flag = false;
        return count;
    }
}


