# Springboot_practice

Q1:- Handle Api Exception (Use employee)
  1. Name is unqiue but when we try to add duplicate it throws internal error handle using exception handling
  2. When we fetch employees using name if employee is not present it returns empty instead handle using exception handling

Q2:- PaginationAndSorting for efficent database Querying (Use Jpa-pagination)
  (Data for database is present in requirements.txt)
  1. Create a get mapping method to fetch all books from page 1 with size of 3 (http://localhost:8080/books?page=1&size=3).
  2. Add defualt values to page and size and try to sort using bookName.

Q3:- Creating a profile which takes name and profile photo (Use Upload-Image)
  1. MultipartFile by default accepts only 1 mb file search how to make it accepts more than 1mb file
  2. Create a post method which takes name and profile photo and a service to save then in database.
