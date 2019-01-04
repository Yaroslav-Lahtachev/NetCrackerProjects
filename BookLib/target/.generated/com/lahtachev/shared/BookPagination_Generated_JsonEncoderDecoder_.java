package com.lahtachev.shared;

public class BookPagination_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.lahtachev.shared.BookPagination> {
  
  public static final BookPagination_Generated_JsonEncoderDecoder_ INSTANCE = new BookPagination_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.lahtachev.shared.BookPagination value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.lahtachev.shared.BookPagination parseValue = (com.lahtachev.shared.BookPagination)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toJSON(parseValue.getBooks(), com.lahtachev.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE), rc, "books");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.encode(parseValue.getSize()), rc, "size");
    return rc;
  }
  
  public com.lahtachev.shared.BookPagination decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.lahtachev.shared.BookPagination rc = new com.lahtachev.shared.BookPagination();
    rc.setBooks(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(object.get("books"), com.lahtachev.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE), null));
    rc.setSize(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.INT.decode(object.get("size")), 0));
    return rc;
  }
  
}
