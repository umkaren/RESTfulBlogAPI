# RESTfulBlogAPI

To get started with the app, create a database/schema in MYSQL.
Go into application properties and edit the datasource.url, datasource.username, and datasource.password to your respective settings.

Run BlogApplication. This will create the table, "blogposts" in your respective database. Once the table is created, the application sshould automatically update the records within.

Once you see Started BlogApplication in X seconds, go to Postman, whether via web or desktop application, to test out the functionality.

//To Create a New Blog Post
enter the local host url ex. http://localhost:8080/api/blogPosts
Select "POST" on the left hand side, then click on body in the middle of the application, then raw.
Within the text box below, format the JSON payload as:
{
  "title": "example title",
  "content": "example blog content",
  "author": "example author"
  }

Then, make sure JSON is selected as the media format and then click "send" to the right of the local host url. If successful, you should get see the JSON object return in the body.

//To Retrieve All Blog Posts
Still within Postman, type in the local host url ex. http://localhost:8080/api/blogPosts and select "GET" on the left hand side. Then click "send" on the right hand side.
This will retrieve all blog posts recorded in the MYSQL database.

//To Retrieve a Blog Post by Id
Within Postman, type in the local host url followed by the post id. ex. http://localhost:8080/api/blogPosts/1.
Make sure "GET" is selected and then click on "send" on the right hand side. This should retrieve the blog post with id of 1. 
If a non-existent id is entered, you should get a message, "Could not find blog post id."

//To Update a Blog Post by ID
Within Postman, type in the local host url followed by the post id. ex. http://localhost:8080/api/blogPosts/1.
Select "PUT" on the left hand side, then click on body in the middle of the application, then raw.
Within the text box below, format the JSON payload as:
{
  "title": "updated title",
  "content": "updated blog content",
  "author": "updated author"
  }

Then, make sure JSON is selected as the media format and then click "send" to the right of the local host url.
If successful, you should get see the updated JSON object return in the body.

//To Delete a Blog Post by ID
Within Postman, type in the local host url followed by the post id. ex. http://localhost:8080/api/blogPosts/1.
Select "DELETE" and then click "send" on the right hand side.
You should then get a "Blog post has been deleted successfully" message in the results body.

The records can be checked in MYSQL WB as the database is updated in real time.
