package com.lahtachev.client;

public class BookService_Generated_RestServiceProxy_ implements com.lahtachev.client.BookService, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("lib/books");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void addBook(int page, int booksNum, java.lang.String sorting, com.lahtachev.shared.Book book, org.fusesource.restygwt.client.MethodCallback<com.lahtachev.shared.BookPagination> callback) {
    final int final_page = page;
    final int final_booksNum = booksNum;
    final java.lang.String final_sorting = sorting;
    final com.lahtachev.shared.Book final_book = book;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/add/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"/"+(""+booksNum== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+booksNum))+"/"+(sorting== null? null : com.google.gwt.http.client.URL.encodePathSegment(sorting))+"")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, "application/json");
    __method.json(com.lahtachev.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE.encode(book));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.lahtachev.shared.BookPagination>(__method, callback) {
        protected com.lahtachev.shared.BookPagination parseResult() throws Exception {
          try {
            return com.lahtachev.shared.BookPagination_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void deleteBook(int page, int booksNum, java.lang.String sorting, int id, org.fusesource.restygwt.client.MethodCallback<com.lahtachev.shared.BookPagination> callback) {
    final int final_page = page;
    final int final_booksNum = booksNum;
    final java.lang.String final_sorting = sorting;
    final int final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/delete/"+(""+id== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+id))+"/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"/"+(""+booksNum== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+booksNum))+"/"+(sorting== null? null : com.google.gwt.http.client.URL.encodePathSegment(sorting))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.lahtachev.shared.BookPagination>(__method, callback) {
        protected com.lahtachev.shared.BookPagination parseResult() throws Exception {
          try {
            return com.lahtachev.shared.BookPagination_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getAllBooks(int page, int booksNum, java.lang.String sorting, org.fusesource.restygwt.client.MethodCallback<com.lahtachev.shared.BookPagination> callback) {
    final int final_page = page;
    final int final_booksNum = booksNum;
    final java.lang.String final_sorting = sorting;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(""+page== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+page))+"/"+(""+booksNum== null? null : com.google.gwt.http.client.URL.encodePathSegment(""+booksNum))+"/"+(sorting== null? null : com.google.gwt.http.client.URL.encodePathSegment(sorting))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.lahtachev.shared.BookPagination>(__method, callback) {
        protected com.lahtachev.shared.BookPagination parseResult() throws Exception {
          try {
            return com.lahtachev.shared.BookPagination_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}
