package com.netcracker.educentr.lahtachev;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
            String result = "", resultChanged = " ";
            String[] data = new String[6];
            for (int i = 0; i < data.length; i++)
                data[i] = null;
            String bookName = null;
            String authorName = null;
            String authorEmail = null;
            String authorGender = null;
            double price = 0;
            int count = 0;

            while (!result.equals(resultChanged)) {
                bookName = checkName(data[0]);
                authorName = checkAuthorName(data[1]);
                authorEmail = checkEmail(data[2]);
                authorGender = checkGender(data[3]);
                price = checkPrice(data[4]);
                count = checkCount(data[5]);
                result = bookName + " " + authorName + " " + authorEmail + " " + authorGender + " " + price + " " + count;
                resultChanged = JOptionPane.showInputDialog(frame, "Вы ответили", result);
                data = resultChanged.split(" ");
            }
            bookName = data[0];
            authorName = data[1];
            authorEmail = data[2];
            authorGender = data[3];
            price = Double.valueOf(data[4]);
            count = Integer.valueOf(data[5]);

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
            String data = null;

            String bookName;
            String authorName;
            String authorEmail;
            String authorGender;
            double price;
            int count;
            int idRow = table.getSelectedRow();
            int idColumn = table.getSelectedColumn();

            if (!m.isEmpty() && idRow != -1 && idColumn != -1) {
                Book cur = m.books.get(idRow);
                switch (idColumn) {
                    case 0:
                        bookName = checkName(data);
                        cur.setName(bookName);
                        break;
                    case 1:
                        authorName = checkAuthorName(data);
                        authorEmail = checkEmail(data);
                        authorGender = checkGender(data);
                        Author tmpAuthor = new Author(authorName, authorEmail, authorGender);
                        cur.setAuthor(tmpAuthor);
                        break;
                    case 2:
                        price = checkPrice(data);
                        cur.setPrice(price);
                        break;
                    case 3:
                        count = checkCount(data);
                        cur.setQty(count);
                        break;
                }
                frame.repaint();
            } else JOptionPane.showMessageDialog(frame, "nothing to change");
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

    private JPanel createButton() {
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


    public String checkName(String data) {
        String bookName = data;
        if (bookName == null)
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

    public String checkAuthorName(String data) {
        String authorName = data;
        if (authorName == null)
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

    public String checkEmail(String data) {
        String authorEmail = data;
        if (authorEmail == null || !authorEmail.contains("@"))
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

    public String checkGender(String data) {
        ImageIcon icon = new ImageIcon();
        ArrayList<String> gender = new ArrayList<>();
        String authorGender;
        gender.add("Male");
        gender.add("Female");
        gender.add("Transgender");

        if (!gender.contains(data)) {
            Object result = JOptionPane.showInputDialog(
                    frame, "Choose author gender :",
                    "Gender",
                    JOptionPane.QUESTION_MESSAGE,
                    icon, gender.toArray(), gender.get(0));
            authorGender = result.toString();
        } else
            authorGender = data;
        return authorGender;
    }

    public double checkPrice(String data) {
        String bookPrice = data;


        double price = 0;
        if (bookPrice == null)
            price = doubleValueCheck();
        else
            try {
                price = Double.parseDouble(bookPrice);
                flag = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "not a number");
                price = doubleValueCheck();
            }

        flag = false;
        return price;
    }

    public int checkCount(String data) {
        String bookCount = data;
        int count = 0;
        if (bookCount == null)
            count = integerValueCheck();
        else
            try {
                count = Integer.parseInt(bookCount);
                flag = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "not a number");
                count = integerValueCheck();
            }
        flag = false;
        return count;
    }

    private double doubleValueCheck() {
        double price = 0;
        String bookPrice;
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
        return price;
    }

    private int integerValueCheck() {
        int count = 0;
        String bookCount;
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
        return count;
    }
}


