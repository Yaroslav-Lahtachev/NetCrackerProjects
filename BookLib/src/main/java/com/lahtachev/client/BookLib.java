package com.lahtachev.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.lahtachev.shared.Book;
import com.lahtachev.shared.BookPagination;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.Date;

public class BookLib implements EntryPoint, DialogBoxOpener {
    private InputDialog dialogBox;
    private VerticalPanel mainPanel = new VerticalPanel();
    private HorizontalPanel addAndPagesPanel = new HorizontalPanel();
    private HorizontalPanel pages = new HorizontalPanel();
    private FlexTable booksFlexTable = new FlexTable();
    private Button add = new Button("add");
    private Button show3 = new Button("3");
    private Button show10 = new Button("10");
    private Button showAll = new Button("all");
    private BookService service = GWT.create(BookService.class);
    private String sorting = "id";
    private int booksNum = -1;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        String root = Defaults.getServiceRoot();
        root = root.replace("BookLib/", "");
        Defaults.setServiceRoot(root);
        createTable();
        mainPanel.add(booksFlexTable);
        addAndPagesPanel.add(add);
        addAndPagesPanel.add(new Label("Show:"));
        show3.removeStyleName("gwt-Button");
        show3.addStyleName("numberOfPagesButton");
        addAndPagesPanel.add(show3);
        show10.removeStyleName("gwt-Button");
        show10.addStyleName("numberOfPagesButton");
        addAndPagesPanel.add(show10);
        showAll.removeStyleName("gwt-Button");
        showAll.addStyleName("numberOfPagesButton");
        addAndPagesPanel.add(showAll);
        addAndPagesPanel.add(pages);
        mainPanel.add(addAndPagesPanel);

        show3.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                booksNum = 3;
                service.getAllBooks(1, booksNum, sorting, new PagingMethodCallBack());
            }
        });
        show10.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                booksNum = 10;
                service.getAllBooks(1, booksNum, sorting, new PagingMethodCallBack());
            }
        });
        showAll.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                booksNum = -1;
                service.getAllBooks(1, booksNum, sorting, new PagingMethodCallBack());
            }
        });

        RootPanel.get("library").add(mainPanel);

        add.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                openInputDialog();

            }
        });

    }


    private void createTable() {

        service.getAllBooks(1, booksNum, sorting, new MethodCallback<BookPagination>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("load failed");
            }

            @Override
            public void onSuccess(Method method, BookPagination bookPagination) {
                drawTable(bookPagination);
            }
        });

    }

    private void drawTable(BookPagination bookPagination) {

        mainPanel.remove(booksFlexTable);
        mainPanel.remove(addAndPagesPanel);
        booksFlexTable = new FlexTable();
        mainPanel.add(booksFlexTable);

        addAndPagesPanel.remove(pages);
        pages = new HorizontalPanel();
        if (booksNum != -1) {
            if (bookPagination.getSize() != 0) {
                int numberPages = bookPagination.getSize() / booksNum;
                if ((bookPagination.getSize() % booksNum) != 0)
                    numberPages++;

                for (int i = 1; i <= numberPages; i++) {
                    final int number = i;
                    Button page = new Button(String.valueOf(number));
                    page.removeStyleName("gwt-Button");
                    page.addStyleName("pageButton");
                    page.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent clickEvent) {
                            service.getAllBooks(number, booksNum, sorting, new MethodCallback<BookPagination>() {
                                @Override
                                public void onFailure(Method method, Throwable throwable) {
                                    Window.alert("change page fail");
                                }

                                @Override
                                public void onSuccess(Method method, BookPagination bookPagination) {
                                    drawTable(bookPagination);
                                }
                            });
                        }
                    });
                    pages.add(page);
                }
            }
            addAndPagesPanel.add(pages);
        }
        mainPanel.add(addAndPagesPanel);


        Button id = new Button("Id");
        id.removeStyleName("gwt-Button");
        id.addStyleName("buttonNotSort");
        if (sorting.equals("id")) id.addStyleName("buttonSort");
        id.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sorting = "id";
                service.getAllBooks(1, booksNum, sorting, new SortMethodCallBack());
            }
        });
        Button author = new Button("Author");
        author.removeStyleName("gwt-Button");
        author.addStyleName("buttonNotSort");
        if (sorting.equals("author")) author.addStyleName("buttonSort");
        author.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sorting = "author";
                service.getAllBooks(1, booksNum, sorting, new SortMethodCallBack());
            }
        });
        Button title = new Button("Title");
        title.removeStyleName("gwt-Button");
        title.addStyleName("buttonNotSort");
        if (sorting.equals("title")) title.addStyleName("buttonSort");
        title.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sorting = "title";
                service.getAllBooks(1, booksNum, sorting, new SortMethodCallBack());
            }
        });
        Button pages = new Button("Pages");
        pages.removeStyleName("gwt-Button");
        pages.addStyleName("buttonNotSort");
        if (sorting.equals("pageNum")) pages.addStyleName("buttonSort");
        pages.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sorting = "pageNum";
                service.getAllBooks(1, booksNum, sorting, new SortMethodCallBack());
            }
        });
        Button published = new Button("Published");
        published.removeStyleName("gwt-Button");
        published.addStyleName("buttonNotSort");
        if (sorting.equals("publishingYear")) published.addStyleName("buttonSort");
        published.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sorting = "publishingYear";
                service.getAllBooks(1, booksNum, sorting, new SortMethodCallBack());
            }
        });
        Button addDate = new Button("Add date");
        addDate.removeStyleName("gwt-Button");
        addDate.addStyleName("buttonNotSort");
        if (sorting.equals("addedDate")) addDate.addStyleName("buttonSort");
        addDate.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                sorting = "addedDate";
                service.getAllBooks(1, booksNum, sorting, new SortMethodCallBack());
            }
        });

        booksFlexTable.setWidget(0, 0, id);
        booksFlexTable.setWidget(0, 1, author);
        booksFlexTable.setWidget(0, 2, title);
        booksFlexTable.setWidget(0, 3, pages);
        booksFlexTable.setWidget(0, 4, published);
        booksFlexTable.setWidget(0, 5, addDate);

        booksFlexTable.getRowFormatter().addStyleName(0, "header");
        booksFlexTable.addStyleName("list");

        for (Book book : bookPagination.getBooks()) {
            addRow(book);
        }

    }


    private void addRow(Book book) {
        int row = booksFlexTable.getRowCount();
        booksFlexTable.setText(row, 0, String.valueOf(book.getId()));
        booksFlexTable.setText(row, 1, book.getAuthor());
        booksFlexTable.setText(row, 2, book.getTitle());
        booksFlexTable.setText(row, 3, String.valueOf(book.getPageNum()));
        booksFlexTable.setText(row, 4, String.valueOf(book.getPublishingYear()));
        booksFlexTable.setText(row, 5, String.valueOf(book.getAddedYear()) + "." +
                String.valueOf(book.getAddedMonth()) + "." +
                String.valueOf(book.getAddedDay()));
        Button delete = new Button("x");
        delete.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                service.deleteBook(1, booksNum, sorting, book.getId(), new MethodCallback<BookPagination>() {
                    @Override
                    public void onFailure(Method method, Throwable throwable) {
                        Window.alert("delete failed");
                    }

                    @Override
                    public void onSuccess(Method method, BookPagination bookPagination) {
                        drawTable(bookPagination);
                    }
                });
            }
        });
        booksFlexTable.setWidget(row, 7, delete);
    }


    class PagingMethodCallBack implements MethodCallback<BookPagination> {

        @Override
        public void onFailure(Method method, Throwable throwable) {
            Window.alert("paging failed");
        }

        @Override
        public void onSuccess(Method method, BookPagination bookPagination) {
            drawTable(bookPagination);
        }
    }

    class SortMethodCallBack implements MethodCallback<BookPagination> {

        @Override
        public void onFailure(Method method, Throwable throwable) {
            Window.alert("sort failed");
        }

        @Override
        public void onSuccess(Method method, BookPagination bookPagination) {
            drawTable(bookPagination);
        }
    }

    private void openInputDialog() {
        dialogBox = new InputDialog();
        dialogBox.setOpener(this);
        dialogBox.center();
        dialogBox.show();
    }

    @Override
    public void dialogBoxCancelled() {

        service.addBook(1, booksNum, sorting, new Book(dialogBox.getAuthor(), dialogBox.getTitle(), dialogBox.getPageNum(), dialogBox.getPublishingYear(), new Date().getYear() + 1900, new Date().getMonth() + 1, new Date().getDate()), new MethodCallback<BookPagination>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
                Window.alert("add failed");
            }

            @Override
            public void onSuccess(Method method, BookPagination bookPagination) {
                drawTable(bookPagination);
            }
        });

    }
}
