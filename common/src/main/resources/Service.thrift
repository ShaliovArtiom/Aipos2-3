namespace java by.bsuir.Shaliov.common.service

include "Models.thrift"

service StudentService {
    void addBookTable( 1: i32 id, 2: string bookName, 3: string authorName, 4: i32 pageValue),
    void renameBookTable( 1: i32 id, 2: string bookName, 3: string authorName, 4: i32 pageValue),
    void deleteBookTable(1: i32 id, 2: string bookName, 3: string authorName, 4: i32 pageValue),
    list<Models.Book> getAllBook ();
}