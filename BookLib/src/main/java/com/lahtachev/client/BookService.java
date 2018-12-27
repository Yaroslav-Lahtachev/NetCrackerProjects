package com.lahtachev.client;

import com.lahtachev.shared.Book;
import com.lahtachev.shared.BookPagination;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("lib/books")
public interface BookService extends RestService {

    @GET
    @Path("/{page}/{booksNum}/{sorting}")
    void getAllBooks(@PathParam("page") int page, @PathParam("booksNum") int booksNum, @PathParam("sorting") String sorting, MethodCallback<BookPagination> callback);

    @POST
    @Path("/add/{page}/{booksNum}/{sorting}")
    @Produces(MediaType.APPLICATION_JSON)
    void addBook(@PathParam("page") int page, @PathParam("booksNum") int booksNum, @PathParam("sorting") String sorting, Book book, MethodCallback<BookPagination> callback);

    @DELETE
    @Path("/delete/{id}/{page}/{booksNum}/{sorting}")
    void deleteBook(@PathParam("page") int page, @PathParam("booksNum") int booksNum, @PathParam("sorting") String sorting, @PathParam("id") int id, MethodCallback<BookPagination> callback);


}