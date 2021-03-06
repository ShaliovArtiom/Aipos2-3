namespace java by.bsuir.Shaliov.common.service

include "Models.thrift"

service BookService {
    void addBookTable(1: string bookName, 2: string authorName, 3: i32 pageValue),
    void renameBookTable( 1: i32 id, 2: string bookName, 3: string authorName, 4: i32 pageValue),
    void deleteBookTable(1: i32 id, 2: string bookName, 3: string authorName, 4: i32 pageValue),
    list<Models.Book> getAllBook ();
}
