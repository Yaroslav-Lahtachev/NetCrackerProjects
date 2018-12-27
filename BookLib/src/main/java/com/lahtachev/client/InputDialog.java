package com.lahtachev.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.*;

public class InputDialog extends DialogBox {

    private DialogBoxOpener opener = null;
    private String author;
    private String title;
    private int pageNum;
    private int publishingYear;

    private Button ok;
    private TextBox authorTextBox;
    private TextBox titleTextBox;
    private TextBox pageNumTextBox;
    private TextBox publishingYearTextBox;


    public InputDialog() {
        // Set the dialog box's caption.
        setText("InputBook");
        setModal(true);
        // Enable animation.
        setAnimationEnabled(true);
        Label authorLabel = new Label("Author Name:");
        authorTextBox = new TextBox();
        authorTextBox.addKeyUpHandler(new MyKeyUpHandler());
        authorTextBox.addStyleName("notvalid");
        Label titleLabel = new Label("Title:");
        titleTextBox = new TextBox();
        titleTextBox.addKeyUpHandler(new MyKeyUpHandler());
        titleTextBox.addStyleName("notvalid");
        Label pagesCountLabel = new Label("Pages Count::");
        pageNumTextBox = new TextBox();
        pageNumTextBox.addKeyUpHandler(new MyKeyUpHandler());
        pageNumTextBox.addStyleName("notvalid");
        Label publishedYearLabel = new Label("Published Year:");
        publishingYearTextBox = new TextBox();
        publishingYearTextBox.addKeyUpHandler(new MyKeyUpHandler());
        publishingYearTextBox.addStyleName("notvalid");
        // DialogBox is a SimplePanel, so you have to set its widget
        // property to whatever you want its contents to be.
        ok = new Button("OK");
        ok.setEnabled(false);
        ok.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                author = authorTextBox.getText();
                title = titleTextBox.getText();
                pageNum = Integer.valueOf(pageNumTextBox.getText());
                publishingYear = Integer.valueOf(publishingYearTextBox.getText());

                InputDialog.this.hide();
                if (opener != null)
                    opener.dialogBoxCancelled();
            }
        });


        HorizontalPanel panel = new HorizontalPanel();
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.setSpacing(10);
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        VerticalPanel authorPanel = new VerticalPanel();
        authorPanel.add(authorLabel);
        authorPanel.add(authorTextBox);
        panel.add(authorPanel);

        VerticalPanel titlePanel = new VerticalPanel();
        titlePanel.add(titleLabel);
        titlePanel.add(titleTextBox);
        panel.add(titlePanel);

        VerticalPanel pagesPanel = new VerticalPanel();
        pagesPanel.add(pagesCountLabel);
        pagesPanel.add(pageNumTextBox);
        panel.add(pagesPanel);

        VerticalPanel yearPanel = new VerticalPanel();
        yearPanel.add(publishedYearLabel);
        yearPanel.add(publishingYearTextBox);
        panel.add(yearPanel);

        verticalPanel.add(panel);
        verticalPanel.add(ok);

        setWidget(verticalPanel);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setOpener(DialogBoxOpener opener) {
        this.opener = opener;
    }

    public class MyKeyUpHandler implements KeyUpHandler {

        @Override
        public void onKeyUp(KeyUpEvent keyUpEvent) {
            author = authorTextBox.getText();
            title = titleTextBox.getText();
            try {
                pageNum = Integer.valueOf(pageNumTextBox.getText());
            } catch (Exception ex) {
                ok.setEnabled(false);
                pageNumTextBox.removeStyleName("valid");
                pageNumTextBox.addStyleName("notvalid");
            }
            try {
                publishingYear = Integer.valueOf(publishingYearTextBox.getText());
            } catch (Exception ex) {
                ok.setEnabled(false);
                publishingYearTextBox.removeStyleName("valid");
                publishingYearTextBox.addStyleName("notvalid");
                ;
            }

            if (author != "") {
                authorTextBox.addStyleName("valid");
            } else {
                ok.setEnabled(false);
                authorTextBox.addStyleName("notvalid");
            }

            if (title != "") {
                titleTextBox.addStyleName("valid");
            } else {
                ok.setEnabled(false);
                titleTextBox.addStyleName("notvalid");
            }

            if (pageNum > -1) {
                pageNumTextBox.removeStyleName("notvalid");
                pageNumTextBox.addStyleName("valid");
            } else {
                ok.setEnabled(false);
                pageNumTextBox.removeStyleName("valid");
                pageNumTextBox.addStyleName("notvalid");
            }

            if (publishingYear < 2019) {
                publishingYearTextBox.removeStyleName("notvalid");
                publishingYearTextBox.addStyleName("valid");
            } else {
                ok.setEnabled(false);
                publishingYearTextBox.removeStyleName("valid");
                publishingYearTextBox.addStyleName("notvalid");
            }
            if ((author != "") && (title != "") && (pageNum > -1) && (publishingYear < 2019)) {
                ok.setEnabled(true);
            }

        }
    }

}
